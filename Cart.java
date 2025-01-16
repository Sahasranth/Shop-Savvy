package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Cart {
	private TreeMap<Integer, TreeMap<String, CartEntry>> aisleMap;
	private TreeMap<String, CartEntry> countMap;
	private static Cart INSTANCE;

	public static Cart getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Cart();
		}
		return INSTANCE;
	}

	public Cart() {
		this.aisleMap = new TreeMap<Integer, TreeMap<String, CartEntry>>();

	}

	public void addProduct(String productName) throws FileNotFoundException {
		System.out.println("BSK 1 "+ productName);
		Product prod = fetchProduct(productName);
		System.out.println("BSK 2 "+ prod);

		Integer aisle = prod.getAisle();
		System.out.println("BSK 3 "+ aisle);

		if (aisleMap.containsKey(aisle) == false) {
			countMap = new TreeMap<String, CartEntry>();
			aisleMap.put(aisle, countMap);
		}
		CartEntry entry = aisleMap.get(aisle).get(productName);
		System.out.println("BSK 4 "+ entry);

		if (entry != null) {

			entry.increaseQuantity();
			System.out.println("BSK 5");

		} else {
			System.out.println("BSK 6");

			CartEntry newEntry = new CartEntry(prod, 1);
			System.out.println("BSK 7");

			aisleMap.get(aisle).put(productName, newEntry);
			System.out.println("BSK 8");

		}
	}

	public void deleteProduct(String productName) throws FileNotFoundException {
		Product prod = fetchProduct(productName);
		Integer aisle = prod.getAisle();
		CartEntry entry = aisleMap.get(aisle).get(productName);
		if (entry != null) {
			entry.decreaseQuantity();
			if (entry.getQuantity() == 0) {
				aisleMap.get(aisle).remove(productName);
				if (aisleMap.get(aisle).isEmpty()) {
					aisleMap.remove(aisle);
				}
			}
		}
	}

	public Product fetchProduct(String productName) throws FileNotFoundException {
		Product cartProd = null;
		List<Product> availableProds = ReadingJson.ReadingJson();
		for (int i = 0; i < availableProds.size(); i++) {
			if (availableProds.get(i).getName().equals(productName)) {
				cartProd = availableProds.get(i);
			}
		}
		return cartProd;
	}

	public int getQuantity(String productName) throws FileNotFoundException {
		Product prod = fetchProduct(productName);
		Integer aisle = prod.getAisle();
		CartEntry entry = aisleMap.get(aisle).get(productName);
		if (entry != null) {
			return entry.getQuantity();
		}
		return 0;
	}

	public double calculateTotal() {
		double total = 0;
		Set<Integer> aisleKeys = aisleMap.keySet();
		List<Integer> aList = new ArrayList<Integer>();
		aList.addAll(aisleKeys);

		for (int i = 0; i < aList.size(); i++) {
			for (CartEntry c : aisleMap.get(aList.get(i)).values()) {
				total = total + (c.getProduct().getPrice() * c.getQuantity());
			}
		}
		return total;
	}

	public List<Integer> getAisles() {
		Set<Integer> aisleKeys = aisleMap.keySet();
		System.out.println("SAI 1 "+aisleKeys.size());
		List<Integer> aList = new ArrayList<Integer>();
		System.out.println("SAI 2 "+aList.size());

		aList.addAll(aisleKeys);
		return aList;
	}

	public List<String> getProductNames(Integer aisle) {
		Set<String> prodNameKeys = getCountMap(aisle).keySet();
		List<String> pList = new ArrayList<String>();
		pList.addAll(prodNameKeys);
		return pList;
	}

	public TreeMap<Integer, TreeMap<String, CartEntry>> getAisleMap() {
		return this.aisleMap;
	}

	public TreeMap<String, CartEntry> getCountMap(Integer aisle) {
		return this.aisleMap.get(aisle);
	}
}
