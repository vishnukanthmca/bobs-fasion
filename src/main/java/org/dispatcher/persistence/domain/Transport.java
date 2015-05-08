package org.dispatcher.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transport {

	@Id
	private Integer id;

	/**
	 * I assume if the transport mechanism is FTP, the address holds the ftp
	 * url. If it's email it will hold email address. If it's a telegram it will
	 * hold the actual address. (If we want to track actual address and if it's
	 * used often we can change it to Address object.
	 */
	@Column
	private String address;

	@Column
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
