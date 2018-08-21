Predicting defaulting on credit card applications

Problem 1:

When customers come in financial difficulties, it usually does not happen at once. There are indicators which can be used to anticipate the outcome, such as late payments, calls to the customer services, enquiries about the products, a different browsing pattern on the web or mobile app. By using such patterns, it is possible to prevent, or at least guide the process and provide a better service for the customer as well as reduced risks for the bank.

Synopsis

This notebook has the following phases:
•	Data Ingestion
•	Data Preparation
•	Feature Engineering
•	Feature Selection
•	Modeling
•	Pickle
•	Uploading files to Amazon S3

The predictive power of the following algorithms is compared:
•	Logistic regression
•	Random Forests Classification
•	KNeighbours Classification 
•	Extra Tree Classifier
•	BernoulliNB Classifier

All the above models were Pickled to persist the models for future use without having to retrain.
Pickle only works with a 64-bit os. 

Dataset = https://archive.ics.uci.edu/ml/datasets/default+of+credit+card+clients
Docker Image: docker pull milony/img1



