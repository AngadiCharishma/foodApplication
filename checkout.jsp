<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            max-width: 400px;
            margin: 40px auto;
            padding: 20px;
            background-color: #f0f2f5;
        }

        h1 {
            text-align: center;
            color: #1a237e;
            margin-bottom: 24px;
            font-size: 28px;
            font-weight: 600;
           
            letter-spacing: 1px;
        }

        form {
            background-color: white;
            padding: 28px;
            border-radius: 12px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s ease;
        }

        form:hover {
            transform: translateY(-2px);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #2c3e50;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        textarea, select {
            width: 100%;
            padding: 12px;
            margin-bottom: 24px;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 14px;
            transition: all 0.3s ease;
            background-color: #f8f9fa;
        }

        textarea:focus, select:focus {
            outline: none;
            border-color: #3f51b5;
            box-shadow: 0 0 8px rgba(63, 81, 181, 0.2);
            background-color: white;
        }

        select {
            appearance: none;
            background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3e%3cpolyline points='6 9 12 15 18 9'%3e%3c/polyline%3e%3c/svg%3e");
            background-repeat: no-repeat;
            background-position: right 12px center;
            background-size: 16px;
            padding-right: 40px;
        }

        button {
            background-color: #3f51b5;
            color: white;
            padding: 14px 28px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
            font-weight: 600;
            width: 100%;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        button:hover {
            background-color: #303f9f;
            transform: translateY(-1px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        button:active {
            transform: translateY(0);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        textarea::placeholder {
            color: #9e9e9e;
        }

        /* Add a subtle animation for form elements */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }

        form > * {
            animation: fadeIn 0.5s ease forwards;
        }
    </style>
</head>
<body>
    <h1>Checkout</h1>
    <form action="checkout" method="post">
        <label for="address">Address</label>
        <textarea id="address" name="address" rows="4" placeholder="Enter your delivery address" required></textarea>
        
        <label for="payment">Payment Info</label>
        <select id="payment" name="paymentMethod" required>
            <option value="" disabled selected>Select Payment Method</option>
            <option value="credit">Credit Card</option>
            <option value="debit">Debit Card</option>
            <option value="cod">Cash on Delivery</option>
        </select>
        
        <button type="submit">Place Order</button>
    </form>
</body>
</html>