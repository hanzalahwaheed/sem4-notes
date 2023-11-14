import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="Waheed@924",
  database="mydatabase"
)

# print(mydb)

mycursor = mydb.cursor()
# db created (execute once only)
# mycursor.execute("CREATE DATABASE securityCompany")

# mycursor.execute("SHOW DATABASES")

mycursor.execute("CREATE TABLE customers (assignment_id INT AUTO_INCREMENT PRIMARY KEY, bodyguard_id INT, address VARCHAR(255))")

for x in mycursor:
  print(x)
    

