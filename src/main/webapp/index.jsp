<html>
<head>
	<title>Student Management System</title>
	<style type="text/css">
		<%@ include file="css/style.css"%>
	</style>
</head>
<body>
	<div class="container">
		<h1 class="heading">Any Time Student</h1>
		<ul class="nav">
			<li><a href="addStudent.jsp">Add New Student</a></li>
			<li><a href="viewAllStudent.jsp">View All Student</a></li>
		</ul>
	 	<marquee><h1 class="heading">Welcome to Any Time Student</h1></marquee>
	</div>
</body>
</html>

<!-- 
Table Name - STUDENT
STUDENT_NO INT (3)
STUDENT_NAME TEXT (30)
STUDENT_DOB DATE
STUDENT_DOJ DATE

1. Insert student data into Student table
2. Update student data into Student table
3. Delete student data from Student table
4. Get a list of all students
5. Get one student information depending on the student id filter.

DATABASE
use atdev;
CREATE TABLE student(sno int primary key,name varchar(20), dob date, doj date);
INSERT INTO student VALUES(101,"Rohit",STR_TO_DATE('2012-01-2', '%Y-%m-%d'),STR_TO_DATE('2012-02-12', '%Y-%m-%d'));
SELECT * from student;

git remote add origin https://github.com/Rohit-MyRG/Student-CRUD-Spring.git
git branch -M main
git push -u origin main

 -->