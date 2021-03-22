package br.com.zup.orange.kafka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BusinessRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonProperty("nome")
	private String name;

	@JsonProperty("cidade")
	private String city;

	@JsonProperty("endereco")
	private String address;

	@Deprecated
	public BusinessRequest() {
	}

	public BusinessRequest(String name, String city, String address) {
		this.name = name;
		this.city = city;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public long getId() {
		return id;
	}
	

}
