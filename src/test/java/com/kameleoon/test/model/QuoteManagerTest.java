package com.kameleoon.test.model;

import com.kameleoon.test.model.dto.Quote;
import com.kameleoon.test.model.dto.QuoteValue;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class QuoteManagerTest {
    @Autowired
    QuoteManager quoteManager;
    @Autowired
    QuoteValueManager quoteValueManager;
    @Test
    @Ignore
    public void listAllQuotes() {
        List<Quote> quotes = quoteManager.listAll();
        System.out.println("Quotes size:"+quotes.size());
        System.out.println("First quote: "+quotes.get(0));
    }
    @Test
    @Ignore
    public void getQuoteById() {
        Long id = 15L;
        Quote quote = null;
        try {
            quote = quoteManager.get(id);
            System.out.println(quote == null ? "1. Quote with id = "+id+" bot found." : "Quote: "+quote);
            if (quote.getQuoteValues() != null && !quote.getQuoteValues().isEmpty()) {
                System.out.println("First quote value is: "+quote.getQuoteValues().get(0));
            }
            assertNotNull(quote);
        } catch (Exception e) {
            fail("2. Quote with id = "+id+" bot found. \r\nException: "+e.getMessage());

        }

    }

    @Test
    @Ignore
    public void listAllQouteValue () {
        List<QuoteValue> quoteValues = quoteValueManager.listAll();
        System.out.println("Quotes values size:"+quoteValues.size());
        System.out.println("First quote value: "+quoteValues.get(0));
    }

    @Test
    public void getQuoteValue() {
        QuoteValue quoteValue = quoteValueManager.get(92L);
        System.out.println(quoteValue);
        try {
            quoteValue = quoteValueManager.get(-1L);
        } catch (Exception e) {
            quoteValue = new QuoteValue();
            System.out.println("############## new quote value");
        }
        System.out.println(quoteValue);

    }
}