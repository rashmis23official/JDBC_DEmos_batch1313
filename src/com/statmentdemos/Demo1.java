package com.statmentdemos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Demo1 {
	public static void main(String[] args) {		
		try
		{
			
//			1.reg/load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("done 1");			
//			2.est connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			System.out.println("done 2");			
//			3.create a statment---insert into user1 values(902,'poonum');
			Statement st=con.createStatement();
			System.out.println("done 3");			
//			4.execute statemnt			
			int status=st.executeUpdate("insert into user1 values(902,'poonum');");
			if(status>0)
			{
				System.out.println("record saved ");
			}
			else
			{
				System.out.println("error in insertion");
			}
			System.out.println("doen 4");
			
//			5.close connection
			con.close();
			System.out.println("doen 5");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
