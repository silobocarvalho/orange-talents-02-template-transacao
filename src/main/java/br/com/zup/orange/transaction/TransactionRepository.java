package br.com.zup.orange.transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<TransactionRequest, String> {

    public boolean existsByCardCardId(String cardId);
	

	public List<TransactionRequest> findTop10ByCardCardIdOrderByReleaseTimeDesc(@Valid @NotEmpty String cardId);
	
}
