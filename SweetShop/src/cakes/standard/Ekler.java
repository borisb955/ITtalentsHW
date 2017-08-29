package cakes.standard;

import java.util.Random;

import cakes.Cake;
import cakes.Cake.CakeKind;

public class Ekler extends Cake implements Comparable<Ekler> {
	private boolean isSyruped;
	
	public Ekler(String name, String descr, int price, int pieces) {
		super(name, descr, price, pieces, CakeKind.STANDARD, "Ekler");
		this.isSyruped = new Random().nextBoolean();
	}
	
	@Override
	public int compareTo(Ekler o) {
		return o.price - this.price;
	}
}
