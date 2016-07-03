package org.learn.spring;

public class Tea implements IHotDrink {
	@Override
	public void prepareHotDrink() {
		System.out.println("Preparing Tea !!");
	}
}
