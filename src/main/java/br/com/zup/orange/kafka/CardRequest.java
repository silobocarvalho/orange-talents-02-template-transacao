package br.com.zup.orange.kafka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CardRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonProperty("id")
	String cardId;
	
	String email;

	@Deprecated
	public CardRequest() {}
	
	public CardRequest(String cardId, String email) {
		this.cardId = cardId;
		this.email = email;
	}

	public String getCardId() {
		return cardId;
	}

	public String getEmail() {
		return email;
	}


	
	
}
