import flask
from flask import Flask, render_template, request, url_for, redirect, flash, jsonify, json, send_file
import sys
from werkzeug.utils import secure_filename
import pandas as pd
import numpy as np
import os
import boto3, botocore, time
from boto3.s3.transfer import S3Transfer
from boto.s3.connection import S3Connection
from sklearn.linear_model import LogisticRegression
from boto.s3.key import Key
import glob
import zipfile
from zipfile import ZipFile
import pickle
import sys
#%matplotlib inline
import imblearn
from imblearn.pipeline import make_pipeline as make_pipeline_imb
from imblearn.over_sampling import SMOTE
from imblearn.under_sampling import NearMiss
from imblearn.metrics import classification_report_imbalanced
from sklearn.metrics import precision_score, recall_score, f1_score, roc_auc_score, accuracy_score, classification_report
from sklearn.cross_validation import train_test_split
app = Flask(__name__) 
S3_KEY = sys.argv[1]
S3_SECRET_ACCESS_KEY = sys.argv[2]
S3_BUCKET = "assignment3adsteam8"
s3 = boto3.client(
   "s3",
   aws_access_key_id=S3_KEY,
   aws_secret_access_key=S3_SECRET_ACCESS_KEY
)
def upload_file_to_s3(file, bucket_name, acl="public-read"):


    try:

        s3.upload_fileobj(
            file,
            bucket_name,
            file.filename,
            ExtraArgs={
                "ACL": acl,
                "ContentType": file.content_type
            }
        )

    except Exception as e:
        # This is a catch all exception, edit this part to fit your needs.
        print("Something Happened: ", e)
        return e
    return secure_filename(file.filename)
@app.route('/')
def homepage():

	print("I am in homepage")
	return render_template("main.html")
	
@app.route('/dashboard/' , methods=["GET", "POST"])
def dashboard():
	print("dashhhhhhhhhhhhh")
	try:
		if request.method == "POST":
			attempted_username= request.form['username']
			attempted_password = request.form['password'] 
			if attempted_username == "team8" and attempted_password == "team8":
				return render_template("dashboard.html")
			else:
				error = "Invalid Credentails"
		return render_template("main.html" , error= error)		
	except Exception as e:
		return render_template("main.html" , error = error)
@app.route('/upload_csv/' , methods=["GET", "POST"])
def upload_csv():
	try:
		if request.method == "POST":
			return render_template("upload_csv.html")
		else:
			error = "Not Valid"
		return render_template("dashboard.html" , error= error)
	except:
		return render_template("dashboard.html" , error= error)
@app.route('/fill_form/' , methods=["GET", "POST"])
def fill_form():
	try:
		if request.method == "POST":
			return render_template("fill_form.html")
		else:
			return render_template("dashboard.html")
	except:
		return render_template("dashboard.html")
@app.route('/prediction_form/' , methods=["POST"])
def prediction_form():
    if request.method == "POST":
        conn = S3Connection(S3_KEY, S3_SECRET_ACCESS_KEY)
        b = conn.get_bucket(S3_BUCKET)
        for obj in b.get_all_keys():
            trial = obj.get_contents_to_filename(obj.key)
        Id = request.form.get("id")
        limit = request.form.get("limit_bal")
        sex = request.form.get("sex")
        education = request.form.get("education")
        marriage =  request.form.get("marriage")
        age = request.form.get("age")
        pay0 = request.form.get("pay0")
        pay1 = request.form.get("pay1")
        pay2 = request.form.get("pay2")
        pay3 = request.form.get("pay3")
        pay4 = request.form.get("pay4")
        pay5 = request.form.get("pay5")
        pay6 = request.form.get("pay6")
        bill_amt1 = request.form.get("bill_amt1")
        bill_amt2 = request.form.get("bill_amt2")
        bill_amt3 = request.form.get("bill_amt3")
        bill_amt4 = request.form.get("bill_amt4")
        bill_amt5 = request.form.get("bill_amt5")
        bill_amt6 = request.form.get("bill_amt6")
        payment1 =  request.form.get("payment1")
        payment2 =  request.form.get("payment2")
        payment3 =  request.form.get("payment3")
        payment4 =  request.form.get("payment4")
        payment5 =  request.form.get("payment5")
        #payment6 =  request.form.get("payment6")
        X = [[ Id , limit , sex , education , marriage , age , pay0 , pay1 , pay2 , pay3 , pay4 , pay5,  pay6 , bill_amt1 , bill_amt2 , bill_amt3 , bill_amt4 , bill_amt5 , bill_amt6
         , payment1 , payment2, payment3 , payment4 , payment5]]
        print(Id)
        print(X)
        var = pd.DataFrame(X)
        print("!st" , var[0])
        print(var.values)
        var = var.astype('int64')
        print(var.dtypes)
        print(var)
        lr_Model = pickle.load((open('lr_model.pckl', 'rb')))
        extra_tree_Model = pickle.load(open('extra_tree_model.pckl', 'rb'))
        knn_Model = pickle.load(open('knn_model.pckl', 'rb'))
        rf_Model = pickle.load(open('rf_model.pckl', 'rb'))
        bnb_Model = pickle.load(open('bnb_model.pckl', 'rb')) 
        prediction1 = rf_Model.predict(var) 
        prediction2 = lr_Model.predict(var)
        prediction3 = extra_tree_Model.predict(var)
        prediction4 = knn_Model.predict(var)
        prediction5 = bnb_Model.predict(var)
        #a = map(float,a)
        #b = map(float,b) 
        print(prediction1)
        print(prediction2)
        print(prediction4)
        print(prediction5)
        y = [prediction1 , prediction2, prediction3 , prediction4 , prediction5]
        Y = pd.DataFrame(y)
        y1 = pd.DataFrame(y[0], columns= {"Predicted value rf_model"})
        y2 = pd.DataFrame(y[1], columns= {"Predicted value lr_model"})
        y3 = pd.DataFrame(y[2], columns= {"Predicted value extra_tree_model"})
        y4 = pd.DataFrame(y[3], columns= {"Predicted value knn_model"})
        y5 = pd.DataFrame(y[4], columns= {"Predicted value bnb_model"})
        csv = y1.merge(y2, left_index = True, right_index = True , how= 'inner')
        csv = csv.merge(y3, left_index = True, right_index = True , how= 'inner')
        csv = csv.merge(y4, left_index = True, right_index = True , how= 'inner')
        csv = csv.merge(y5, left_index = True, right_index = True , how= 'inner')
        csv.to_csv(str(os.getcwd()) + "/Prediction Matrix.csv")
        return render_template("form_success.html", y = y)
        #a = map(float,a)
        #b = map(float,b) 
        #print(prediction)
    else:
        print("not predicted")
		
       
