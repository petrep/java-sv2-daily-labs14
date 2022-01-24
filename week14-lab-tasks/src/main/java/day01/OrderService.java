package day01;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

import java.util.List;

import java.util.Optional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderService {
	private List<Order> orders = new ArrayList<>();

	public void saveOrder(Order order) {
		orders.add(order);
	}

	public List<Order> findOrderByStatus(String status) {
		return orders.stream().
			filter(o-> o.getStatus().equals(status))
				  .collect(Collectors.toList());
	}

	public long countOrdersByStatus(String status) {
		long orderCount = 0;

		orderCount = orders.stream().
			filter(o-> o.getStatus().equals(status)).count();

		return orderCount;
	}

	public List<Order> getOrdersBetweenDates(LocalDate start, LocalDate end) {
		return orders.stream().
			filter(o -> o.getOrderDate().isAfter(start) && o.getOrderDate().isBefore(end))
				.collect(Collectors.toList());
//  EZ IS JÓ MEGOLDÁS:
//				return orders.stream().
//			filter(o -> o.getOrderDate().isAfter(start)).filter(o.getOrderDate().isBefore(end))
//				.collect(Collectors.toList());
	}

	public boolean isOrderCountLessThan (int maxOrderCount) {
		return orders.stream().anyMatch(o -> o.getProducts().size() < maxOrderCount);
	}

	public Order findOrderWithMostProduct() {
	// EZ IS JÓ MEGOLDÁS:
//		return orders.stream()
//			.max(new Comparator<Order>() {
//				@Override
//				public int compare(Order o1, Order o2) {
//					return o1.getProducts().size()-o2.getProducts().size();
//				}
//			}).orElseThrow(()-> new IllegalStateException("List is empty"));
	return orders.stream().sorted(Collections.reverseOrder(Comparator.comparing(o->o.getProducts().size())))
		.findFirst().orElseThrow(()-> new IllegalStateException("Empty list"));
	}

	public List<Order> getOrdersWithProductInCategory(String category) {
		return orders.stream().filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals(category)))
			.collect(Collectors.toList());
	}

}