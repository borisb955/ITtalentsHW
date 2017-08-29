package cakes.wedding;

import java.util.Random;

import cakes.Cake;
import cakes.child.Baptist;

public class Big extends Cake implements Comparable<Big>{
	private int levels;
	
	public Big(String name, String descr, int price, int pieces) {
		super(name, descr, price, pieces, CakeKind.WEDDING, "Big");
		this.levels = new Random().nextInt(7) + 1;
	}
	
	@Override
	public int compareTo(Big o) {
		return this.pieces - o.pieces;
	}
}
