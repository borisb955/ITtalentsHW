package properties;

import java.util.Random;

public class Apartment extends Property {
	private String[] buildTypes = {"EPK", "Tuhla", "Panel", "Kirpich"};
	private String[] apTypes = {"Studio", "oneRoom", "twoRoom", "threeRoom", "Mezonet"};
	private String buildType;
	private String apType;
	
	public Apartment(String descr, String address, int price) {
		super(descr, address, 1, price);
		this.buildType = buildTypes[new Random().nextInt(4)];
		this.apType = apTypes[new Random().nextInt(5)];
	}
}
