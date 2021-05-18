import sqlite3

# Connect to database
conn = sqlite3.connect('customer.db')

# Create a cursor
c = conn.cursor()

# Create a Table
try:
	c.execute("""
		CREATE TABLE users (
			username text,
			password text,
			email text
		)
	""")
	user_list = [
		('admin', 'admin', 'admin@vuln.com'),
		('ch3l', '123456', 'ch3l@gmail.com'),
		('anotheruser', 'justanotherpassword', 'user@gmail.com'),
		('hoangtran', 'asdasd', 'hoangtv@gmail.com')
	]
	c.executemany("INSERT INTO users VALUES(?,?,?)", user_list)
except Exception as e:
	print(e)

# Datatypes:
# NULL
# INTEGER
# REAL
# TEXT
# BLOB

# Query the Database
c.execute("SELECT * FROM users")
items = c.fetchall()
for item in items:
	print(item)

# Commit our command
conn.commit()

# Close our connection
conn.close()
