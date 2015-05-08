package org.dispatcher.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.dispatcher.persistence.domain.Consignment;
import org.dispatcher.persistence.domain.Courier;
import org.dispatcher.persistence.domain.DataTransfer;

public class DispatcherServiceImpl implements DispatcherService {

	@Inject
	private MessagingService messagingService;

	@Inject
	private CourierService courierService;

	@Override
	public void dispatch(List<Consignment> consignmentList) {
		// assume it's not empty
		for (Consignment consignment : consignmentList) {
			consignment.setDispatched(new Date());
		}
	}

	@Override
	public void endDispatch(List<Consignment> consignmentList) {
		// assume it's not empty
		List<Integer> courierIdList = new ArrayList<Integer>();
		for (Consignment consignment : consignmentList) {
			consignment.setDispatched(new Date());
			courierIdList.add(consignment.getCourier().getId());
		}

		// get the
		List<Courier> couriers = courierService.getCourierByIds(courierIdList);
		for (Courier courier : couriers) {
			courier.setDataTransfer(this.getConsignmentNumbers(courier.getConsignments()));
			this.sendMessage(courier.getDataTransfer());
		}
	}

	private DataTransfer getConsignmentNumbers(Set<Consignment> consignments) {
		List<String> numbers = new ArrayList<>();
		for (Consignment c : consignments) {
			numbers.add(c.getUniqueConsignmentId());
		}
		DataTransfer t = new DataTransfer();
		t.setConsignmentNumbers(numbers);
		return t;
	}

	private void sendMessage(DataTransfer dataTransfer) {
		messagingService.sendMessage(dataTransfer);
	}

}
