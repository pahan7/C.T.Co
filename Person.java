package java_school_task;

import java.util.ArrayList;



public class Person {

	private String name;
	private ArrayList<Product> productList;
	private double totalPrice;
	
	public Person(String name)
	{
		this.name=name;
		productList = new ArrayList<Product>();
		totalPrice = 0;
	}
	
	public void addProduct(String productName, double productPrice)
	{
		productList.add(new Product(productName, productPrice));
		totalPrice+=productPrice;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	
	
	public double getDifference(double perPerson)
	{
		return totalPrice-perPerson;
	}
	
	public void updateTotalPrice(double price)
	{
		totalPrice-=price;
	}
	
	public void setTotalPrice(double price)
	{
		totalPrice=price;
	}
	
	
}
