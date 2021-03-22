package br.com.zup.orange.transaction;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionMessage transactionMessage) {
        System.out.println(transactionMessage.toString());
    }
}
