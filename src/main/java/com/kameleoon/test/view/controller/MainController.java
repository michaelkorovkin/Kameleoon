package com.kameleoon.test.view.controller;

import com.kameleoon.test.model.CurrentUserManager;
import com.kameleoon.test.model.QuoteManager;
import com.kameleoon.test.model.QuoteValueManager;
import com.kameleoon.test.model.UserManager;
import com.kameleoon.test.model.dto.Quote;
import com.kameleoon.test.model.dto.QuoteValue;
import com.kameleoon.test.model.dto.User;
import com.kameleoon.test.view.Enteties.QuoteView;
import com.kameleoon.test.view.manager.QuoteViewManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Random;

@Controller
public class MainController {
    @Autowired
    private UserManager userManager;

    @Autowired
    private QuoteManager quoteManager;
    @Autowired
    private QuoteValueManager quoteValueManager;
    private User currentUser;
    /**
     * Подготовка и отображение страницы со списком квот
     * @param quoteId - квота, у которой надо показать/скрыть список значений
     * @param valesVisible - показать -true, скрыть значения квоты
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home (@RequestParam(value = "quoteId", required = false) Integer quoteId, @RequestParam(value = "valVisible", required = false) String valesVisible) {
        Boolean visible = null;
        List<User> users = userManager.listAll();
        CurrentUserManager currentUserManager = CurrentUserManager.initCurrentUserManager();
        currentUserManager.setCurrentUser(users.get(new Random().nextInt(users.size())));
        currentUser = currentUserManager.getCurrentUser();
        if (quoteId != null) {
            visible = false;
            if (valesVisible != null) {
                visible = (Boolean) valesVisible.equalsIgnoreCase("true");
            }
        }
        ModelAndView result = new ModelAndView("index");
        List<Quote> quotes = quoteManager.listAll();
        QuoteViewManager quoteViewManager = QuoteViewManager.initQuoteViewManager();
        quoteViewManager.fillQuoteViews(quotes);

        if (quoteId != null) {
            for (QuoteView quoteView : quoteViewManager.getQuoteViews()) {
                if (quoteView.getQuote().getId() == quoteId) {
                    quoteView.setVisibleQuoteVaues(visible);
                }
            }
        }
/*        Random rnd = new Random();        */
        refreshQoutesList(result);
/*        result.addObject("randomQuoteView", quoteViewManager.getQuoteViews().get(rnd.nextInt(quoteViewManager.getQuoteViews().size()-1)));
        result.addObject("listQuoteViews", quoteViewManager.getQuoteViews());*/
        return result;
    }


    @RequestMapping(value = "/quotevalusave", method = RequestMethod.GET)
    public ModelAndView quoteValueSave(@RequestParam(value = "quoteid") Long quoteId, @RequestParam(value = "quotevalueid") Long quoteValueId, @RequestParam(value = "quotevalue") Float quoteValue) {
        QuoteValue changeQuoteValue;
        if (quoteValueManager.exists(quoteValueId)) {
            changeQuoteValue = quoteValueManager.get(quoteValueId);
        } else {
            changeQuoteValue = new QuoteValue();
            changeQuoteValue.setId(-1L);
            Quote qoute = quoteManager.get(quoteId);
            changeQuoteValue.setQuote(qoute);
            changeQuoteValue.setValue(quoteValue);
        }
        changeQuoteValue.setValueDate(OffsetDateTime.now());
        ModelAndView result = new ModelAndView("quotevalue");
        result.addObject("quoteValue",changeQuoteValue);

        return result;
    }
    @RequestMapping(value = "/quotevaluesavesubmit", method = RequestMethod.POST)
    public ModelAndView quoteValueSaveSubmit(@RequestParam(value = "quotevalueid") Long quoteValueId, @RequestParam(value = "quoteid") Long quteId,@RequestParam(value = "quotevalue")Float value) {
        QuoteViewManager quoteViewManager = QuoteViewManager.initQuoteViewManager();
        QuoteValue quoteValue;
        Quote quote;
        if (quoteValueManager.exists(quoteValueId)) {
            quoteValue = quoteValueManager.get(quoteValueId);
            quoteValue.setValue(value);
        } else {
            quoteValue = new QuoteValue();
            quoteValue.setId(-1L);
            quoteValue.setValue(value);
            quote = quoteManager.get(quteId);
            quoteValue.setQuote(quote);
            quoteValue.setValueDate(OffsetDateTime.now());
        }
        quoteValueManager.save(quoteValue);
        ModelAndView modelAndView = new ModelAndView("index");
        refreshQoutesList(modelAndView);
/*        List<Quote> quotes = quoteManager.listAll();
        quoteViewManager.fillQuoteViews(quotes);
        modelAndView.addObject("randomQuoteView", quoteViewManager.getQuoteViews().get(new Random().nextInt(quoteViewManager.getQuoteViews().size()-1)));
        modelAndView.addObject("listQuoteViews", quoteViewManager.getQuoteViews());*/
        return modelAndView;
    }

    @RequestMapping(value = "/deletequotevalue")
    public ModelAndView deleteQuoteValue (@RequestParam(value = "quotevalueid") Long quoteValueId) {
        ModelAndView modelAndView = new ModelAndView("index");
        QuoteViewManager quoteViewManager = QuoteViewManager.initQuoteViewManager();
        if (quoteValueManager.exists(quoteValueId)) {
            quoteValueManager.delete(quoteValueId);
        }
        refreshQoutesList(modelAndView);
/*        List<Quote> quotes = quoteManager.listAll();
        quoteViewManager.fillQuoteViews(quotes);
        modelAndView.addObject("randomQuoteView", quoteViewManager.getQuoteViews().get(new Random().nextInt(quoteViewManager.getQuoteViews().size()-1)));
        modelAndView.addObject("listQuoteViews", quoteViewManager.getQuoteViews());*/
        return modelAndView;
    }
    @RequestMapping(value = "/quotesave", method = RequestMethod.GET)
    public ModelAndView quoteSave(@RequestParam(value = "quoteid") Long quoteId, @RequestParam(value = "quotename") String quoteName, @RequestParam(value="quotecomm") String quoteComm) {
        Quote changeQuote;
        if (quoteManager.exists(quoteId)) {
            changeQuote = quoteManager.get(quoteId);
            changeQuote.setChangeDate(OffsetDateTime.now());
            changeQuote.setChangeUser(userManager.get(currentUser.getId()));
            changeQuote.setName(quoteName);
            changeQuote.setComment(quoteComm);
        } else {
            changeQuote = new Quote();
            changeQuote.setId(-1L);
            changeQuote.setCreateDate(OffsetDateTime.now());
            changeQuote.setCreateUser(userManager.get(currentUser.getId()));
            changeQuote.setName("Name");
            changeQuote.setComment("Comment");
        }

        ModelAndView result = new ModelAndView("quotesave");
        result.addObject("quote", changeQuote);

        return result;
    }
    @RequestMapping(value = "/quotesavesubmit", method = RequestMethod.POST)
    public ModelAndView quoteSaveSubmit(@RequestParam(value = "quoteid") Long quoteId, @RequestParam(value = "quotename") String quoteName, @RequestParam(value="quotecomm") String quoteComm) {
        QuoteViewManager quoteViewManager = QuoteViewManager.initQuoteViewManager();
        Quote changeQuote;
        Quote quote;
        if (quoteManager.exists(quoteId)){
            changeQuote = quoteManager.get(quoteId);
            changeQuote.setChangeDate(OffsetDateTime.now());
            changeQuote.setChangeUser(userManager.get(currentUser.getId()));
        } else {
            changeQuote = new Quote();
            changeQuote.setId(-1L);
            changeQuote.setCreateDate(OffsetDateTime.now());
            changeQuote.setCreateUser(userManager.get(currentUser.getId()));
        }
        if (quoteName.length() > 14) {
            changeQuote.setName(quoteName.substring(0,15));
        } else {
            changeQuote.setName(quoteName);
        }
        changeQuote.setComment(quoteComm);
        quoteManager.save(changeQuote);
        ModelAndView modelAndView = new ModelAndView("index");
        refreshQoutesList(modelAndView);
/*        List<Quote> quotes = quoteManager.listAll();
        quoteViewManager.fillQuoteViews(quotes);
        modelAndView.addObject("randomQuoteView", quoteViewManager.getQuoteViews().get(new Random().nextInt(quoteViewManager.getQuoteViews().size()-1)));
        modelAndView.addObject("listQuoteViews", quoteViewManager.getQuoteViews());*/
        return modelAndView;
    }

    @RequestMapping(value = "/deletequote")
    public ModelAndView deleteQuote (@RequestParam(value = "quoteid") Long quoteId) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (quoteManager.exists(quoteId)) {
            quoteValueManager.deleteQuoteValuesByQuote(quoteId);
            quoteManager.delete(quoteId);
        }
        List<Quote> quotes = quoteManager.listAll();
        QuoteViewManager quoteViewManager = QuoteViewManager.initQuoteViewManager();
        refreshQoutesList(modelAndView);
