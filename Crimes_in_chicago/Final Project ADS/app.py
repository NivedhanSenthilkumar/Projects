from flask import Flask, render_template, json, request, flash,session, make_response, Markup, send_file
import pandas as pd
from matplotlib.figure import Figure
import matplotlib.pyplot as plt
import numpy as np
from boto3.s3.transfer import S3Transfer
from boto.s3.connection import S3Connection
import boto
import boto3
import boto.s3
from boto.s3.key import Key 
import pickle
import datetime as dt
import io
import os
import pandas as pd
from werkzeug.utils import secure_filename
import base64
import urllib.request
import sys
app = Flask(__name__)
print("I ran")
app.secret_key = 'Shantanu06'
name =[]
username = []
password = []
S3_BUCKET = "finalprojectteam8"
S3_KEY = str(sys.argv[1])
S3_SECRET_ACCESS_KEY = str(sys.argv[2])
role = ["User" , "Police"]
print(role)
url = "https://s3.amazonaws.com/adsfinalproject/Chicago_Crimes_2012_to_2017.csv"
urllib.request.urlretrieve(url, 'Chicago_Crimes_2012_to_2017.csv')
try:
    crimes = pd.read_csv('Chicago_Crimes_2012_to_2017.csv' , error_bad_lines = False)
except Exception as e:
    print(str(e))
conn = S3Connection(S3_KEY, S3_SECRET_ACCESS_KEY)
b = conn.get_bucket(S3_BUCKET)
for obj in b.get_all_keys():
    trial = obj.get_contents_to_filename(obj.key)
@app.route("/")
def main():
    return render_template("index.html")
@app.route("/graph/", methods=["POST"])
def graph():
    

    crimes.Date = pd.to_datetime(crimes.Date, format='%m/%d/%Y %I:%M:%S %p')  
    crimes.index = pd.DatetimeIndex(crimes.Date)
    if(request.form['EDA'] == "Primary Type"):
        plt.figure(figsize=(8,10))
        crimes.groupby([crimes['Primary Type']]).size().sort_values(ascending=True).plot(kind='barh')
        plt.title('Number of crimes by type')
        plt.ylabel('Crime Type')
        plt.xlabel('Number of crimes')
        
        img = io.BytesIO()
        img.seek(0)
        plt.savefig(img, format='png')
        plot_url = base64.b64encode(img.getvalue()).decode()

        return '<img src="data:image/png;base64,{}">'.format(plot_url)


    elif(request.form['EDA'] == "Month"):
        crimes.groupby([crimes.index.month]).size().plot(kind='barh')
        plt.ylabel('Months')
        plt.xlabel('Number of crimes')
        plt.title('Number of crimes by Month ')
        
        img = io.BytesIO()
        img.seek(0)
        plt.savefig(img, format='png')
        plot_url = base64.b64encode(img.getvalue()).decode()

        return '<img src="data:image/png;base64,{}">'.format(plot_url)

    elif(request.form['EDA'] == "Week"):
        days = ['Monday','Tuesday','Wednesday',  'Thursday', 'Friday', 'Saturday', 'Sunday']
        crimes.groupby([crimes.index.dayofweek]).size().plot(kind='barh')
        plt.figure(figsize=(11,5))
        plt.ylabel('Days of the week')
        plt.yticks(np.arange(7), days)
        plt.xlabel('Number of crimes')
        plt.title('Number of crimes by day of the week')
        img = io.BytesIO()
        img.seek(0)
        plt.savefig(img, format='png')
        plot_url = base64.b64encode(img.getvalue()).decode()

        return '<img src="data:image/png;base64,{}">'.format(plot_url)
    elif(request.form['EDA'] == "Location Description"):
        plt.figure(figsize=(8,10))
        crimes.groupby([crimes['Location Description']]).size().sort_values(ascending=True).plot(kind='barh')
        plt.title('Number of crimes by Location')
        plt.ylabel('Crime Location')
        plt.xlabel('Number of crimes')
        
        img = io.BytesIO()
        img.seek(0)
        plt.savefig(img, format='png')
        plot_url = base64.b64encode(img.getvalue()).decode()

        return '<img src="data:image/png;base64,{}">'.format(plot_url)
    elif(request.form['EDA'] == "cpm1"):


        img = io.BytesIO()
        plt.figure(figsize=(11,5))
        crimes_count_date = crimes.pivot_table('ID', aggfunc=np.size, columns='Primary Type', index=crimes.index.date, fill_value=0)
        crimes_count_date.index = pd.DatetimeIndex(crimes_count_date.index)
        plo = crimes_count_date.rolling(365).sum().plot(figsize=(12, 30), subplots=True, layout=(-1, 3), sharex=False, sharey=False)
        plt.xticks(rotation = 90)
        #plt.title('Crimes Seperated by types and its occurance in the years')
        plt.savefig(img, format='png')
        img.seek(0)

        plot_url = base64.b64encode(img.getvalue()).decode()

        return '<img src="data:image/png;base64,{}">'.format(plot_url)
    elif(request.form['EDA'] == "cpm"):
        plt.figure(figsize=(11,5))
        img = io.BytesIO()
        crimes.resample('M').size().plot(legend=False)
        plt.title('Crime Rate Per Year (2008 - 2016)')
        plt.xlabel('Months')
        plt.ylabel('Number of crimes')
        plt.savefig(img, format='png')
        img.seek(0)
        plot_url = base64.b64encode(img.getvalue()).decode()
        return '<img src="data:image/png;base64,{}">'.format(plot_url)

