package properties;

import java.util.Random;

public class House extends Property {
	private String[] buildTypes = {"EPK", "Tuhla", "Panel", "Kirpich"};
	private String[] hTypes = {"Floor House", "Whole House"};
	private String buildType;
	private String hType;
	private int parkPlaces;
	private int yardArea;
	
	public House(String descr, String address, int price, int parkPlaces, int yardArea) {
		super(descr, address, 2, price);
		this.buildType = buildTypes[new Random().nextInt(4)];
		this.hType = hTypes[new Random().nextInt(2)];
		this.parkPlaces = parkPlaces;
		this.yardArea = yardArea;
	}
}
