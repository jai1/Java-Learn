package org.learn.spring;

public class Restaurant {
	IHotDrink hotDrink;
	
	Restaurant(IHotDrink hd){
		this.hotDrink = hd;
	}
	
	public void prepareHotDrink() {
		hotDrink.prepareHotDrink();
	}
}
