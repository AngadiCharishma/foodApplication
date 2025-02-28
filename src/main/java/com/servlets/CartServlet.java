package com.Servlets;

import java.io.IOException;

import com.foodapp.dao.impl.MenuDAOimpl;
import com.foodapp.dao.interfaces.MenuDAO;
import com.foodapp.model.Cart;
import com.foodapp.model.CartItem;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		  
		  HttpSession session = req.getSession();  //1. creating the session and get the session for the cart
		  Cart cart = (Cart)session.getAttribute("cart");
		  
		  if(cart==null) {  //2. checking if the cart is there or not. If it is not there create one cart and add it to session
			  cart=new Cart();
			  session.setAttribute("cart", cart);
		  }
		   
		  String action =req.getParameter("action"); // 3.fetching the action and item id from menu.jsp
		  int itemId=Integer.parseInt(req.getParameter("itemId"));
		  
//		  if(action==null || itemId==0) {
//			  resp.sendRedirect("cart.jsp");
//			  return;
//		  }
		  
//		  MenuDAO menuDAO = null; // 4.create an object of menuDAO for fetching the details of menu item
		  
		  try {
			  MenuDAO menuDAO=new MenuDAOimpl();
			  
			  if(action.equals("add")) { // 5.checking if the items added to the cart or not
				  Menu menuItem=menuDAO.fetchOne(itemId);
				  if(menuItem!=null) {
					  int quantity=1;
					  CartItem cartItem=new CartItem(
							  menuItem.getMenuId(),
							  menuItem.getRestaurantId(),
							  menuItem.getName(),
							  menuItem.getPrice(),
							  quantity
							  );
					  cart.addItem(cartItem);
				  }
			  }
			  
			  else if(action.equals("update"))
			  {   
				  int quantity=Integer.parseInt(req.getParameter("quantity"));
				
//				  if(quantity1!=null) {
//					  int quantity=Integer.parseInt(quantity1);
					  cart.updateItem(itemId, quantity);
					  
//				  }
			 }
			 else if(action.equals("remove"))
			 {
				  cart.removeItem(itemId);
			 }
			 else {
				  System.out.println("Unknown action: " + action);
			 }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  // 6.redirect to cart page
		  session.setAttribute("cart", cart);
		  resp.sendRedirect("cart.jsp");
		  
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}
	
     
}
