package prepareddemos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class StudentCRUDApp {
	
	
	
	
	void createStudent(int r,String nm,String ad,float per)
	{			
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			//create preparedStamtment
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, r);
			ps.setString(2, nm);
			ps.setString(3, ad);
			ps.setFloat(4, per);			
			//executeStament
			int x=ps.executeUpdate();
			if(x>0)
			{
				System.out.println("register student successfully!!!");
			}
			else
				System.out.println("error in insertion");			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	void viewAllStudent()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			PreparedStatement ps=con.prepareStatement("select * from student");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	void viewStudentByRoll(int roll)
	{		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			PreparedStatement ps=con.prepareStatement("select * from student where roll=?");
			ps.setInt(1, roll);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4));
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	int updateStudent(int r,String ad,float p)
	{
		int x=0;		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			
			PreparedStatement ps=con.prepareStatement("update student set address=? , per=? where roll=?");
			ps.setString(1, ad);
			ps.setFloat(2, p);
			ps.setInt(3, r);			
			 x=ps.executeUpdate();				
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return x;
	}
	
	void deleteStudent(int r)
	{
		System.out.println("del");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1313","root","root");
			PreparedStatement ps=con.prepareStatement("delete from student where roll=?");
			ps.setInt(1, r);			
			int x=ps.executeUpdate();
			if(x>0)
			{
				System.out.println("student deleteed");
			}
			else
				System.out.println("student doesnt exist!!!");
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) {		
		Scanner sc=new Scanner(System.in);		
		StudentCRUDApp studApp=new StudentCRUDApp();
		do
		{
			System.out.println("1.create student\n2.view All Student\n3.view by Roll\n"
							+ "4.update Student\n5.Delete student\n6.exit");
			System.out.println("enter the operation code");
			int ch=sc.nextInt();			
			switch(ch)
			{
			case 1:
					System.out.println("enter the roll,name,address and per ");
					int r=sc.nextInt();
					String n=sc.next();
					String a=sc.next();
					float p=sc.nextFloat();
					studApp.createStudent(r,n,a,p);
					break;
			case 2:
				studApp.viewAllStudent();
				break;
			case 3:
				System.out.println("enter the roll");
				r=sc.nextInt();
				studApp.viewStudentByRoll(r);
				break;
			case 4:
				System.out.println("enter the roll and updated address and per ");
				 r=sc.nextInt();				
				 a=sc.next();
				p=sc.nextFloat();
				int res=studApp.updateStudent(r,a,p);
				
				if(res>0)
				{
					System.out.println("student updated successfully!!!");
				}
				else
				{
					System.out.println("student doesnt exist!!!");
				}
				break;
			case 5:
				System.out.println("enter the roll ");
				 r=sc.nextInt();
				studApp.deleteStudent(r);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("invalid operation");
			}
			
		}while(true);

	}

}
