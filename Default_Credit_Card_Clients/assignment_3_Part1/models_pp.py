import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import datetime as dt
import os
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
from sklearn.ensemble import RandomForestClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.neighbors import KNeighborsClassifier
from sklearn.ensemble import ExtraTreesClassifier
from sklearn.naive_bayes import BernoulliNB 
from sklearn.metrics import *
import zipfile
from zipfile import ZipFile
from urllib.request import urlopen
from io import BytesIO
import glob
import logging
import datetime
import time
import boto
import boto3
import boto.s3
from boto.s3.key import Key 
import wget
import urllib
from urllib import *

#AWS_ACCESS_KEY_ID = input("AWS_ACCESS_KEY_ID=")
#AWS_SECRET_ACCESS_KEY = input("AWS_SECRET_ACCESS_KEY=")
AWS_ACCESS_KEY_ID = str(sys.argv[1])
AWS_SECRET_ACCESS_KEY = str(sys.argv[2])

url = 'https://s3.amazonaws.com/assignment3datasets/default+of+credit+card+clients.xls'
urllib.request.urlretrieve(url,'default+of+credit+card+clients.xls')


#filename = os.path.join('default+of+credit+card+clients.xls')

#if not os.path.isfile(filename):
#    wget.download(url, out=filename)

dataset = pd.read_excel('default+of+credit+card+clients.xls',header=1)

def check_missing_values(dataset):
    c = dataset.isnull().sum()
    c.to_frame().reset_index()
    for i in range(0, 25):
        
        if(c[i] == 0):
            continue
        else:
            print("Missing value present")
            return False
    return True

def replacing_missing_values(dataset):
	data = check_missing_values(dataset)
	print("Replacing missing value")
	if(data == False):
	    new_data = pd.DataFrame()
	    dataset['limit_bal'].dropna(inplace = True)
	    dataset['sex'].dropna(inplace = True)
	    dataset['education'].dropna(inplace = True)
	    dataset['marriage'].dropna(inplace = True)
	    dataset['age'].dropna(inplace = True)
	    new_data = dataset
	    return new_data
	else:
	    return dataset

def feature_engineering(dataset):
    dataset = replacing_missing_values(dataset)
    print("Feature Engineering")
    #print("yo1")
    dataset.rename(columns={'PAY_0':'PAY_1','default payment next month':'next_month_payment'},inplace=True)
    dataset.columns = map(str.lower, dataset.columns)
    filedu = (dataset.education == 5)|(dataset.education == 6)|(dataset.education == 0)
    dataset.loc[filedu,'education'] = 4  
    filmarra = (dataset.marriage == 0)
    dataset.loc[filmarra,'marriage'] = 3
    fil = (dataset.pay_1 == -2) | (dataset.pay_1 == -1) | (dataset.pay_1 == 0)
    dataset.loc[fil, 'pay_1'] = 0
    fil = (dataset.pay_2 == -2) | (dataset.pay_2 == -1) | (dataset.pay_2 == 0)
    dataset.loc[fil, 'pay_2'] = 0
    fil = (dataset.pay_3 == -2) | (dataset.pay_3 == -1) | (dataset.pay_3 == 0)
    dataset.loc[fil, 'pay_3'] = 0
    fil = (dataset.pay_4 == -2) | (dataset.pay_4 == -1) | (dataset.pay_4 == 0)
    dataset.loc[fil, 'pay_4'] = 0
    fil = (dataset.pay_5 == -2) | (dataset.pay_5 == -1) | (dataset.pay_5 == 0)
    dataset.loc[fil, 'pay_5'] = 0
    fil = (dataset.pay_6 == -2) | (dataset.pay_6 == -1) | (dataset.pay_6 == 0)
    dataset.loc[fil, 'pay_6'] = 0
    dataset['AgeBin'] = pd.cut(dataset['age'], 6, labels = [1,2,3,4,5,6])
    dataset['AgeBin'] = pd.to_numeric(dataset['AgeBin'])
    return dataset

