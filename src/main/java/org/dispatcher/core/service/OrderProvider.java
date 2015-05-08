package org.dispatcher.core.service;

import java.util.Date;
import java.util.List;

import org.dispatcher.persistence.domain.Order;

public interface OrderProvider {

	public List<Order> getAllOrders();

	public List<Order> getOrdersBy(Date startDate, Date endDate, Integer startResult, Integer maxResults);

	public Integer getOrdersCount(Date startDate, Date endDate);
}
