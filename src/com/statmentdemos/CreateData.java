package com.statmentdemos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateData {
	public static void main(String[] args) {				
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			Statement stmt=con.createStatement();
			int x=stmt.executeUpdate("insert into employee values(101,'Gagan',20000,'pune',333)");
			if(x>0)
			{
				System.out.println("employee saved");
			}
			else
			{
				System.out.println("error in insertion");
			}
			con.close();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
