import os

os.system('.\gradlew build')
os.system('docker build -t tc/backend .')
