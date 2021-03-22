package br.com.zup.orange.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.orange.transaction.TransactionRepository;

@Component
public class TransactionListener {

	@Autowired
	TransactionRepository transactionRepository;
	
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionRequest transactionRequest) {
        System.out.println(transactionRequest.toString());
        
        transactionRepository.save(transactionRequest);
        
    }
}
