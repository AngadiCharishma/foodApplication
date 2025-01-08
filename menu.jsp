<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu List</title>
    <style>
        body {
            margin-top: 40px;
        }
        .menu-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
            padding: 20px;
        }
        .menu-card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            width: 220px;
            transition: transform 0.3s ease;
        }
        .menu-card:hover {
            transform: translateY(-5px);
        }
        .menu-image {
            width: 100%;
            height: 140px;
            object-fit: cover;
        }
        .menu-content {
            padding: 12px;
        }
        .menu-name {
            font-size: 1.2rem;
            font-weight: bold;
            margin-bottom: 6px;
        }
        .menu-description {
            font-size: 0.9rem;
            color: #666;
            margin-bottom: 8px;
        }
        .menu-price {
            font-size: 1.1rem;
            font-weight: bold;
            color: #2c3e50;
            margin-bottom: 12px;
        }
        .no-items {
            font-size: 1.2rem;
            color: #666;
            text-align: center;
            width: 100%;
        }
        .add-to-cart-btn {
            display: block;
            width: 100%;
            padding: 8px;
            background-color: #3498db;
            color: #fff;
            text-align: center;
            text-decoration: none;
            font-weight: bold;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .add-to-cart-btn:hover {
            background-color: #2980b9;
        }
        @media (max-width: 768px) {
            .menu-card {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <% 
        List<Menu> mList = (List<Menu>) request.getAttribute("MenuList");
        if (mList != null && !mList.isEmpty()) { 
            for (Menu m : mList) { 
        %>
            <div class="menu-card">
                <img src="<%= m.getImagePath() %>" alt="<%= m.getName() %>" class="menu-image">
                <div class="menu-content">
                    <h3 class="menu-name"><%= m.getName() %></h3>
                    <p class="menu-description"><%= m.getDescription() %></p>
                    <p class="menu-price">Rs. <%= m.getPrice() %></p>
                    
                    <form method="post" action="cart">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="itemId" value="<%= m.getMenuId() %>">
                        <input type="hidden" name="quantity" value="1"> 
                        <button class="add-to-cart-btn">
                            Add to Cart
                        </button>
                   </form>
                </div>
            </div>
        <%   
            }
        } else { 
        %>
            <p class="no-items">No menu items available</p>
        <% } %>
    </div>
</body>
</html>

