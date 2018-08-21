#!/bin/bash
yum update -y
sudo /bin/dd if=/dev/zero of=/var/swap.1 bs=1M count=1024
sudo /sbin/mkswap /var/swap.1
sudo /sbin/swapon /var/swap.1

sudo pip install flask
sudo pip install xlrd
sudo pip install pandas
sudo pip install requests
sudo pip install bs4
sudo pip install wget
sudo pip install sklearn
sudo pip install imblearn
sudo pip install numpy
sudo pip install scipy
sudo pip install boto3
sudo pip install boto

sudo swapoff /var/swap.1
sudo rm /var/swap.1

