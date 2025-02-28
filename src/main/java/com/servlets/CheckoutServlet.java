package com.Servlets;

import java.io.IOException;

import com.foodapp.dao.impl.OrdersDAOimpl;
import com.foodapp.dao.interfaces.OrdersDAO;
import com.foodapp.model.Cart;
import com.foodapp.model.CartItem;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private OrdersDAO orderDAO;

    @Override
    public void init() {
        try {
            orderDAO = new OrdersDAOimpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Fetch user and cart from session
        Cart cart = (Cart) session.getAttribute("cart");
        
        User user = (User) session.getAttribute("user");

        if (cart == null) {
//            System.out.println("Cart is null");
//            resp.sendRedirect("home.jsp");
//            return;
        	  cart=new Cart();
        	  session.setAttribute("cart", cart);
        }
        
        

        if (user == null) {
//            System.out.println("User is null");
            user =new User();
//            resp.sendRedirect("login.jsp");
//            return;
            session.setAttribute("user", user);
        }

        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            System.out.println("Cart items are empty");
            resp.sendRedirect("cart.jsp");
            return;
        }

        try {
            String paymentMethod = req.getParameter("paymentMethod");
            if (paymentMethod == null || paymentMethod.isEmpty()) {
                System.out.println("Payment method is not selected");
                resp.sendRedirect("checkout.jsp");
                return;
            }

            Orders orders = new Orders();
            orders.setUserId(user.getUserId());

            // Assuming restaurant ID is retrieved from the first cart item
            int restaurantId = cart.getItems().values().iterator().next().getRestaurantId();
            orders.setRestaurantId(restaurantId);

            orders.setPaymentMode(paymentMethod);
            orders.setStatus("pending");

            double totalAmount = 0;
            for (CartItem item : cart.getItems().values()) {
                totalAmount += item.getPrice() * item.getQuantity();
            }
            orders.setTotalAmount(totalAmount);

            // Insert order into the database
            orderDAO.insert(orders);

            // Clear the cart and set order details in session
            session.removeAttribute("cart");
            session.setAttribute("order", orders);

            resp.sendRedirect("orderConfirmation.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error during order processing: " + e.getMessage());
            resp.sendRedirect("home.jsp");
        }
    }
}
