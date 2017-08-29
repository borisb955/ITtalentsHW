package cakes.child;

import cakes.Cake;

public class BDay extends Cake implements Comparable<BDay>{
	private String name;

	public BDay(String name, String descr, int price, int pieces, String ownerName) {
		super(name, descr, price, pieces, CakeKind.CHILD, "B-Day");
		name = ownerName;
	}
	
	
	@Override
	public int compareTo(BDay o) {
		return this.pieces - o.pieces;
	}

}
