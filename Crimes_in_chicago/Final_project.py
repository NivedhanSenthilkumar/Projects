import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import datetime as dt
import os
import pickle
import sys
import imblearn
from imblearn.pipeline import make_pipeline as make_pipeline_imb
from imblearn.under_sampling import RandomUnderSampler
from imblearn.over_sampling import SMOTE
from imblearn.under_sampling import NearMiss
from imblearn.metrics import classification_report_imbalanced
from sklearn.metrics import precision_score, recall_score, f1_score, roc_auc_score, accuracy_score, classification_report
from sklearn.cross_validation import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.neighbors import KNeighborsClassifier
from sklearn.ensemble import ExtraTreesClassifier
from sklearn.naive_bayes import BernoulliNB, GaussianNB
from sklearn.metrics import *
import zipfile
from zipfile import ZipFile
import urllib
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


AWS_ACCESS_KEY_ID = str(sys.argv[1])
AWS_SECRET_ACCESS_KEY = str(sys.argv[2])

url = "https://s3.amazonaws.com/adsfinalproject/Chicago_Crimes_2012_to_2017.csv"
urllib.request.urlretrieve(url,'project.csv')
data = pd.read_csv('project.csv')

def data_retrieve(url):
    urllib.request.urlretrieve(url,'project.csv')
    data = pd.read_csv('project.csv')
    return data

def check_missing_values(dataset):
    c = dataset.isnull().sum()
    c.to_frame().reset_index()
    for i in range(0, 23):
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
        dataset.dropna(subset=['Community Area'], how = 'any', inplace = True)
        dataset.dropna(subset=['Case Number'], how = 'any', inplace = True)
        dataset.dropna(subset=['Ward'], how = 'any', inplace = True)
        dataset.dropna(subset=['District'], how = 'any', inplace = True)
        dataset.dropna(subset=['X Coordinate'], how = 'any', inplace = True)
        dataset.dropna(subset=['Y Coordinate'], how = 'any', inplace = True)
        dataset.dropna(subset=['Latitude'], how = 'any', inplace = True)
        dataset.dropna(subset=['Longitude'], how = 'any', inplace = True)
        dataset.dropna(subset=['Location'], how = 'any', inplace = True)
        dataset.drop(['Updated On'], axis = 1, inplace = True)
        max_browser = pd.DataFrame(dataset.groupby('Location Description').size().rename('cnt')).idxmax()[0]
        dataset['Location Description'] = dataset['Location Description'].fillna(max_browser)
        new_data = dataset
        return new_data
    else:
        return dataset

def feature_engineering(dataset):
    dataset = replacing_missing_values(dataset)
    print("Feature Engineering")
    dataset['Primary Type'].replace(['NON - CRIMINAL'], ['NON-CRIMINAL'], inplace=True)
    dataset['Date'] = pd.to_datetime(dataset['Date'])
    #dataset['Updated On'] = pd.to_datetime(dataset['Updated On'])
    dataset['Day']=dataset['Date'].dt.weekday_name
    dataset['Hour']=dataset['Date'].dt.hour
    dataset['Month']=dataset['Date'].dt.month
    dataset['Year'] = dataset['Date'].dt.year
    #dataset.drop(['Unnamed: 0'], axis = 1)
    dataset['Primary Type'] = dataset['Primary Type'].astype('category')
    dataset['Primary_Label'] = dataset['Primary Type'].cat.codes
    return dataset


def split_dataset(dataset):
    data = feature_engineering(dataset)
    print("Spliting dataset")
    X=data[['Domestic', 'Beat','District', 'Ward', 'Community Area', 'Year', 'Primary_Label']]
    y=data[['Arrest']]
    return X, y

def sampling(dataset):
    X,y  = split_dataset(dataset)
    print("Under Sampling")
    rus = NearMiss(random_state = 42)
    x_res, y_res = rus.fit_sample(X, y)
    #sm = SMOTE(random_state=12, ratio = 1.0)
    #x_res, y_res = sm.fit_sample(X, y)
    return x_res,y_res


