package model.ice;

import java.util.*;


public class IceOrder {
	private MainDish mainDish;
	private Topping toppings;
	private int totalPrice;
		
		
	public IceOrder(String mainDish,String[] toppings) {
		this.mainDish=new MainDish(mainDish);
		this.toppings= new Topping(toppings);
		this.totalPrice=this.mainDish.getPrice()+this.toppings.calculateToppingPrice();
	}


	public MainDish getMainDish() {
		return mainDish;
	}
	public Topping getToppings() {
		return toppings;
	}
	public int getTotalPrice() {
		return totalPrice;
	}



	
	
}


