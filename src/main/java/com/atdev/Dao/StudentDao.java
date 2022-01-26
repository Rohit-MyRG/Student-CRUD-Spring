package com.atdev.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atdev.Bean.StudentModel;

public class StudentDao {
	public boolean insertStudent(StudentModel sm) {
		
		Connection con = MySqlConnectionProvider.getConnection();
		System.out.println("connection success");
		
		try {
			if(!isExist(sm.getSno(), con));
			{
				PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?)");
				pst.setInt(1, sm.getSno());
				pst.setString(2, sm.getName());
				pst.setDate(3, new java.sql.Date(sm.getDob().getTime()));
				pst.setDate(4, new java.sql.Date(sm.getDoj().getTime()));
				
				int result = pst.executeUpdate();
				if(result == 1) {
				
					System.out.println("result="+result);
					return true;
				}	
				else
					return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	public boolean updateStudent(StudentModel sm) {
		
		Connection con = MySqlConnectionProvider.getConnection();
		System.out.println("connection success");
		
		try {
			if(isExist(sm.getSno(), con));
			{
				PreparedStatement pst = con.prepareStatement("update student set name=?, dob=?, doj=? where sno=?");
				pst.setString(1, sm.getName());
				pst.setDate(2, new java.sql.Date(sm.getDob().getTime()));
				pst.setDate(3, new java.sql.Date(sm.getDoj().getTime()));
				pst.setInt(4, sm.getSno());
				
				int result = pst.executeUpdate();
				if(result == 1) {
				
					System.out.println("result="+result);
					return true;
				}	
				else
					return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	public boolean deleteStudent(int sno) {
		Connection con = MySqlConnectionProvider.getConnection();
		System.out.println("connection success");
		try {
			if(isExist(sno, con));
			{
				PreparedStatement pst = con.prepareStatement("delete from student where sno=?");
				pst.setInt(1, sno);
				
				int result = pst.executeUpdate();
				if(result == 1)
					return true;
				else
					return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static StudentModel searchStudent(int sno) {
		Connection con = MySqlConnectionProvider.getConnection();
		System.out.println("connection success");
		try {
				PreparedStatement pst = con.prepareStatement("select * from student where sno=?");
				pst.setInt(1, sno);
				
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					StudentModel sm = new StudentModel(0, null, null, null);
					sm.setSno(rs.getInt("sno"));
					sm.setName(rs.getString("name"));
					sm.setDob(rs.getDate("dob"));
					sm.setDoj(rs.getDate("doj"));
					
					return sm;
				}else {
					return null;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	private boolean isExist(int sno,Connection con) throws SQLException {
	
			PreparedStatement pst = con.prepareStatement("SELECT * FROM student where sno=?");
			pst.setInt(1, sno);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				System.out.println("roll no. Exist");
				return true;
			}
			else
				return false;
	}
	public static List<StudentModel> getAllStudents() {
		List<StudentModel> studentList = new ArrayList<StudentModel>();
		
		Connection con = MySqlConnectionProvider.getConnection();
		System.out.println("connection success");
		
		try {
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				StudentModel stud = new StudentModel(rs.getInt("sno"), rs.getString("name"), rs.getDate("dob"), rs.getDate("doj"));
				studentList.add(stud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
}
