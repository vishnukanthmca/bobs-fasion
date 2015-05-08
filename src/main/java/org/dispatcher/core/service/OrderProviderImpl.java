package org.dispatcher.core.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.dispatcher.persistence.domain.Order;
import org.dispatcher.persistence.repository.OrderRepository;

public class OrderProviderImpl implements OrderProvider {

	@Inject
	private OrderRepository orderRepository;

	@Override
	public List<Order> getOrdersBy(Date startDate, Date endDate, Integer startResult, Integer maxResults) {
		return orderRepository.getOrdersBy(startDate, endDate, startResult, maxResults);
	}

	@Override
	public Integer getOrdersCount(Date startDate, Date endDate) {
		return orderRepository.getOrdersCount(startDate, endDate);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}
}
