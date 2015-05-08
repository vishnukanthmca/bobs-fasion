package org.dispatcher.persistence.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.dispatcher.persistence.domain.Consignment;
import org.dispatcher.persistence.domain.Courier;

@NamedQueries({
		@NamedQuery(name = ConsigmentRepository.QUERY_GET_BY_START_AND_END_DATE, query = "SELECT c "
				+ "FROM Consigment c where c.startDate = :startDate AND c.endDate = :endDate"),
		@NamedQuery(name = ConsigmentRepository.QUERY_GET_BY_ORDER_AND_START_AND_END_DATE, query = "SELECT c "
				+ "FROM Consigment c JOIN c.order o.created between :startDate :endDate") })
public class ConsigmentRepository {

	public static final String QUERY_GET_BY_START_AND_END_DATE = "getByStartAndEndDate";

	public static final String QUERY_GET_BY_ORDER_AND_START_AND_END_DATE = "getByOrderAndStartAndEndDate";

	public static final String QUERY_GET_BY_COURIER = "getByCourierGroup";

	@PersistenceContext
	private EntityManager em;

	public List<Consignment> getConsigmentsByDate(Date startDate, Date endDate) {

		TypedQuery<Consignment> dateQuery = em.createNamedQuery(QUERY_GET_BY_START_AND_END_DATE, Consignment.class)
				.setParameter("startDate", startDate).setParameter("endDate", endDate);
		return dateQuery.getResultList();

	}

	public List<Consignment> getConsigmentsFromOrder(Date startDate, Date endDate) {
		TypedQuery<Consignment> dateQuery = em
				.createNamedQuery(QUERY_GET_BY_ORDER_AND_START_AND_END_DATE, Consignment.class)
				.setParameter("startDate", startDate).setParameter("endDate", endDate);
		return dateQuery.getResultList();
	}

	@Transactional(value = TxType.REQUIRED)
	public void saveConsignment(Consignment consignment) {
		em.persist(consignment);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateConsignment(Consignment consignment) {
		em.merge(consignment);
	}

}
