package org.dispatcher.persistence.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Courier {

	@Id
	private Integer id;

	@OneToMany(mappedBy = "courier")
	private Set<Consignment> consignments;

	@OneToOne
	private DataTransfer dataTransfer;

	/**
	 * I assume, courier uses only one transport mechanism at one time.
	 * Otherwise it will be oneToMany.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	private Transport transport;

	private String address;

	private String uuidRestUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Consignment> getConsignments() {
		return consignments;
	}

	public void setConsignments(Set<Consignment> consignments) {
		this.consignments = consignments;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUuidRestUrl() {
		return uuidRestUrl;
	}

	public void setUuidRestUrl(String uuidRestUrl) {
		this.uuidRestUrl = uuidRestUrl;
	}

	public DataTransfer getDataTransfer() {
		return dataTransfer;
	}

	public void setDataTransfer(DataTransfer dataTransfer) {
		this.dataTransfer = dataTransfer;
	}

}
