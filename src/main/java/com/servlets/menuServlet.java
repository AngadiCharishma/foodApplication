package com.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.impl.MenuDAOimpl;
import com.foodapp.dao.interfaces.MenuDAO;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class menuServlet extends HttpServlet {
	
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		
		
			int id=Integer.parseInt(req.getParameter("restaurantId"));

			MenuDAO pdao=new MenuDAOimpl();
			
			List<Menu> menuList = pdao.fetchMenuByRestaurantId(id);
			
			
             if(menuList==null || menuList.isEmpty()) {
            	 
				menuList=new ArrayList<>();
             }
		
				req.setAttribute("MenuList", menuList);
				req.getRequestDispatcher("menu.jsp").forward(req,resp);
				
				
			
			
	}
}
		

