<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.Cart" %>
<%@ page import="com.foodapp.model.CartItem" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }

        h2 {
            color: #2196F3;
            text-align: center;
            margin-bottom: 30px;
            font-size: 2.5em;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.1);
        }

        .empty-cart {
            text-align: center;
            padding: 30px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }

        .cart-items {
            display: grid;
            gap: 20px;
            margin-bottom: 30px;
        }

        .cart-item {
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.08);
            display: flex;
            justify-content: space-between;
            align-items: center;
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }

        .cart-item:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 12px rgba(0,0,0,0.12);
        }

        .cart-item h3 {
            color: #2c3e50;
            margin: 0 0 12px 0;
            font-size: 1.4em;
        }

        .price-info {
            color: #666;
            margin: 8px 0;
            font-size: 1.1em;
        }

        .controls-container {
            display: flex;
            flex-direction: column;
            gap: 15px;
            align-items: center;
        }

        .quantity-controls {
            display: flex;
            align-items: center;
            gap: 12px;
            background: #f8f9fa;
            padding: 8px;
            border-radius: 8px;
        }

        button {
            padding: 10px 18px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            transition: all 0.2s ease;
        }

        .quantity-btn {
            width: 36px;
            height: 36px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 1.2em;
        }

        .quantity-btn.decrease {
            background-color: #ff4444;
            color: white;
        }

        .quantity-btn.increase {
            background-color: #4CAF50;
            color: white;
        }

        .quantity-display {
            padding: 8px 20px;
            background: white;
            border-radius: 6px;
            font-weight: bold;
            min-width: 30px;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }

        .remove-btn {
            background-color: #FFD700;
            color: #000;
            padding: 10px 24px;
            width: 100%;
            font-weight: bold;
            border-radius: 6px;
        }

        .remove-btn:hover {
            background-color: #FFC800;
            transform: translateY(-1px);
        }

        .total-section {
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.08);
            margin-top: 30px;
        }

        .total-section h3 {
            color: #2c3e50;
            margin: 0 0 20px 0;
            font-size: 1.6em;
        }

        .action-links {
            display: flex;
            justify-content: space-between;
            gap: 20px;
        }

        .action-links a {
            flex: 1;
            padding: 12px 24px;
            text-decoration: none;
            color: white;
            border-radius: 6px;
            font-weight: bold;
            text-align: center;
            transition: all 0.2s ease;
        }

        .add-more-link {
            background-color: #4CAF50;
        }

        .add-more-link:hover {
            background-color: #45a049;
            transform: translateY(-1px);
        }

        .checkout-link {
            background-color: #2196F3;
        }

        .checkout-link:hover {
            background-color: #1e88e5;
            transform: translateY(-1px);
        }

        .browse-menu-link {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 12px 24px;
            text-decoration: none;
            border-radius: 6px;
            margin-top: 15px;
            transition: all 0.2s ease;
        }

        .browse-menu-link:hover {
            background-color: #45a049;
            transform: translateY(-1px);
        }

        .item-details {
            flex: 1;
            padding-right: 20px;
        }

        @media (max-width: 600px) {
            .cart-item {
                flex-direction: column;
                text-align: center;
                gap: 20px;
            }

            .item-details {
                padding-right: 0;
            }

            .controls-container {
                width: 100%;
            }

            .action-links {
                flex-direction: column;
            }
        }
    </style>
</head>
<body>
    <h2>Your Cart</h2>
    <% 
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
    %>
    <div class="empty-cart">
        <p>Your cart is empty</p>
        <a href="menu.jsp" class="browse-menu-link">Browse Menu</a>
    </div>
    <% 
        } else {
            int restaurantId = 0;
            if (!cart.getItems().isEmpty()) {
                restaurantId = cart.getItems().values().iterator().next().getRestaurantId();
            }
    %>
    <div class="cart-items">
    <%
        double totalAmount = 0;
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem item = entry.getValue();
            totalAmount += item.getPrice() * item.getQuantity();
    %>
    <div class="cart-item">
        <div class="item-details">
            <h3><%= item.getName() %></h3>
            <p class="price-info">Price: Rs. <%= item.getPrice() %></p>
            <p class="price-info">Total: Rs. <%= item.getPrice() * item.getQuantity() %></p>
        </div>
        
        <div class="controls-container">
            <form method="post" action="cart" class="quantity-controls">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>" class="quantity-btn decrease">-</button>
                <span class="quantity-display"><%= item.getQuantity() %></span>
                <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>" class="quantity-btn increase">+</button>
            </form>
            
            <form action="cart" method="post">
                <input type="hidden" name="action" value="remove">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <button type="submit" class="remove-btn">Remove</button>
            </form>
        </div>
    </div>
    <% 
        }
    %>
    </div>
    
    <div class="total-section">
        <h3>Total Amount: Rs. <%= totalAmount %></h3>
        <div class="action-links">
            <a href="menu?restaurantId=<%=restaurantId %>" class="add-more-link">Add More Items</a>
            <a href="checkout.jsp" class="checkout-link">Proceed to Checkout</a>
        </div>
    </div>
    
    <% 
        }
    %>
</body>
</html>