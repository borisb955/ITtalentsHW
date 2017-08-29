package cakes.child;

import cakes.Cake;
import cakes.Cake.CakeKind;

public class Baptist extends Cake implements Comparable<Baptist>{
	private String name;

	public Baptist(String name, String descr, int price, int pieces, String ownerName) {
		super(name, descr, price, pieces, CakeKind.CHILD, "Baptist");
		name = ownerName;
	}

	@Override
	public int compareTo(Baptist o) {
		return this.pieces - o.pieces;
	}
	
	
}
