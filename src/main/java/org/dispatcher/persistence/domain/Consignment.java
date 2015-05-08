package org.dispatcher.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Consignment {

	@Id
	private Integer id;

	@Column
	private String uniqueConsignmentId;

	@OneToOne(fetch = FetchType.EAGER)
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	private Courier courier;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dispatched;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrived;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniqueConsignmentId() {
		return uniqueConsignmentId;
	}

	public void setUniqueConsignmentId(String uniqueConsignmentId) {
		this.uniqueConsignmentId = uniqueConsignmentId;
	}

	public Date getDispatched() {
		return dispatched;
	}

	public void setDispatched(Date dispatched) {
		this.dispatched = dispatched;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getArrived() {
		return arrived;
	}

	public void setArrived(Date arrived) {
		this.arrived = arrived;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}
}
