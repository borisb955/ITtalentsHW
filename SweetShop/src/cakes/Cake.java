package cakes;

public abstract class Cake {
	protected String name;
	protected String descr;
	protected int price;
	protected int pieces;
	protected CakeKind kind;
	protected String type;
	protected int soldTimes;
	
	public enum CakeKind{
		STANDARD, WEDDING, SPECIAL, CHILD
	}

	public Cake(String name, String descr, int price, int pieces, CakeKind kind, String type) {
		super();
		this.name = name;
		this.descr = descr;
		this.price = price;
		this.pieces = pieces;
		this.kind = kind;
		this.type = type;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pieces;
		result = prime * result + price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Cake other = (Cake) obj;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (kind != other.kind)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pieces != other.pieces)
			return false;
		if (price != other.price)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.kind + " : " + this.type + ". Price -  " + this.price + ", pieces - " + this.pieces ;
	}


	public CakeKind getKind() {
		return kind;
	}
	
	public String getType() {
		return type;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getSoldTimes() {
		return soldTimes;
	}
	
	public void increasSold() {
		this.soldTimes++;
	}
	
}
