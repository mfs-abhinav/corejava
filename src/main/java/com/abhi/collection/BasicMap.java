package com.abhi.collection;

import java.util.HashMap;
import java.util.Map;

public class BasicMap {
	public static void main(String[] args) {
		/*
		 * Map<String, String> m = new HashMap<String, String>();
		 * 
		 * m.put("1", "A"); m.put("2", "B"); m.put("3", "C"); m.put("4", "A");
		 * m.put("1", "Z");
		 * 
		 * System.out.println(m);
		 * 
		 * Map<String, String> m1 = new HashMap<String, String>(); m1.put("100",
		 * "abhi"); m1.put("99", "raj"); m1.put("90", "you");
		 * System.out.println(m1);
		 * 
		 * m.putAll(m1); System.out.println(m);
		 */

		/*
		 * for (String key : m.keySet()) { System.out.println(key + "  " +
		 * m.get(key)); }
		 */
		/*
		 * for (Map.Entry<String, String> entry : m.entrySet()) { String key =
		 * entry.getKey(); System.out.println(key + "  " + m.get(key)); }
		 */

		Map<Price, String> m = new HashMap<Price, String>();
		Price p1 = new Price("apple", 50);
		m.put(p1, "apple");
		m.put(new Price("banana", 50), "banana");
		m.put(new Price("apple", 60), "grape");

		/*
		 * for (Price key : m.keySet()) { System.out.println(m.get(key)); }
		 */

		/*
		 * Iterator<Price> ite = m.keySet().iterator(); while ( ite.hasNext() )
		 * { System.out.println(m.get(ite.next())); }
		 */

		/*
		 * Iterator<Map.Entry<Price, String>> ite = m.entrySet().iterator();
		 * while ( ite.hasNext() ) { System.out.println(ite.next().getValue());
		 * }
		 */
	}
}

class Price {
	private String item;
	private int price;

	Price(String item, int price) {
		this.item = item;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public int getPrice() {
		return price;
	}

	public String toString() {
		return this.item + " price is " + this.price;
	}

	/*
	 * public boolean equals(Object o) { if (o instanceof Price && this.item ==
	 * ((Price) o).getItem() && this.price == ((Price) o).getPrice()) { return
	 * true; } else { return false; } }
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + price;
		return result;
	}
}

class CustomerID {
	private long crmID;
	private int nameSpace;

	public CustomerID(long crmID, int nameSpace) {
		super();
		this.crmID = crmID;
		this.nameSpace = nameSpace;
	}

	public boolean equals(Object obj) {
		// null instanceof Object will always return false
		if (!(obj instanceof CustomerID))
			return false;
		if (obj == this)
			return true;
		return this.crmID == ((CustomerID) obj).crmID && this.nameSpace == ((CustomerID) obj).nameSpace;
	}

	/*
	 * public int hashCode() { int result = 0; result = (int)(crmID/12) +
	 * nameSpace; return result; }
	 */

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put(new CustomerID(2345891234L, 0), "Jeff Smith");
		System.out.println(m.get(new CustomerID(2345891234L, 0)));
	}

}
