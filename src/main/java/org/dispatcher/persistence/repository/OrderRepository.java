package org.dispatcher.persistence.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.dispatcher.persistence.domain.Order;

//TODO - create named queries
public class OrderRepository {

	public static final String QUERY_GET_BY_START_AND_END_DATE = "getByStartAndEndDate";

	@PersistenceContext
	private EntityManager em;

	public List<Order> getOrdersBy(Date startDate, Date endDate, Integer startResult, Integer maxResults) {

		TypedQuery<Order> dateQuery = em.createNamedQuery(QUERY_GET_BY_START_AND_END_DATE, Order.class)
				.setParameter("startDate", startDate).setParameter("endDate", endDate).setFirstResult(startResult)
				.setMaxResults(maxResults);
		return dateQuery.getResultList();

	}

	public Integer getOrdersCount(Date startDate, Date endDate) {
		// TODO implement get count by dates
		return null;
	}
}
