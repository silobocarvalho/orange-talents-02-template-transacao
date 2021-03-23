package br.com.zup.orange.transaction;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/{cardId}")
	public ResponseEntity<Object> lastTransactionsByCard(
			@Valid @NotEmpty @PathVariable("cardId") String cardId) {

		if (!transactionRepository.existsByCardCardId(cardId)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		List<TransactionRequest> transactions = transactionRepository
				.findTop10ByCardCardIdOrderByReleaseTimeDesc(cardId);

		return new ResponseEntity<>(transactions, HttpStatus.OK);

	}
}
