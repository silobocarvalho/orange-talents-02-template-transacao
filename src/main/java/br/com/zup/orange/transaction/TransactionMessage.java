package br.com.zup.orange.transaction;

import java.math.BigDecimal;

public class TransactionMessage {

	private String id;

    private BigDecimal value;

	@Override
	public String toString() {
		return "TransactionMessage [id=" + id + ", value=" + value + "]";
	}
    
    
    
}
