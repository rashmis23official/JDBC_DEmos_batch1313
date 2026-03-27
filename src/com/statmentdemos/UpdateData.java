package com.statmentdemos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class UpdateData {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			Statement stmt=con.createStatement();
			
			int x=stmt.executeUpdate("update employee set address='pune' where eid=102");
//			int x=stmt.executeUpdate("update employee set salary=11111 where address='pune'");
			System.out.println("x = "+x);
			if(x>0)
			{
				System.out.println("employee updated");
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
