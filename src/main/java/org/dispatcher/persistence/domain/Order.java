package org.dispatcher.persistence.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order {

	@Id
	private Integer id;

	@ManyToOne
	private Customer customer;

	@OneToOne
	private Consignment consignment;

	@OneToOne
	private Courier courier;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCutomer(Customer customer) {
		this.customer = customer;
	}

	public Consignment getConsignment() {
		return consignment;
	}

	public void setConsignment(Consignment consignment) {
		this.consignment = consignment;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}

}
