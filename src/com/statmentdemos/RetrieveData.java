package com.statmentdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class RetrieveData {
	public static void main(String[] args) {		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			Statement stmt=con.createStatement();
			/*
			
			ResultSet rs=stmt.executeQuery("select * from employee");
			while(rs.next())
			{
//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getInt(5));
System.out.println(rs.getInt("eid")+" "+rs.getString("ename")+" "+rs.getFloat("salary")+" "+rs.getString("address")+" "+rs.getInt("dept_id"));
			}
			*/			
			
			/*
			ResultSet rs=stmt.executeQuery("select eid,ename from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt("eid")+" "+rs.getString("ename"));
			}
			*/
			
			ResultSet rs=stmt.executeQuery("select ename,salary from employee where salary>30000");
			while(rs.next())
			{
//				System.out.println(rs.getString("ename")+" "+rs.getFloat("salary"));
				System.out.println(rs.getString(1)+" "+rs.getFloat(2));
			}
			
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
