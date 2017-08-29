package cakes.wedding;

import java.util.Random;

import cakes.Cake;
import cakes.Cake.CakeKind;
import cakes.child.Baptist;

public class Medium extends Cake implements Comparable<Medium>{
	private int levels;
	
	public Medium(String name, String descr, int price, int pieces) {
		super(name, descr, price, pieces, CakeKind.WEDDING, "Medium");
		this.levels = new Random().nextInt(5) + 1;
	}
	
	@Override
	public int compareTo(Medium o) {
		return this.pieces - o.pieces;
	}
}
