package cakes.special;

import cakes.Cake;
import cakes.standard.Biscuit;

public class Jubilee extends Cake implements Comparable<Jubilee>{
	private String name;
	
	public Jubilee(String name, String descr, int price, int pieces, String ownerName) {
		super(name, descr, price, pieces, CakeKind.SPECIAL, "Jubilee");
		this.name = ownerName;
	}
	
	
	@Override
	public int compareTo(Jubilee o) {
		return o.price - this.price;
	}
}
