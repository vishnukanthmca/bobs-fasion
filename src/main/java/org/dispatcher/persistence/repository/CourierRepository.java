package org.dispatcher.persistence.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.dispatcher.persistence.domain.Courier;

@NamedQueries({ @NamedQuery(name = CourierRepository.QUERY_GET_COURIER_BY_IDS, query = "SELECT c "
		+ "FROM Courier c where FETCH JOIN c.consignments WHERE c.id in :idList") })
public class CourierRepository {

	public static final String QUERY_GET_COURIER_BY_IDS = "getByIds";

	@PersistenceContext
	private EntityManager em;

	public List<Courier> getCourierByIds(List<Integer> ids) {

		TypedQuery<Courier> dateQuery = em.createNamedQuery(QUERY_GET_COURIER_BY_IDS, Courier.class).setParameter(
				"idList", ids);
		return dateQuery.getResultList();

	}

}
