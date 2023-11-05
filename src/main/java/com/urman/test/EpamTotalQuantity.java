package com.urman.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EpamTotalQuantity {

	static class Inventory {
		private String item;
		private int qty;

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public Inventory(String item, int qty) {
			super();
			this.item = item;
			this.qty = qty;
		}

	}

	public static void main(String[] args) {
		List<Inventory> list = new ArrayList<>();
		list.add(new Inventory("item1", 5));
		list.add(new Inventory("item1", 10));
		list.add(new Inventory("item2", 10));
		list.add(new Inventory("item2", 10));
		list.add(new Inventory("item3", 8));
		list.add(new Inventory("item1", 9));
		list.add(new Inventory("item3", 8));
		Map<String, Integer> map = list.stream()
				.collect(Collectors.groupingBy(Inventory::getItem, Collectors.summingInt(Inventory::getQty)));
		System.out.println(map);

	}

}
