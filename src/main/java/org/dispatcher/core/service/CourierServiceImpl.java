package org.dispatcher.core.service;

import java.util.List;

import javax.inject.Inject;

import org.dispatcher.persistence.domain.Courier;
import org.dispatcher.persistence.repository.CourierRepository;

public class CourierServiceImpl implements CourierService {

	@Inject
	private CourierRepository courierRepository;
	
	@Override
	public List<Courier> getCourierByIds(List<Integer> ids) {
		return courierRepository.getCourierByIds(ids);
	}

}
