package com.minproject.controller;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.minproject.bean.Student;
import com.minproject.bean.Student1;

public class Dao {
	
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/mvcdesignpattern";
	String user="root";
	String password="admin";
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	Statement st=null;
    String querytable="Select * from student";
	String query="insert into student(name,email,password)values(?,?,?);";
	String studenttable="Select * from student1";
	String insertstudentdata ="insert into student1(name,age,mobile,address,email,course)values(?,?,?,?,?,?);";
	
	//register page insert data
public  boolean insert(Student s) {
	boolean b=false;
	try {
		Class.forName(driver);
		 con = DriverManager.getConnection(url,user,password);
		//String query="insert into student(name,email,password)values(?,?,?);";
		ps=con.prepareStatement(query);
		ps.setString(1, s.getName());
		ps.setString(2, s.getEmail());
		ps.setString(3, s.getPassword());
		ps.executeUpdate();
		b=true;
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
      e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		if(ps!=null&&con!=null)
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	return b;
}
         //login page
public boolean validStudent(Student s) {
	boolean datapresent =false;
	try {
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		//String querytable="Select * from student";
		st = con.createStatement();
		 rs=st.executeQuery(querytable) ;
		while(rs.next()) 
		{
			String email=rs.getString("email");
			String password=rs.getString("password");
			if(email.equals(s.getEmail()) && password.equals(s.getPassword()))
			{
				datapresent=true;
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
		if(st!=null&&con!=null)
		{
			try {
				st.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	return datapresent;
}
//Add studentform insert data
public boolean insert(Student1 s1) {
	boolean d=false;
	  try {
		Class.forName(driver);
		con= DriverManager.getConnection(url,user,password);
		st=con.createStatement();
		rs=st.executeQuery(studenttable);
		while(rs.next()) {
	if(rs.getLong("mobile")==s1.getMobile()|| rs.getString("email").equals(s1.getEmail()))
	{
		d=true;	
		break;
	}
		}
		if(!d) {
			ps=con.prepareStatement(insertstudentdata);
			ps.setString(1, s1.getName());
			ps.setInt(2, s1.getAge());
			ps.setLong(3, s1.getMobile());
			ps.setString(4,s1.getAddress());
			ps.setString(5, s1.getEmail());
			ps.setString(6, s1.getCourse());
			ps.executeUpdate();
		}
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  finally {
		  if(ps!=null&&con!=null) {
			  try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  
	  }
	return d;
	
}
//display data
public ArrayList<Student1> getdata() {
	ArrayList<Student1> al=new ArrayList<Student1>();
      try 
      {
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
		rs=st.executeQuery("select * from student1");
		while(rs.next())
		{
			int sid=rs.getInt("sid");
			String name=rs.getString("name");
			int age =rs.getInt("age");
			long mobile=rs.getLong("mobile");
			String address =rs.getString("address");
			String email=rs.getString("email");
			String course =rs.getString("course");
			Student1 s1 =new Student1(sid, name, age, mobile, address, email, course);
			al.add(s1);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return al;
}
    public boolean deletedata(Student1 s1) {
    	boolean  bool=false;
    	       try {
				Class.forName(driver);
				con=DriverManager.getConnection(url,user,password);
				String select="select mobile from student1 where mobile=?";
			    ps=con.prepareStatement(select);
			    ps.setLong(1,s1.getMobile() );
			    rs=ps.executeQuery();
			    if(rs.next()) {
					   bool =true;
				}
			    if(bool) {
			    	String sql="delete  from student1 where mobile=?";
					ps=con.prepareStatement(sql);
					ps.setLong(1, s1.getMobile());
					ps.executeUpdate();
			    }
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	       finally {
    	    	   if(ps!=null&&con!=null) {
    	    		   try {
						ps.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	   }
    	       }
			return bool;
    }
    public Student1 showdataupdate(Student1 s1) {
    	Student1 s=null;
    	try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement("select * from student1 where mobile=?");
			ps.setLong(1, s1.getMobile());
			rs=ps.executeQuery();
			if(rs.next()) {
				int sid=rs.getInt("sid");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				long mobile=rs.getLong("mobile");
				String address=rs.getString("address");
				String email=rs.getString("email");
				String course=rs.getString("course");
				s=new Student1(sid,name, age, mobile, address, email, course); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return s;
    }
    public boolean updatestudent(Student1 s1) {
    	boolean b=false;
    	try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement("update student1 set name=?,age=?,mobile=?,address=?,email=?,course=? where sid=?");
			ps.setString(1, s1.getName());
			ps.setInt(2, s1.getAge());
			ps.setLong(3, s1.getMobile());
			ps.setString(4, s1.getAddress());
			ps.setString(5, s1.getEmail());
			ps.setString(6, s1.getCourse());
			ps.setLong(7, s1.getSid());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
    }
}