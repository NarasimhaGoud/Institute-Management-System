package com.minproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minproject.bean.Student;
import com.minproject.bean.Student1;
import com.minproject.controller.Dao;


@WebServlet("/")
public class myminproject extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch(path) {
		case "/Reg": registeruser(request,response);
		break;
		case "/Log":validateUser(request,response);
		break;

		case"/studenthome":
			String action= request.getParameter("action");
			switch(action) 
			{
			case "Add Student":addstudent(request,response);
			break;
			case"Display":displaystudentdata(request,response);
			break;
			case"Delete":deletestudentdata(request,response);
			break;
			case"Update":updatestudentdata(request,response);
			break;
			}
			break; 
		case"/savestudent":savestudentdetails(request,response);
		break;
		case"/showdata":updatestudent(request,response);
		break;
		case"/deletestudent":deletestudent(request,response);
		break;
		case"/updatestudent":updatedata(request,response);
		break;
		}
	}
	


	private void updatedata(HttpServletRequest request, HttpServletResponse response) {
		int sid=Integer.parseInt(request.getParameter("txtsid"));
	  String name=request.getParameter("txtname");
	  int age= Integer.parseInt(request.getParameter("txtage"));
	  long mobile=Long.parseLong(request.getParameter("txtmobile"));
	  String address=request.getParameter("txtaddress");
	  String email=request.getParameter("txtemail");
	  String course=request.getParameter("txtcourse");
	 Student1 s1=new Student1(sid,name, age, mobile, address, email, course);
	 Dao d=new Dao();
	 d.updatestudent(s1);
	
	 request.setAttribute("message", "updated successfully");
	 RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
	      try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	private void deletestudent(HttpServletRequest request, HttpServletResponse response) {
		long mobile=Long.parseLong(request.getParameter("txtmobile"));
		Student1 s1 =new Student1(mobile);
		Dao d= new Dao();
		boolean lean=d.deletedata(s1);
		if(lean)
		{
			request.setAttribute("delete", " mobile number delete successfully");
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				request.setAttribute("delete", "mobile number already exit");
				RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
				rd.forward(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	private void deletestudentdata(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("delete.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void updatestudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		long mobile=Long.parseLong(request.getParameter("txtmobile"));
		Student1 s1 =new Student1(mobile);
		Dao d=new Dao();
		Student1 s=d.showdataupdate(s1);
		if(s!=null) {
		request.setAttribute("student", s);
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
		try 
		{
			rd.forward(request, response);
		} 
		catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else {
			request.setAttribute("student","Invalid mobile number" );
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	private void updatestudentdata(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.sendRedirect("update.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//diplay student details in 
	private void displaystudentdata(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Dao d= new Dao();
		ArrayList<Student1> alist=d.getdata();
		request.setAttribute("studentlist", alist);
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		try {
			rd.forward(request, response);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	//add student details
	private void savestudentdetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name=request.getParameter("txtname");
		int age= Integer.parseInt(request.getParameter("txtage"));
		long mobile=Long.parseLong(request.getParameter("txtmobile"));
		String address=request.getParameter("txtaddress");
		String email=request.getParameter("txtemail");
		String course=request.getParameter("txtcourse");
		Student1 s1 =new Student1(name,age,mobile,address,email,course);
		Dao d =new Dao();
		boolean datapresent=d.insert(s1);
		if(datapresent) {
			RequestDispatcher rd=request.getRequestDispatcher("Student.jsp");
			try {
				rd.forward(request, response);
				request.setAttribute("message","mobile number or email is already exit");
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("Student.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	private void addstudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		response.sendRedirect("Student.jsp");

	}


	//login page to home page
	private void validateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String useremail =request.getParameter("txtuseremail");
		String  password=request.getParameter("txtpassword");
		Student s=new Student(useremail,password);
		Dao d=new Dao();
		boolean data=d.validStudent(s);
		if(data) 
		{
			try
			{
				response.sendRedirect("home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("message", "user does not exit");;
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	//register to login page
	private boolean registeruser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name =request.getParameter("txtname");
		String email =request.getParameter("txtemail");
		String password =request.getParameter("txtpassword");
		Student s=new Student(name,email,password);
		Dao d=new Dao();
		boolean b=d.insert(s);
		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			if(b)
			{
				response.sendRedirect("Login.jsp");
			}
			else
			{
				request.setAttribute("message","Email data already exit");
				RequestDispatcher rd=request.getRequestDispatcher("register2.jsp");
				rd.forward(request, response);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}
