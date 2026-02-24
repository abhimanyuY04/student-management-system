package com.sms.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sms.db.DBConnection;
import com.sms.model.Student;

public class StudentDAO {
	
	public boolean saveStudent(Student s) {
	
		
		try {
			
			Connection con = DBConnection.getConnection();
			String sql = "INSERT into students VALUES(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			
			int row = ps.executeUpdate();
			
			return row >0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
	
	public List<Student> getAllStudent(){
		List<Student> list = new ArrayList<>();
	    
		
		
		try {
			
			Connection con = DBConnection.getConnection();
			String sql = "SELECT * FROM students";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student s= new Student();
				s.setId(rs.getInt("id"));
		        s.setName(rs.getString("name"));
		        s.setAge(rs.getInt("age"));
				
				list.add(s);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Student getStudentByID(int id) {
		Student s = null;

		
		try {
			Connection con = DBConnection.getConnection();
			String sql = "SELECT * FROM students WHERE id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean deleteStudent(int id) {
				
		try {
			
			Connection con = DBConnection.getConnection();
			String sql = "DELETE FROM students WHERE id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			return row >0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public int getStudentCount() {

	    int count = 0;

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql = "SELECT COUNT(*) FROM students";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        if(rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	    return count;
	}

	
	public boolean updateStudent(Student s) {
		
		
		try {
			
			Connection con = DBConnection.getConnection();
			
			String sql = "UPDATE students SET name=?, age=? WHERE id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setInt(3, s.getId());
			
			int row = ps.executeUpdate();
			return row > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<Student> searchStudentByName(String name) {

	    List<Student> list = new ArrayList<>();

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql = "SELECT * FROM students WHERE name ILIKE ?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, "%" + name + "%");

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {

	            Student s = new Student();

	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setAge(rs.getInt("age"));

	            list.add(s);
	        }

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}
	public List<Student> getStudentsByPage(int start, int total){

	    List<Student> list = new ArrayList<>();

	    try{

	        Connection con = DBConnection.getConnection();

	        String sql = "SELECT * FROM students ORDER BY id LIMIT ? OFFSET ?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, total);
	        ps.setInt(2, start);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()){

	            Student s = new Student();

	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setAge(rs.getInt("age"));

	            list.add(s);
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}


}

