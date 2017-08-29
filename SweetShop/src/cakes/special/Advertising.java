package cakes.special;

import cakes.Cake;
import cakes.Cake.CakeKind;
import cakes.standard.Biscuit;

public class Advertising extends Cake implements Comparable<Advertising>{
	private String name;
	
	public Advertising(String name, String descr, int price, int pieces, String ownerName) {
		super(name, descr, price, pieces, CakeKind.SPECIAL, "Advertising");
		this.name = ownerName;
	}
	
	@Override
	public int compareTo(Advertising o) {
		return o.price - this.price;
	}
}