@app.route('/restAPI_calls/' , methods=["POST"])		
def restAPI_calls():
	# A
    if "filename" not in request.files:
        return "No user_file key in request.files"

	# B
    file = request.files["filename"]

	# C.
    if file.filename == "":
        return "Please select a file"

	# D.
    if file:    
        
        filename = secure_filename(file.filename)
        dir_name = 'uploads/'
        if not os.path.exists(dir_name):
        	os.makedirs(dir_name)
        file_path = os.path.join(dir_name, filename)
        file.save(file_path)
        try:

	        output = upload_file_to_s3(file, S3_BUCKET)
	        print(output)
	        dataset = pd.read_csv(file_path,header = 1)
	        print(dataset)
        	conn = S3Connection(S3_KEY, S3_SECRET_ACCESS_KEY)
        	b = conn.get_bucket(S3_BUCKET)
        	for obj in b.get_all_keys():
        		trial = obj.get_contents_to_filename(obj.key) 
        except Exception as e:
            print(e)      
        lr_Model = pickle.load(open('lr_model.pckl', 'rb'), encoding = 'bytes')
        extra_tree_Model = pickle.load(open('extra_tree_model.pckl', 'rb'), encoding = 'bytes')
        knn_Model = pickle.load(open('knn_model.pckl', 'rb'), encoding = 'bytes')
        rf_Model = pickle.load(open('rf_model.pckl', 'rb'), encoding = 'bytes')
        bnb_Model = pickle.load(open('bnb_model.pckl', 'rb'), encoding = 'bytes') 
        prediction1 = rf_Model.predict(dataset.iloc[:,:-1]) 
        prediction2 = lr_Model.predict(dataset.iloc[:,:-1])
        prediction3 = extra_tree_Model.predict(dataset.iloc[:,:-1])
        prediction4 = knn_Model.predict(dataset.iloc[:,:-1])
        prediction5 = bnb_Model.predict(dataset.iloc[:,:-1]) 
        print(prediction1)
        print(prediction2)
        print(prediction4)
        print(prediction5)
        y = [prediction1 , prediction2, prediction3 , prediction4 , prediction5 ]
        #Y1 = pd.DataFrame(prediction_uploadcsv, columns = {"Rf Model" ,"LR Model" , "Extra Tree Model" , "Knn Model" , "Bernoulli Model"})
        y1 = pd.DataFrame(y[0], columns= {"Predicted value rf_model"})
        y2 = pd.DataFrame(y[1], columns= {"Predicted value lr_model"})
        y3 = pd.DataFrame(y[2], columns= {"Predicted value extra_tree_model"})
        y4 = pd.DataFrame(y[3], columns= {"Predicted value knn_model"})
        y5 = pd.DataFrame(y[4], columns= {"Predicted value bnb_model"})
        csv = y1.merge(y2, left_index = True, right_index = True , how= 'inner')
        csv = csv.merge(y3, left_index = True, right_index = True , how= 'inner')
        csv = csv.merge(y4, left_index = True, right_index = True , how= 'inner')
        csv = csv.merge(y5, left_index = True, right_index = True , how= 'inner')
        csv.to_csv(str(os.getcwd()) + "/Prediction_uploadcsv.csv")
        return render_template("Csv_Success.html", y=y)       	
        
    else:
    	return render_template("404.html")
    return render_template("success.html")

if __name__ == "__main__":
	app.run(host='0.0.0.0',port=80)
	


