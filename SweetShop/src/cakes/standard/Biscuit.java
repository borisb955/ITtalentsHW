package cakes.standard;

import java.util.Random;

import cakes.Cake;
import cakes.Cake.CakeKind;

public class Biscuit extends Cake implements Comparable<Biscuit>{
	private boolean isSyruped;
	
	public Biscuit(String name, String descr, int price, int pieces) {
		super(name, descr, price, pieces, CakeKind.STANDARD, "Biscuit");
		this.isSyruped = new Random().nextBoolean();
	}

	@Override
	public int compareTo(Biscuit o) {
		return o.price - this.price;
	}		
	
	
}
