<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
	<title>AtStud | Edit Student</title>
	<style type="text/css">
		<%@ include file="css/style.css"%>
	</style>
</head>
<body>
    
	<div class="container">
		<h1 class="heading">Any Time Student</h1>
		<ul class="nav">
			<li><a href="viewAllStudent.jsp">View All Student</a></li>
		</ul>
		<h2 class="heading">Edit & Update Student</h2>
        <div class="add-form">
          <form action="update" method="POST">
             <table>
                 <tr>
                    <th>
                         <label for="sno">Student No. : </label>         
                    </th>
                    <td>
                         <input type="number" name="studNo" class="input-field" id="sno" maxlength="10" value='<%= Integer.parseInt(request.getParameter("sno").toString()) %>' readonly required>
                    </td>
                 </tr>
                 <tr>
                    <th>
                         <label for="sname">Student Name : </label>      
                    </th>
                    <td>
                         <input type="text" name="studName" class="input-field" id="sname" maxlength="40" value='<%= request.getParameter("sname") %>' required>
                    </td>
                 </tr>
                 <tr>
                    <th>
                         <label for="sdob">Date of Birth : </label> 
                    </th>
                    <td>            
                        <input type="date" name="studDOB" class="input-field" id="sdob" value="<%= request.getParameter("sdob") %>" required>
                    </td>
                 </tr>
                 <tr>
                    <th>
                        <label for="sdoj">Date of Joining : </label>
                    </th>
                    <td>
                        <input type="date" name="studDOJ" class="input-field" id="sdoj" value="<%= request.getParameter("sdoj") %>" required>
                    </td>
                 </tr>
                 <tr >
                    <td colspan="2">
                        <input type="submit" class="input-field" value="Update Student">
                    </td>
                 </tr>
            </table>
         </form>
       </div>
	</div>
	
</body>
</html>