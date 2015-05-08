package org.dispatcher.core.service;

import java.util.List;

import org.dispatcher.persistence.domain.Consignment;
import org.dispatcher.service.util.DispatchPeriod;

public interface ConsigmentService {

	public void createConsigment();

	public List<Consignment> getConsignmentsByDispatchPeriod(DispatchPeriod dispatchPeriod);

}