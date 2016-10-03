package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/store")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//out.println("<h3 style=\"color:Red\">User Details</h3>");
		int j=0;
		String msg="";
		try{
		//out.println(request.getParameter("["+j+"]".toString()));
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		String username=request.getParameter("username");
		String fathername=request.getParameter("fathername");
		String pwd=request.getParameter("pwd");
		String cpwd=request.getParameter("cpwd");
		String qualification=request.getParameter("qualification");
		String gender=request.getParameter("gender");
		String mailid=request.getParameter("mailid");
		String dob=request.getParameter("dob");
		PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
		ps.setInt(1,101);
		ps.setString(2,username);
		ps.setString(3,fathername);
		ps.setString(4,mailid);
		ps.setString(5,dob);
		ps.setString(6,qualification);
		ps.setString(7,pwd);
		ps.setString(8,gender);
		ps.executeQuery();
		msg="<font color=green>User Successfully Created</font>";
		}catch(Exception e){
			msg="<font color=red>"+e.getMessage()+"</font>";
		}
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		out.println(msg);
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
