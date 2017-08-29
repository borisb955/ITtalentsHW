package cakes.standard;

import java.util.Random;

import cakes.Cake;
import cakes.Cake.CakeKind;

public class Fruit extends Cake implements Comparable<Fruit>{
	private boolean isSyruped;
	
	public Fruit(String name, String descr, int price, int pieces) {
		super(name, descr, price, pieces, CakeKind.STANDARD, "Fruit");
		this.isSyruped = new Random().nextBoolean();
	}
	
	@Override
	public int compareTo(Fruit o) {
		return o.price - this.price;
	}
}
