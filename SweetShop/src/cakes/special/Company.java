package cakes.special;

import cakes.Cake;
import cakes.Cake.CakeKind;
import cakes.standard.Biscuit;

public class Company extends Cake implements Comparable<Company>{
	private String name;
	
	public Company(String name, String descr, int price, int pieces, String ownerName) {
		super(name, descr, price, pieces, CakeKind.SPECIAL, "Company");
		this.name = ownerName;
	}
	
	@Override
	public int compareTo(Company o) {
		return o.price - this.price;
	}
}
