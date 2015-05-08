package org.dispatcher.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

//TODO - add necessary annotations
@Entity
public class DataTransfer {

	@Id
	private Integer id;

	private String type;

	private String url;

	private List<String> consignmentNumbers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getConsignmentNumbers() {
		return consignmentNumbers;
	}

	public void setConsignmentNumbers(List<String> consignmentNumbers) {
		this.consignmentNumbers = consignmentNumbers;
	}

}
