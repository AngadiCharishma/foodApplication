<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Placed Successfully</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: Arial, sans-serif;
            overflow: hidden;
        }
        .background {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(45deg, #ff9a9e 0%, #fad0c4 99%, #fad0c4 100%);
            z-index: -1;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
        .success-card {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
            position: relative;
            overflow: hidden;
        }
        h1 {
            color: #333;
            font-size: 24px;
            margin: 0;
            opacity: 0;
            animation: fade-in 0.5s ease-out 0.5s forwards;
        }
        @keyframes fade-in {
            0% { opacity: 0; transform: translateY(10px); }
            100% { opacity: 1; transform: translateY(0); }
        }
        .spark {
            position: absolute;
            width: 5px;
            height: 5px;
            border-radius: 50%;
            background-color: #ffeb3b;
            opacity: 0;
            animation: spark-animation 0.5s ease-out;
        }
        @keyframes spark-animation {
            0% { transform: scale(0); opacity: 1; }
            100% { transform: scale(20); opacity: 0; }
        }
    </style>
</head>
<body>
    <div class="background"></div>
    <div class="container">
        <div class="success-card">
            <h1>Order Placed Successfully</h1>
        </div>
    </div>

    <script>
        function createSpark() {
            const spark = document.createElement('div');
            spark.classList.add('spark');
            spark.style.left = Math.random() * 100 + '%';
            spark.style.top = Math.random() * 100 + '%';
            document.querySelector('.success-card').appendChild(spark);

            setTimeout(() => {
                spark.remove();
            }, 500);
        }

        setInterval(createSpark, 300);
    </script>
</body>
</html>

