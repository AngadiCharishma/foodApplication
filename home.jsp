<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.foodapp.model.Restaurant"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurant Listings</title>
<style>
/* Reset and Base Styles */
:root {
	--primary-color: #3b82f6;
	--primary-dark: #2563eb;
	--secondary-color: #f59e0b;
	--success-color: #22c55e;
	--danger-color: #ef4444;
	--background-color: #f8fafc;
	--card-background: #ffffff;
	--text-primary: #1e293b;
	--text-secondary: #64748b;
	--shadow-sm: 0 1px 2px rgba(0, 0, 0, 0.05);
	--shadow-md: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
	--shadow-lg: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
		'Helvetica Neue', Arial, sans-serif;
	background-color: var(--background-color);
	color: var(--text-primary);
	line-height: 1.5;
}

/* Navbar Styles */
.navbar {
	background: linear-gradient(to right, var(--primary-color),
		var(--primary-dark));
	padding: 1rem;
	position: sticky;
	top: 0;
	z-index: 50;
	box-shadow: var(--shadow-md);
}

.navbar-container {
	max-width: 1280px;
	margin: 0 auto;
	padding: 0 1rem;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.navbar-brand {
	font-size: 1.5rem;
	font-weight: 700;
	color: white;
	letter-spacing: -0.025em;
}

/* Profile Section */
.profile-section {
	display: flex;
	align-items: center;
	gap: 0.75rem;
}

.profile-icon {
	width: 2.5rem;
	height: 2.5rem;
	background-color: rgba(255, 255, 255, 0.1);
	border-radius: 9999px;
	display: flex;
	align-items: center;
	justify-content: center;
	transition: background-color 0.2s;
	cursor: pointer;
}

.profile-icon:hover {
	background-color: rgba(255, 255, 255, 0.2);
}

.profile-icon svg {
	width: 1.25rem;
	height: 1.25rem;
	color: white;
}

.welcome-text {
	color: white;
	font-size: 0.875rem;
	font-weight: 500;
}

/* Main Content */
.container {
	max-width: 1280px;
	margin: 2rem auto;
	padding: 0 1rem;
}

/* Restaurant Grid */
.restaurant-grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
	gap: 1.5rem;
	padding: 1rem 0;
	max-width: 1024px;
    margin: 0 auto;
}

/* Restaurant Card */
.restaurant-card {
	background: var(--card-background);
	border-radius: 0.75rem;
	overflow: hidden;
	box-shadow: var(--shadow-sm);
	transition: all 0.3s ease;
	height: auto;
	display: flex;
	flex-direction: column;
}

.restaurant-card:hover {
	transform: translateY(-0.25rem);
	box-shadow: var(--shadow-lg);
}

.card-image-container {
	position: relative;
	padding-top: 50%; /* 16:9 Aspect Ratio */
	overflow: hidden;
}

.card-image {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
	transition: transform 0.3s ease;
}

.restaurant-card:hover .card-image {
	transform: scale(1.05);
}

.status-badge {
    padding: 0.25rem 0.75rem;
    font-size: 0.75rem;
}

.status-open {
	background-color: var(--success-color);
	color: white;
}

.status-closed {
	background-color: var(--danger-color);
	color: white;
}

.card-content {
	padding: 1rem;
	flex-grow: 1;
	display: flex;
	flex-direction: column;
	gap: 0.75rem;
}

.restaurant-name {
	font-size: 1.125rem;
	font-weight: 600;
	color: var(--text-primary);
}

.info-row {
    display: flex;
    align-items: center;
    gap: 0.375rem;
    color: var(--text-secondary);
    font-size: 0.875rem;
}

.info-icon {
    width: 0.875rem;
    height: 0.875rem;
    flex-shrink: 0;
}

.rating {
	display: inline-flex;
	align-items: center;
	gap: 0.25rem;
	padding: 0.25rem 0.75rem;
	background-color: var(--secondary-color);
	color: white;
	border-radius: 9999px;
	font-weight: 600;
}

