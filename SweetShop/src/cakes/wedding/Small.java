package cakes.wedding;

import java.util.Random;

import cakes.Cake;
import cakes.Cake.CakeKind;
import cakes.child.Baptist;

public class Small extends Cake implements Comparable<Small>{
	private int levels;
	
	public Small(String name, String descr, int price, int pieces) {
		super(name, descr, price, pieces, CakeKind.WEDDING, "Small");
		this.levels = new Random().nextInt(3) + 1;
	}
	
	@Override
	public int compareTo(Small o) {
		return this.pieces - o.pieces;
	}
}
