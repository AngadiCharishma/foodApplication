package com.foodapp.model;

public class OrderItems {
    private int orderItemId;
    private int orderId;
    private int MenuId;
    private int quantity;
    private int itemTotal;
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}
	public OrderItems() {
		super();
	}
	public OrderItems(int orderItemId, int orderId, int menuId, int quantity, int itemTotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		MenuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}
	@Override
	public String toString() {
		return orderItemId + "    "+ orderId + "    "+ MenuId + "     "+ 
				quantity + "     "+ itemTotal ;
	}
    
}
