package cakes.standard;

import java.util.Random;

import cakes.Cake;

public class Chocolate extends Cake implements Comparable<Chocolate> {
	private boolean isSyruped;
	
	public Chocolate(String name, String descr, int price, int pieces) {
		super(name, descr, price, pieces, CakeKind.STANDARD, "Chocolate");
		this.isSyruped = new Random().nextBoolean();
	}
	
	@Override
	public int compareTo(Chocolate o) {
		return o.price - this.price;
	}
}
