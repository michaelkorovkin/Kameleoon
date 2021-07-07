package com.kameleoon.test.view.manager;

import com.kameleoon.test.model.QuoteValueManager;
import com.kameleoon.test.model.dto.Quote;
import com.kameleoon.test.view.Enteties.QuoteView;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteViewManager {
    private List<QuoteView> quoteViews;
    private static QuoteViewManager quoteViewManager = null;
/*    @Autowired*/
    private QuoteValueManager quoteValueManager;

    private  QuoteViewManager () {

    }

    public static QuoteViewManager initQuoteViewManager () {

        if (quoteViewManager == null) {
            quoteViewManager = new QuoteViewManager();
        }
        return quoteViewManager;
    }

    public List<QuoteView> getQuoteViews() {
        return quoteViews;
    }


    public void setQuoteViews(List<QuoteView> quoteViews) {
        quoteViews = quoteViews;
    }
    public void fillQuoteViews (List<Quote> quotes) {
        if (quotes != null && !quotes.isEmpty()) {
            quoteViews = new ArrayList<>();
            for (Quote quote : quotes) {
                QuoteView quoteView = new QuoteView();
                quoteView.setVisibleQuoteVaues(false);
                quoteView.setQuote(quote);
                quoteViews.add(quoteView);
            }
        }
    }

    public void setQuoteViewVisibleByIndex (int index, boolean visible) {
        quoteViews.get(index).setVisibleQuoteVaues(visible);
    }
    public void setQuoteViewVisibleByQuoteId(long quoteId, boolean visible) {
        for (QuoteView quoteView : quoteViews) {
            if (quoteView.getQuote().getId() == quoteId) {
                quoteView.setVisibleQuoteVaues(visible);
            }
        }
    }
    public void deleteQuote (long quoteId) {
        if (quoteViews != null && !quoteViews.isEmpty()) {
            for (QuoteView quoteView : this.quoteViews) {
                if (quoteView.getQuote().getId() == quoteId) {
                    quoteViews.remove(quoteView);
                    return;
                }
            }
        }
    }

}