def split_dataset(dataset):
    data = feature_engineering(dataset)
    print("Spliting dataset")
    X = data[['id', 'limit_bal', 'sex', 'education', 'marriage', 'age', 'pay_1',
       'pay_2', 'pay_3', 'pay_4', 'pay_5', 'pay_6', 'bill_amt1', 'bill_amt2',
       'bill_amt3', 'bill_amt4', 'bill_amt5', 'bill_amt6', 'pay_amt1',
       'pay_amt2', 'pay_amt3', 'pay_amt4', 'pay_amt5', 'pay_amt6']]

    y = data['next_month_payment']
    return X, y

def sampling(dataset):
    X,y  = split_dataset(dataset)
    print("Oversampling")
    sm = SMOTE(random_state=12, ratio = 1.0)
    x_res, y_res = sm.fit_sample(X, y)
    return x_res,y_res

def train_test(dataset):
    x_res, y_res = sampling(dataset)
    print("Taining and testing")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test_split(x_res,
                                                    y_res,
                                                    test_size = .2,
                                                    random_state=12)
    return x_train_res, x_val_res, y_train_res, y_val_res
def random_forest(dataset):
    print("Random forest pickling")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
    rf = RandomForestClassifier(n_estimators=40, max_depth=10)
    rf.fit(x_train_res, y_train_res)

    filename = 'rf_model.pckl'
    pickle.dump(rf, open(filename, 'wb'))
 
    # some time later...
 
    # load the model from disk
    RandomForest_model = pickle.load(open(filename, 'rb'))
    return RandomForest_model   

def k_n(dataset):
    print("KNN pickling")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
# instantiate learning model (k = 3)
    knn = KNeighborsClassifier(n_neighbors=4)

# fitting the model
    knn.fit(x_train_res, y_train_res)
    filename = 'knn_model.pckl'
    pickle.dump(knn, open(filename, 'wb'))
 
    # some time later...
 
    # load the model from disk
    K_nearest_model = pickle.load(open(filename, 'rb'))
    return K_nearest_model


def logReg(dataset):
    print("Log Regression pickling")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
# instantiate learning model (k = 3)
    lr = LogisticRegression()

# fitting the model
    lr.fit(x_train_res, y_train_res)
    filename = 'lr_model.pckl'
    pickle.dump(lr, open(filename, 'wb'))
 
    # some time later...
 
    # load the model from disk
    Log_Reg_model = pickle.load(open(filename, 'rb'))
    return Log_Reg_model


def BernouNb(dataset):
    print("Bernoulli pickling")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
# instantiate learning model (k = 3)
    bnb = BernoulliNB()

# fitting the model
    bnb.fit(x_train_res, y_train_res)
    filename = 'bnb_model.pckl'
    pickle.dump(bnb, open(filename, 'wb'))
 
    # some time later...
 
    # load the model from disk
    Bernoulli_Nb_model = pickle.load(open(filename, 'rb'))
    return Bernoulli_Nb_model


def ex_tr(dataset):
    print("Extra Tree Classifier")

    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
# instantiate learning model (k = 3)
    extr = ExtraTreesClassifier(n_estimators = 50, random_state = 123)

# fitting the model
    extr.fit(x_train_res, y_train_res)
    filename = 'extra_tree_model.pckl'
    pickle.dump(extr, open(filename, 'wb'))
 
    # some time later...
 
    # load the model from disk
    Extra_Tree_model = pickle.load(open(filename, 'rb'))
    return Extra_Tree_model



def models(dataset):
    print("Models")
    randomForest_model = random_forest(dataset)
    K_nearest_model = k_n(dataset)
    Log_Reg_model = logReg(dataset)
    Bernoulli_Nb_model = BernouNb(dataset)
    Extra_Tree_model = ex_tr(dataset)
    #ExtraTreez_model = xtraTree(dataset)
    model = [randomForest_model,
             K_nearest_model,
             Log_Reg_model,
             Bernoulli_Nb_model,
             Extra_Tree_model
             #ExtraTreez_model
             #RandomForestClassifier(n_estimators=40, max_depth=10),
             #KNeighborsClassifier(n_neighbors=4),
             #LogisticRegression(),
             #BernoulliNB(),
             #ExtraTreesClassifier(n_estimators = 500 , random_state = 123)
            ]
    #import os
    #here = os.path.dirname(os.path.abspath(__file__)
    #with open(os.path.join("models.pckl"), 'wb') as filename:
    #    for models in model:
    #        print("loop")
    #        pickle.dump(models, filename)
    #        print("dumped")
    return(model)


