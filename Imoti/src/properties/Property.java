package properties;

import clients.Seller;

public abstract class Property implements Comparable<Property> {
	private String descr;
	private String address;
	private int uniqueType;
	private int price;
	private Seller seller;
	private static int uniqueAddressNum;
	
	public Property(String descr, String address, int type, int price) {
		this.descr = descr;
		this.address = address + uniqueAddressNum++;
		this.uniqueType = type;
		this.price = price;
	}
	
	@Override
	public int compareTo(Property o) {
		if(this.uniqueType == o.uniqueType) {
			return o.price - this.price;
		}
		return this.uniqueType - o.uniqueType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}

	public int getPrice() {
		return price;
	}
	
	public Seller getSeller() {
		return seller;
	}

	public void addSeller(Seller s) {
		this.seller = s;
	}
	
	@Override
	public String toString() {
		return this.uniqueType + " : " + this.address;
	}
	
	public int getUniqueType() {
		return uniqueType;
	}
}
