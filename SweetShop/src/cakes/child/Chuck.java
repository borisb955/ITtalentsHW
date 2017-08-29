package cakes.child;

import cakes.Cake;
import cakes.Cake.CakeKind;

public class Chuck extends Cake implements Comparable<Chuck>{
	private String name;

	public Chuck(String name, String descr, int price, int pieces, String ownerName) {
		super(name, descr, price, pieces, CakeKind.CHILD, "Chuck");
		name = ownerName;
	}
	
	@Override
	public int compareTo(Chuck o) {
		return this.pieces - o.pieces;
	}
}
