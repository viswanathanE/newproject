package com.usermanagement.dao;

import java.sql.*;
import java.util.ArrayList;

import com.usermanagement.bean.User;

public class UserDao 
{
	private static String url="jdbc:mysql://localhost:3306/usermanagement";
	private static String use="root";
	private static String password="Viswa@2001";
	private static Statement s= null;
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static String checkQuery="select * from admin";
	private static String display = "select * from user";
	private static String insert="insert into user(name,email,city) values(?,?,?)";
	private static String delete="delete from user where id=?";
	
	
	public static void delete(int id) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,use,password);
			ps=con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try {
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
public static boolean  CheckLogin(String user,String pass) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,use,password);
			s = con.createStatement();
			rs = s.executeQuery(checkQuery);
			
			while(rs.next()) {
				String name =rs.getString("username");
				String passw = rs.getString("password");
				
				if(name.equals(user)&&passw.equals(pass)) {
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;

  }
public static void insertStudentDetails(User u) 
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,use,password);
		ps = con.prepareStatement(insert);
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getCity());
		
		ps.executeUpdate();
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally 
	{
		try 
		{
	        ps.close();
			con.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
}
}
public static ArrayList<User>display(){
	
	ArrayList<User> al = new ArrayList<User>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,use,password);
		s = con.createStatement();
		rs = s.executeQuery(display);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String city = rs.getString("city");
			User u = new User(id, name, email, city);
			al.add(u);
		}
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {			
		e.printStackTrace();
	}
	finally {
		try {
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return al;
	
   }

}
