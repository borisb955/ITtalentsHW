package properties;

import java.util.Random;

public class Parcel extends Property {
	private String[] pTypes = {"Field", "Meadow", "Forest"};
	private String pType;
	private boolean isInRegulation;
	
	public Parcel(String descr, String address, int price, boolean isInRegulation) {
		super(descr, address, 3, price);
		this.pType = pTypes[new Random().nextInt(3)];
		this.isInRegulation = isInRegulation;
	}
	
	
}
