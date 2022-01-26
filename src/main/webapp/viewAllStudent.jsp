<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>AtStud | Student Details</title>
	<style type="text/css">
		<%@ include file="css/style.css"%>
		<%@ include file="css/studlist.css"%>
	</style>
</head>
<body>
<%@page import=" com.atdev.Dao.*, com.atdev.Bean.*, java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jst"%>  

	<div class="container">
		<h1 class="heading">Any Time Student</h1>
		<ul class="nav">
			<li><a href="addStudent.jsp">Add New Student</a></li>
			<li class="search-form"><form action="search" method="post">
                    <input type="search" name="studNo" placeholder="search...">
            </form></li>
		</ul>
		<h2 class="heading">List of All Students</h2>
		<div class="stud-list">
			<table>
            	<tr>
            	    <th>Stud No.</th>
            	    <th>Stud Name</th>
            	    <th>Stud DOB</th>
            	    <th>Stud DOJ</th>
            	    <th>EDIT</th>
            	    <th>DELETE</th>
            	</tr>
            	<%  
					if(request.getAttribute("searchstatus") != null){
						boolean status = Boolean.parseBoolean(request.getAttribute("searchstatus").toString());
						if(status){
							%>
					<tr>
	            	    <td>${sno}</td>
    	        	    <td>${sname}</td>
        	    	    <td>${dob}</td>
            		    <td>${doj}</td>
            		    <td><a href="editStudent.jsp?sno=${sno}&sname=${sname}&sdob=${dob}&sdoj=${doj}">EDIT</a></td>
            	    	<td><a href="delete?sno=${sno}" onclick="return deleteStudent()">DELETE</a></td>
            		</tr>
							<%
							
						}else{
							out.write("<script> alert('Fail: Student not find'); </script><a href='viewAllStudent.jsp'>View All Student</a>");
						}
					}else{
						List<StudentModel> studlist= StudentDao.getAllStudents();  
						request.setAttribute("list",studlist);  
				%> 
				<jst:forEach items="${list}" var="s">
            		<tr>
	            	    <td>${s.getSno()}</td>
    	        	    <td>${s.getName() }</td>
        	    	    <td>${s.getDob() }</td>
            		    <td>${s.getDoj() }</td>
            		    <td><a href="editStudent.jsp?sno=${s.getSno()}&sname=${s.getName()}&sdob=${s.getDob()}&sdoj=${s.getDoj()}">EDIT</a></td>
            	    	<td><a href="delete?sno=${s.getSno()}" onclick="return deleteStudent()">DELETE</a></td>
            		</tr>
				</jst:forEach> 
				<% } %>
        	</table>
		</div>
	</div>
	<%
		if(request.getAttribute("editstatus") != null){
			boolean status = Boolean.parseBoolean(request.getAttribute("editstatus").toString());
			if(status){
				out.write("<script> alert('1 row Updated Successfully...'); </script>");
			}else{
				out.write("<script> alert('Fail: something went wrong!'); </script>");
			}
		}
		if(request.getAttribute("deletestatus") != null){
			boolean status = Boolean.parseBoolean(request.getAttribute("deletestatus").toString());
			if(status){
				out.write("<script> alert('1 row Deleted Successfully...'); </script>");
			}else{
				out.write("<script> alert('Fail: something went wrong!'); </script>");
			}
		}
	
	%>
</body>
<script>
    function deleteStudent() {
        if (confirm("Are you sure, you want to delete this record?") == true)
            return true;
        else 
            return false;
    }
</script>
</html>