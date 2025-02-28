package com.Servlets;
	
	
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
	
	
	@WebServlet("/LoginServlet")
	public class LoginServlet extends HttpServlet 
	{
		private Connection con;
		
		private String checkEmail="SELECT * FROM USER WHERE EMAIL=?";
		
		private PreparedStatement pstmt;
		private ResultSet res;
	
		
		@Override
		public void init() throws ServletException {
			String url="jdbc:mysql://localhost:3306/foodapplication";
			String dbun="root";
			String dbpwd="root";
			
	        try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,dbun,dbpwd);
		    }
	        catch(Exception e) {
		        e.printStackTrace();
	        }
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException 
		{
			HttpSession session=req.getSession();
//			User user = (User)session.getAttribute("user");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			
			  try {
				pstmt=con.prepareStatement(checkEmail);
				pstmt.setString(1,email);
				res=pstmt.executeQuery();
				
				if(res.next()) {
				
					
					if(password.equals(res.getString("password"))) 
					{
						
						String name=res.getString("username");
						password=res.getString("password");						
						email=res.getString("email");
//						String mobile=res.getString("mobile");
						String address=res.getString("address");
//						String city=res.getString("city");
						
						
						Cookie ck2 = new Cookie("email", email);
	//					
						resp.addCookie(ck2);
	//					
						session.setAttribute("name", name);
						session.setAttribute("password",password);
						session.setAttribute("email", email);
//						session.setAttribute("mobile", MyDecrypt.decrypt(mobile));
						session.setAttribute("address",address);
//						session.setAttribute("city", MyDecrypt.decrypt(city));
						
						req.getRequestDispatcher("GetRestaurants").forward(req, resp);
					}
					else 
					{
						resp.sendRedirect("passwordMismatch.html");
					}
				}
				else {
					resp.sendRedirect("invalidUser.html");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				resp.getWriter().write("An error occured: "+e.getMessage());
			}
		}
		
		
	
		@Override
		public void destroy() {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
	
