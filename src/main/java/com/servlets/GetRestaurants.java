package com.Servlets;

import java.io.IOException;


import java.util.List;

import com.foodapp.dao.impl.RestaurantDAOImpl;
import com.foodapp.dao.interfaces.RestaurantDAO;
import com.foodapp.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/GetRestaurants")
public class GetRestaurants extends HttpServlet {
	
	private List<Restaurant> restaurantList;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		
		if(req.getCookies()[0].getValue()!=null) {
			
			RestaurantDAO pdao=new RestaurantDAOImpl();

			restaurantList =pdao.fetchAll();
			HttpSession session=req.getSession();
	
			session.setAttribute("RestaurantList", restaurantList);
			resp.sendRedirect("home.jsp");
		}
		else {
			resp.sendRedirect("login.html");
		}
	}

}