def fit_model(model, dataset):
    print("Metrics evaluating")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
    print("yo5")
    #model.fit(x_train_res,y_train_res)
    prediction = model.predict(x_val_res)
    f1score = f1_score(y_val_res, prediction)
    accuracy = accuracy_score(y_val_res, prediction)
    cm = confusion_matrix(y_val_res, prediction)
    tp = cm[0][0]
    fp = cm[0][1]
    fn = cm[1][0]
    tn = cm[1][1]
    
    return f1score,accuracy,tp,fp,fn,tn

def accuracyscore(dataset):
	print("Returning scores")
#    models = []
#    #here = os.path.dirname(os.path.abspath(__file__))
#    with open(os.path.join("models.pckl"), 'rb') as filename:
#        while True:
#            try:
#                print("trying")
#                models.append(pickle.load(filename))
#                print("appended")
#            except EOFError:
#                break
#    print(models)
	model = models(dataset)
	accuracy =[]
	model_name =[]
	f1score = []
	true_positive =[]
	false_positive =[]
	true_negative =[]
	false_negative =[]
	for i in range(0,len(model)):
		f,a,tp,fp,fn,tn = fit_model(model[i],dataset)
		model_name.append(str(model[i]).split("(")[0])
		f1score.append(f)
		accuracy.append(a)
		#matrix.append(cm)
		true_positive.append(tp) 
		false_positive.append(fp)
		true_negative.append(fn) 
		false_negative.append(tn)    
	return model_name,f1score,accuracy,true_positive,false_positive,true_negative,false_negative


def performance_metrics(dataset):
    #models()
    print("Ranking of the models")
    summary2 = accuracyscore(dataset)
    print("yo7")
    describe1 = pd.DataFrame(summary2[0],columns = {"Model_Name"})
    describe2 = pd.DataFrame(summary2[1],columns = {"F1_score"})
    describe3 = pd.DataFrame(summary2[2], columns ={"Accuracy_score"})
    describe4 = pd.DataFrame(summary2[3], columns ={"True_Positive"})
    describe5 = pd.DataFrame(summary2[4], columns ={"False_Positive"})
    describe6 = pd.DataFrame(summary2[5], columns ={"True_Negative"})
    describe7 = pd.DataFrame(summary2[6], columns ={"False_Negative"})
    des = describe1.merge(describe2, left_index=True, right_index=True, how='inner')
    des = des.merge(describe3,left_index=True, right_index=True, how='inner')
    des = des.merge(describe4,left_index=True, right_index=True, how='inner')
    des = des.merge(describe5,left_index=True, right_index=True, how='inner')
    des = des.merge(describe6,left_index=True, right_index=True, how='inner')
    des = des.merge(describe7,left_index=True, right_index=True, how='inner')
    final_csv = des.sort_values(ascending=False,by="Accuracy_score").reset_index(drop = True)
    return final_csv


def zipping(path,ziph):
    ziph.write(os.path.join('lr_model.pckl'))
    ziph.write(os.path.join('rf_model.pckl'))
    ziph.write(os.path.join('extra_tree_model.pckl'))
    ziph.write(os.path.join('bnb_model.pckl'))
    ziph.write(os.path.join('knn_model.pckl'))





final_csv = performance_metrics(dataset)
final_csv.to_csv(str(os.getcwd()) + "/Accuracy_error_metrics.csv")  
#zf = zipfile.ZipFile('models.zip','w')
#zipping('/', zf)
#zf.close()


conn = boto.connect_s3(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY)
print("Connected to S3")
'''
except:
    logger.info("Amazon keys are invalid")
    print("Amazon keys are invalid")
    exit()
'''

#Location for the region
loc=boto.s3.connection.Location.DEFAULT