def train_test(dataset):
    x_res, y_res = sampling(dataset)
    print("Training and testing")
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


def GaussiNb(dataset):
    print("Bernoulli pickling")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
# instantiate learning model (k = 3)
    bnb = GaussianNB()

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

    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)

    rf = RandomForestClassifier(n_estimators=40, max_depth=10)
    rf.fit(x_train_res, y_train_res)
    filename = 'rf_model.pckl'
    pickle.dump(rf, open(filename, 'wb'))
    # some time later...
    # load the model from disk
    RandomForest_model = pickle.load(open(filename, 'rb'))
    print("RandomForestClassifier")

    knn = KNeighborsClassifier(n_neighbors=4)
    # fitting the model
    knn.fit(x_train_res, y_train_res)
    filename = 'knn_model.pckl'
    pickle.dump(knn, open(filename, 'wb'))
    # some time later...
    # load the model from disk
    K_nearest_model = pickle.load(open(filename, 'rb'))
    print("KNeighborsClassifier")

    lr = LogisticRegression()
    # fitting the model
    lr.fit(x_train_res, y_train_res)
    filename = 'lr_model.pckl'
    pickle.dump(lr, open(filename, 'wb'))
    # some time later...
    # load the model from disk
    Log_Reg_model = pickle.load(open(filename, 'rb'))
    print("LogisticRegression")


    bnb = GaussianNB()
    # fitting the model
    bnb.fit(x_train_res, y_train_res)
    filename = 'bnb_model.pckl'
    pickle.dump(bnb, open(filename, 'wb'))
     # some time later...
     # load the model from disk
    Bernoulli_Nb_model = pickle.load(open(filename, 'rb'))
    print("BernoulliNB")

    extr = ExtraTreesClassifier(n_estimators = 50, random_state = 123)
    # fitting the model
    extr.fit(x_train_res, y_train_res)
    filename = 'extra_tree_model.pckl'
    pickle.dump(extr, open(filename, 'wb'))
     # some time later...
     # load the model from disk
    Extra_Tree_model = pickle.load(open(filename, 'rb'))
    print("ExtraTreesClassifier")
    
    #randomForest_model = random_forest(dataset)
    #K_nearest_model = k_n(dataset)
    #Log_Reg_model = logReg(dataset)
    #Bernoulli_Nb_model = BernouNb(dataset)
    #Extra_Tree_model = ex_tr(dataset)
    #ExtraTreez_model = xtraTree(dataset)
    model = [RandomForest_model,
             K_nearest_model,
             Log_Reg_model,
             Bernoulli_Nb_model,
             Extra_Tree_model
             ]
    return(model)

def fit_model(model, dataset):
    print("Metrics evaluating")
    x_train_res, x_val_res, y_train_res, y_val_res = train_test(dataset)
    print("Model fitting")
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
        true_positive.append(tp) 
        false_positive.append(fp)
        true_negative.append(fn) 
        false_negative.append(tn)    
    return model_name,f1score,accuracy,true_positive,false_positive,true_negative,false_negative


def performance_metrics(dataset):
    print("Ranking of the models")
    summary2 = accuracyscore(dataset)
    print("Accuracy Score")
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


final_csv = performance_metrics(data)
final_csv.to_csv(str(os.getcwd()) + "/Accuracy_error_metrics.csv")  


# AWS UPLOADS

conn = boto.connect_s3(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY)
print("Connected to S3")

loc=boto.s3.connection.Location.DEFAULT

try:

    filename_p1 = ("lr_model.pckl")
    filename_p2 =("rf_model.pckl")
    filename_p3 =("knn_model.pckl")
    filename_p4 = ("bnb_model.pckl")
    filename_p5 =("extra_tree_model.pckl")
    filename_csv = ("Accuracy_error_metrics.csv")
    #ts = time.time()
    #st = datetime.datetime.fromtimestamp(ts)    
    bucket_name = "finalprojectteam8"
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

   
    print("S3 bucket successfully created")

    print("Model successfully uploaded to S3")
except Exception as e:
    print(e)
