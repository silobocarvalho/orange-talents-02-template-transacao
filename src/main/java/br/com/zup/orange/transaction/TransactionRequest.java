package br.com.zup.orange.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

@Valid
@Entity
public class TransactionRequest {

	@Id
    private String id;

    @Positive
    @NotNull
    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    @ManyToOne(cascade = CascadeType.ALL)
    private BusinessRequest business;

    @JsonProperty("cartao")
    @ManyToOne(cascade = CascadeType.ALL)
    private CardRequest card;

    @JsonProperty("efetivadaEm")
    private LocalDateTime releaseTime;

    @Deprecated
    public TransactionRequest() {}
    
	public TransactionRequest(@NotNull String id, @Positive @NotNull BigDecimal value, BusinessRequest business,
			CardRequest card, LocalDateTime releaseTime) {
		this.id = id;
		this.value = value;
		this.business = business;
		this.card = card;
		this.releaseTime = releaseTime;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public BusinessRequest getBusiness() {
		return business;
	}

	public CardRequest getCard() {
		return card;
	}

	public LocalDateTime getReleaseTime() {
		return releaseTime;
	}

	@Override
	public String toString() {
		return "TransactionRequest [id=" + id + ", value=" + value + ", business=" + business.getName() + ", card=" + card.getCardId()
				+ ", releaseTime=" + releaseTime + "]";
	}

    
    
	
}