/*        quoteViewManager.fillQuoteViews(quotes);
        modelAndView.addObject("randomQuoteView", quoteViewManager.getQuoteViews().get(new Random().nextInt(quoteViewManager.getQuoteViews().size()-1)));
        modelAndView.addObject("listQuoteViews", quoteViewManager.getQuoteViews());*/
        refreshQoutesList(modelAndView);
        return modelAndView;
    }

    private void setVisibleQuoteValues (Long qouteId, boolean visible) {

    }
    @RequestMapping(value = "/adduser")
    private ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView("adduser");
        return modelAndView;
    }
    @RequestMapping (value = "/confirmuser", method = RequestMethod.POST)
    public ModelAndView confirmUser (@RequestParam(value = "username") String userName, @RequestParam(value = "comment") String comment,
                                     @RequestParam(value = "password") String userPassword,
                                     @RequestParam(value = "configpassword") String confirmPassword) {
        if (userPassword.equalsIgnoreCase(confirmPassword)) {
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setComment(comment);
            user.setCreateDate(OffsetDateTime.now());
            userManager.save(user);
        }
        ModelAndView modelAndView = new ModelAndView("index");

        refreshQoutesList(modelAndView);
        return modelAndView;

    }

    private void refreshQoutesList(ModelAndView modelAndView) {
        QuoteViewManager quoteViewManager = QuoteViewManager.initQuoteViewManager();
        List<Quote> quotes = quoteManager.listAll();
        modelAndView.addObject("randomQuoteView", quoteViewManager.getQuoteViews().get(new Random().nextInt(quoteViewManager.getQuoteViews().size()-1)));
        modelAndView.addObject("listQuoteViews", quoteViewManager.getQuoteViews());
        quoteViewManager.fillQuoteViews(quotes);

    }

}