try:

    filename_p1 = ("lr_model.pckl")
    filename_p2 =("rf_model.pckl")
    filename_p3 =("knn_model.pckl")
    filename_p4 = ("bnb_model.pckl")
    filename_p5 =("extra_tree_model.pckl")
    filename_csv = ("Accuracy_error_metrics.csv")
    ts = time.time()
    st = datetime.datetime.fromtimestamp(ts)    
    bucket_name = "assignment3adsteam8"
    #bucket = conn.create_bucket(bucket_name, location=loc)
    s3 = boto3.client(
   			"s3",
   			aws_access_key_id=AWS_ACCESS_KEY_ID,
   			aws_secret_access_key=AWS_SECRET_ACCESS_KEY
   			)
    s3.upload_file(filename_p1, bucket_name , filename_p1)
    s3.upload_file(filename_p2, bucket_name , filename_p2)
    s3.upload_file(filename_p3, bucket_name , filename_p3)
    s3.upload_file(filename_p4, bucket_name , filename_p4)
    s3.upload_file(filename_p5, bucket_name , filename_p5)
    s3.upload_file(filename_csv, bucket_name , filename_csv)

	#key = boto.s3.key.Key(bucket, 'some_file.zip')
	#with open('some_file.zip') as f:
   	#key.send_file(f)
    #filename_p1 = ("lr_model.pckl")
    #filename_p2 =("rf_model.pckl")
    #filename_p3 =("knn_model.pckl")
    #filename_p4 = ("bnb_model.pckl")
    #filename_p5 =("extra_tree_model.pckl")
    #filname_csv = (os.getcwd() + "\Accuracy_error_metrics.csv")

    #print(filename)
    print("S3 bucket successfully created")

    '''
    #Uploading files to the Bucket
    def percent_cb(complete, total):
        sys.stdout.write('.')
        sys.stdout.flush()

    k1 = Key(bucket)
    k1.key = 'lr_model.pckl'
    k2 = Key(bucket)
    k2.key = 'rf_model.pckl'
    k3 = Key(bucket)
    k3.key = 'knn_model.pckl'
    k4 = Key(bucket)
    k4.key = 'bnb_model.pckl'
    k5 = Key(bucket)
    k5.key = 'extra_tree_model.pckl'    
    k6= Key(bucket)
    k6.key = 'accuracy.csv'
    k1.set_contents_from_filename(filename_p1, cb=percent_cb, num_cb=10)
    k2.set_contents_from_filename(filename_p2, cb=percent_cb, num_cb=10)
    k3.set_contents_from_filename(filename_p3, cb=percent_cb, num_cb=10)
    k4.set_contents_from_filename(filename_p4, cb=percent_cb, num_cb=10)
    k5.set_contents_from_filename(filename_p5, cb=percent_cb, num_cb=10)
    k6.set_contents_from_filename(filname_csv, cb=percent_cb,  num_cb=10)
	'''
    print("Model successfully uploaded to S3")
except Exception as e:
    print(e)
'''
S3_BUCKET = "fileuploadshantanudeosthale"
S3_Access_Key= input("Access_Key = ")
S3_Secret_Key= input("Secret_Key = ")

s3 = boto3.client(
  "s3",
  aws_access_key_id= S3_Access_Key,
  aws_secret_access_key= S3_Secret_Key
)

def upload_file_to_s3(file, bucket_name, acl="public-read"):
    try:

       s3.upload_fileobj(
           file,
           bucket_name,
           ExtraArgs={
               "ACL": acl
           }
       )

    except Exception as e:
       # This is a catch all exception, edit this part to fit your needs.
       print("Something Happened: ", e)
       
       return e
    return ("Successfully Uploaded")

dir_name = os.getcwd()
filename = "models.pckl"
file_path = os.path.join(dir_name, filename)
try:
    output = upload_file_to_s3(filename, S3_BUCKET)

except Exception as e:
    print(e)
    
'''

from airflow import DAG
from airflow.operators.bash_operator import BashOperator
from airflow.operators.python_operator import PythonOperator
from datetime import timedelta

default_args = {
    'owner' = 'milony'
    'depends_on_past' = False
    'start_date' = dt(2018,4,12)
    'retries' = 1
    'retry_delay': timedelta(minutes=1)
}


dag = DAG('Problem1', default_args=default_args)

t1 = BashOperator(
    task_id='task_1',
    bash_command='echo "sudo docker run milony/img1 %s %s", %AWS_ACCESS_KEY_ID %AWS_SECRET_ACCESS_KEY',
    dag=dag)
    
    