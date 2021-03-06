package com.kameleoon.test.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
class QuoteValueManagerTest extends QuoteValueManager {
    @Autowired
    QuoteValueManager quoteValueManager;

    @Test
    @Transactional
    @Rollback(false)
    void deleteQuoteValuesByQuote() {
        quoteValueManager.deleteQuoteValuesByQuote(36L);
    }
}