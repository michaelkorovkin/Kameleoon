package com.kameleoon.test.model.repos;

import com.kameleoon.test.model.dto.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

}
