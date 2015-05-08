package org.dispatcher.core.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.dispatcher.persistence.domain.Consignment;
import org.dispatcher.persistence.domain.Order;
import org.dispatcher.persistence.repository.ConsigmentRepository;
import org.dispatcher.service.util.ConsigmentNumberProvider;
import org.dispatcher.service.util.DateUtils;
import org.dispatcher.service.util.DispatchPeriod;

public class ConsigmentServiceImpl implements ConsigmentService {

	@Inject
	private ConsigmentNumberProvider consigmentNumberProvider;

	@Inject
	private ConsigmentRepository repository;

	private OrderProvider orderProvider;

	public void updateConsignments(Consignment consignment) {
		repository.updateConsignment(consignment);
	}

	@Override
	@Transactional
	public void createConsigment() {

		// process 1000 initially // TODO process all records 1000 at a time
		List<Order> allOrders = this.getOrdersByDate(new Date(), DateUtils.getNextDay(), 0, 1000);
		if (allOrders != null && !allOrders.isEmpty()) {
			for (Order order : allOrders) {
				Consignment consignment = new Consignment();
				consignment.setCreated(new Date());
				// I assume at the time of order creation, courier information
				// is provided.
				consignment.setCourier(order.getCourier());
				consignment.setOrder(order);
				// pass the rest url from courier to get the uuid, which I
				// assume the url is provided
				// when courier object is created and it will never be null
				consignment.setUniqueConsignmentId(consigmentNumberProvider.getUniqueConsigmentNumber(consignment
						.getCourier().getUuidRestUrl()));
				this.repository.saveConsignment(consignment);

				// TODO - error handling
			}
		}
	}

	private List<Order> getOrdersByDate(Date startDate, Date endDate, Integer startResult, Integer maxResults) {
		return orderProvider.getOrdersBy(startDate, endDate, startResult, maxResults);
	}

	@Override
	public List<Consignment> getConsignmentsByDispatchPeriod(DispatchPeriod dispatchPeriod) {

		List<Consignment> consignmentList = null;

		if (dispatchPeriod.equals(DispatchPeriod.Period.TODAY.name())) {
			consignmentList = this.getConsignmentsFromOrders(new Date(), DateUtils.getNextDay());
		} // TODO implement for other dispatch types custom which might require
			// orders between some specified time

		return consignmentList;
	}

	public List<Consignment> getConsignmentsFromOrders(Date startDate, Date endDate) {
		return this.repository.getConsigmentsFromOrder(startDate, endDate);
	}
}
