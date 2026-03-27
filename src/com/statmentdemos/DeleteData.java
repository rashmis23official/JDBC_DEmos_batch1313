package com.statmentdemos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DeleteData {
	public static void main(String[] args) {		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			Statement stmt=con.createStatement();
			int x=stmt.executeUpdate("delete from employee where eid=100");			
			if(x>0)
			{
				System.out.println("employee deleteed");
			}
			else
			{
				System.out.println("given employee doesnt exist");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
