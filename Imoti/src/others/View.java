package others;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import agency.Agent;
import clients.Buyer;
import properties.Property;

public class View {
	private Property prop;
	private Agent agent;
	private Buyer buyer;
	private LocalDateTime dateTime;
	
	public View(Property p, Agent a, Buyer b) {
		this.prop = p;
		this.agent = a;
		this.buyer = b;
		this.dateTime = LocalDateTime.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
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
		View other = (View) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		return true;
	}
	
	public Property getProp() {
		return prop;
	}
	
}