/* Button Styles */
/*.button-container {
	text-align: center;
	margin-top: 3rem;
}

.explore-button {
	display: inline-flex;
	align-items: center;
	justify-content: center;
	padding: 0.875rem 2rem;
	background-color: var(--primary-color);
	color: white;
	font-size: 1rem;
	font-weight: 600;
	border-radius: 9999px;
	text-decoration: none;
	transition: all 0.2s;
	border: none;
	cursor: pointer;
}

.explore-button:hover {
	background-color: var(--primary-dark);
	transform: translateY(-2px);
}*/

/* Add these new styles for the View Menu button */
.view-menu-button {
     display: inline-flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    padding: 0.75rem;
    margin-top: 0.5rem;
    background-color: var(--primary-color);
    color: white;
    font-size: 0.875rem;
    font-weight: 600;
    border-radius: 0.5rem;
    text-decoration: none;
    transition: all 0.2s;
    border: none;
    cursor: pointer;
}

.view-menu-button:hover {
    background-color: var(--primary-dark);
    transform: translateY(-1px);
    box-shadow: var(--shadow-sm);
}



/* Responsive Design */
@media ( max-width : 768px) {
	.restaurant-grid {
		grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
	}
	.welcome-text {
		display: none;
	}
}

@media ( max-width : 640px) {
	.restaurant-grid {
		grid-template-columns: 1fr;
	}
	.navbar-brand {
		font-size: 1.25rem;
	}
}
</style>
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar">
		<div class="navbar-container">
			<h1 class="navbar-brand">Food Kart</h1>
			<div class="profile-section">
				<div class="profile-icon">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
						fill="none" stroke="currentColor" stroke-width="2"
						stroke-linecap="round" stroke-linejoin="round">
                        <path
							d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                        <circle cx="12" cy="7" r="4"></circle>
                    </svg>
				</div>
				<span class="welcome-text">Welcome, <%= session.getAttribute("name") %>!
				</span>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="container">
		<div class="restaurant-grid">
			<% 
            List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("RestaurantList");
            for (Restaurant restaurant : restaurants) {
            %>

			
				<div class="restaurant-card">
				
					<div class="card-image-container">
						<img src="<%= restaurant.getImagePath() %>"
							alt="<%= restaurant.getName() %>" class="card-image">
							 <span
							class="status-badge <%= restaurant.getisActive() ? "status-open" : "status-closed" %>">
							<%= restaurant.getisActive() ? "Open" : "Closed" %>
						</span>
					</div>
					
					<div class="card-content">
						<h2 class="restaurant-name"><%= restaurant.getName() %></h2>

						<div class="info-row">
							<svg class="info-icon" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2">
                                <path
									d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
                            </svg>
							<span><%= restaurant.getCusineType() %></span>
						</div>

						<div class="info-row">
							<svg class="info-icon" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2">
                                <circle cx="12" cy="12" r="10"></circle>
                                <polyline points="12 6 12 12 16 14"></polyline>
                            </svg>
							<span><%= restaurant.getDeliveryTime() %> min</span>
						</div>

						<div class="info-row">
							<svg class="info-icon" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2">
                                <path
									d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0 1 18 0z"></path>
                                <circle cx="12" cy="10" r="3"></circle>
                            </svg>
							<span><%= restaurant.getAddress() %></span>
						</div>

						<div class="info-row">
							<div class="rating">
								<svg class="info-icon" xmlns="http://www.w3.org/2000/svg"
									viewBox="0 0 24 24" fill="currentColor" stroke="none">
                                    <polygon
										points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon>
                                </svg>
								<%= String.format("%.1f", restaurant.getRatings()) %>
							</div>
						</div>
						
						
						<!-- Add this new button -->
                       <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>" class="view-menu-button">
                                  View Menu
                                       </a>
						
					</div>
					
				</div>
				
			
			<% } %>
		</div>


		<!--<div class="button-container">
			<button class="explore-button">Explore More</button>
		</div>--->
	</div>
</body>
</html>