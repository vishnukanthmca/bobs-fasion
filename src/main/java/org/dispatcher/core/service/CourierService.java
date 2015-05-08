package org.dispatcher.core.service;

import java.util.List;

import org.dispatcher.persistence.domain.Courier;

public interface CourierService {

	public List<Courier> getCourierByIds(List<Integer> ids);
}
