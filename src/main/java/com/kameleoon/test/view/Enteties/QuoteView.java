package com.kameleoon.test.view.Enteties;

import com.kameleoon.test.model.dto.Quote;

public class QuoteView {
    private Quote quote;
    private boolean isVisibleQuoteVaues;
    public QuoteView () {
        quote = new Quote();
        isVisibleQuoteVaues = false;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public boolean isVisibleQuoteVaues() {
        return isVisibleQuoteVaues;
    }

    public void setVisibleQuoteVaues(boolean visibleQuoteVaues) {
        isVisibleQuoteVaues = visibleQuoteVaues;
    }
}
