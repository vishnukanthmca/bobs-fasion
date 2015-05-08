package org.dispatcher.core.service;

import java.util.List;

import org.dispatcher.persistence.domain.Consignment;

public interface DispatcherService {
	void dispatch(List<Consignment> consignmentList);

	void endDispatch(List<Consignment> consignmentList);
}