@app.route('/showSignUp/')
def showSignUp():
    return render_template('signup.html')
@app.route('/showSignin/')
def showSignin():
    return render_template('signin.html')  
@app.route('/showSignOut/', methods=['POST'])
def signOut():
    session.pop('username_form')
    flash("You are Successfully Logged Out")
    return render_template('signin.html')           
@app.route('/signUp/',methods=['POST'])
def signUp():

    Name = request.form['inputName']
    Username = request.form['inputEmail']
    Password = request.form['inputPassword']
    if(Username in username):
        flash("Username Exists")
        return render_template("signup.html")
    else:
        name.append(Name)
        username.append(Username)
        password.append(Password)
        print(name)
        print(username)
        print(password)
        flash("You Are Successfully Signed up, Please Login to Proceed")
        return render_template("signup.html")
@app.route('/signIn_Police/', methods=["GET","POST"])
def signIn():
    naam = request.form['inputName']
    naam1 = request.form['inputName']
    Role = request.form['role']
    print(Role)
    if(Role == "Police"):
        if((request.form['inputEmail'] in username) & (request.form['inputPassword'] in password)):
            return render_template('loggedin_police.html' , naam= naam)
        else:
            flash("Something went wrong")
            return render_template("signin.html" )
    if(Role == "User"):
        print("Went in")
        if((request.form['inputEmail'] in username) & (request.form['inputPassword'] in password)):
            return render_template('loggedin_user.html' , naam1=naam1)

        else:
            flash("Something went wrong")
            return render_template("signin.html" )
@app.route('/fill_form/', methods=['POST'])
def fill_form():
    locationd = crimes['Location Description'].unique()
    return render_template('fill_form.html',username = username, locationd = locationd)

@app.route("/upload_csv/", methods = ["POST"])
def upload_csv():
    if request.method == "POST":
        return render_template("upload_csv.html")
    else: 
        return render_template("loggedin.html")
