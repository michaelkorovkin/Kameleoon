package com.kameleoon.test.model.repos;

import com.kameleoon.test.model.dto.QuoteValue;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface QuoteValueRepository extends CrudRepository<QuoteValue, Long> {
    @Modifying
    @Query(value = "DELETE FROM quote_values u WHERE u.quote = :quote_id", nativeQuery = true)
    @Transactional
    @Ignore
    public void deleteQuoteViewByQueryId (@Param("quote_id") Long quoteId);

    @Query(value = "SELECT * FROM quote_values u WHERE u.quote = :quote_id", nativeQuery = true)
    @Transactional
    public List<QuoteValue> selectQuoteViewByQueryId (@Param("quote_id") Long quoteId);
}