@app.route('/prediction_form/', methods=['POST'])
def prediction_form():
    try:
        if request.method == "POST":
            if(request.form['District'] == "1"):
                beat_Count = "19"
            elif(request.form['District'] == "2"):
                beat_Count = "29"
            elif(request.form['District'] == "3"):
                beat_Count = "17"
            elif(request.form['District'] == "4"):
                beat_Count = "14"
            elif(request.form['District'] == "5"):
                beat_Count = "10"
            elif(request.form['District'] == "6"):
                beat_Count = "17"
            elif(request.form['District'] == "7"):
                beat_Count = "20"
            elif(request.form['District'] == "8"):
                beat_Count = "17"
            elif(request.form['District'] == "9"):
                beat_Count = "23"
            elif(request.form['District'] == "10"):
                beat_Count = "15"
            elif(request.form['District'] == "11"):
                beat_Count = "19"
            elif(request.form['District'] == "12"):
                beat_Count = "36"
            elif(request.form['District'] == "14"):
                beat_Count = "16"
            elif(request.form['District'] == "15"):
                beat_Count = "13"
            elif(request.form['District'] == "16"):
                beat_Count = "23"
            elif(request.form['District'] == "17"):
                beat_Count = "10"
            elif(request.form['District'] == "18"):
                beat_Count = "17"
            elif(request.form['District'] == "19"):
                beat_Count = "29"
            elif(request.form['District'] == "20"):
                beat_Count = "11"
            elif(request.form['District'] == "22"):
                beat_Count = "15"
            elif(request.form['District'] == "24"):
                beat_Count = "10"
            elif(request.form['District'] == "25"):
                beat_Count = "18"
            Primary_Type = request.form['Crime_Type']
            Primary_Type = int(Primary_Type)
            Ward = request.form['ward']
            Ward = float(Ward)
            District = request.form['District']
            District = float(District)
            Community = request.form['Community']
            Community = float(Community)
            Domestic = request.form['Domestic']
            print(Domestic)
            Domestic = bool(Domestic)
            print(Domestic)
            Beat = request.form['Beat']
            Beat = int(Beat)
            Date = request.form['Date']
            Year = Date.split("-")[0]
            Year = int(Year)
            X = [[Domestic, Beat, Primary_Type , Ward , District , Community, Year]]
            var = pd.DataFrame(X)
            if(request.form['Crime_Type'] == "0"):
                crime_ = "Arson"
            elif(request.form['Crime_Type'] == "1"):
                crime_ = "Assault"
            elif(request.form['Crime_Type'] == "2"):
                crime_ = "Battery"
            elif(request.form['Crime_Type'] == "3"):
                crime_ = "Bulglary"
            elif(request.form['Crime_Type'] == "4"):
                crime_ = "Concealed Carry License Violation"
            elif(request.form['Crime_Type'] == "5"):
                crime_ = "Crime Sexual  Assault"
            elif(request.form['Crime_Type'] == "6"):
                crime_ = "Criminal Damage"
            elif(request.form['Crime_Type'] == "7"):
                crime_ = "Criminal Tresspass"
            elif(request.form['Crime_Type'] == "8"):
                crime_ = "Deceptive Practice"
            elif(request.form['Crime_Type'] == "9"):
                crime_ = "Gambling"
            elif(request.form['Crime_Type'] == "10"):
                crime_ = "Homicide"
            elif(request.form['Crime_Type'] == "11"):
                crime_ = "Human Traffiking"
            elif(request.form['Crime_Type'] == "12"):
                crime_ = "Interference With Police officer"
            elif(request.form['Crime_Type'] == "13"):
                crime_ = "Intimidation"
            elif(request.form['Crime_Type'] == "14"):
                crime_ = "Kidnapping"
            elif(request.form['Crime_Type'] == "15"):
                crime_ = "Liquor Law Violation"
            elif(request.form['Crime_Type'] == "16"):
                crime_ = "Motor Vehicle Theft"
            elif(request.form['Crime_Type'] == "17"):
                crime_ = "Narcotics"
            elif(request.form['Crime_Type'] == "18"):
                crime_ = "Non-Criminal"
            elif(request.form['Crime_Type'] == "19"):
                crime_ = "Non-Criminal(Subject Specified)"
            elif(request.form['Crime_Type'] == "20"):
                crime_ = "Obsenity"
            elif(request.form['Crime_Type'] == "21"):
                crime_ = "Offense Involving Children"
            elif(request.form['Crime_Type'] == "22"):
                crime_ = "Other Narcotics Violation"
            elif(request.form['Crime_Type'] == "23"):
                crime_ = "Other Offense"
            elif(request.form['Crime_Type'] == "24"):
                crime_ = "Prostituition"
            elif(request.form['Crime_Type'] == "25"):
                crime_ = "Public Indesency"
            elif(request.form['Crime_Type'] == "26"):
                crime_ = "Public Peace Violation"
            elif(request.form['Crime_Type'] == "27"):
                crime_ = "Robbery"
            elif(request.form['Crime_Type'] == "28"):
                crime_ = "Sex Offense"
            elif(request.form['Crime_Type'] == "29"):
                crime_ = "Stalking"
            elif(request.form['Crime_Type'] == "30"):
                crime_ = "Theft"
            elif(request.form['Crime_Type'] == "31"):
                crime_ = "Weapons Violation" 
            print(var)
            #extra_tree_Model = pickle.load(open('extra_tree_model.pckl', 'rb'))
            extra_tree_Model = pickle.load(open('extra_tree_model.pckl', 'rb'))

            #prediction2 = extra_tree_Model.predict(var)

            result = extra_tree_Model.predict(var)
            print(result)
            if(result == True):
                return render_template('predicted_form_true.html', beat_Count = beat_Count, result= result , crime_ = crime_, District=District)
            else:
                return render_template('predicted_form_false.html',  beat_Count = beat_Count, result= result , crime_ = crime_, District=District)
        else:
                flash("Something went wrong")
                return render_template("fill_form.html")
    except Exception as e:
        return str(e)
@app.route('/Prediction_CSV/' ,methods= ['POST'])
def Prediction_CSV():
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
        try:
            file_path = os.path.join(dir_name, filename)
            file.save(file_path)
            dataset = pd.read_csv(file_path)
            print("Data Read")
            return render_template('predicted_CSV.html')
        except:
            flash("Please Upload only CSV file")
            return render_template('upload_csv.html')
    return render_template('upload_csv.html')         
@app.route("/safedistrict/", methods = ['POST'])
def safedistrict():
    x1 = crimes.groupby(["Arrest"])

    x1 = x1.get_group(True)

    x = pd.DataFrame({'crime_count' : crimes.groupby("District")["Primary Type"].count()}).reset_index()

    y = pd.DataFrame({'arrest_count' : x1.groupby("District")["Arrest"].count()}).reset_index() 

    safe_city = x.merge(y, left_index=True , right_index=True, how = 'inner', on = 'District')

    safe_city['stats'] = safe_city['crime_count'] - safe_city['arrest_count']

    safe_city['stats_ratio'] =  (safe_city['arrest_count'] / safe_city['crime_count'])*100

    d = (safe_city.loc[safe_city['stats_ratio'] <= 25])

    d1 = d["District"].values

    district = float(request.form['District'])
    if (district in d1):
        flash("The Entered District Is Not Safe")
        return render_template("loggedin_user.html")
    else:
        flash(" The Entered District Is Safe ")
        return render_template("loggedin_user.html")
   
if __name__ == "__main__":
  app.run()   