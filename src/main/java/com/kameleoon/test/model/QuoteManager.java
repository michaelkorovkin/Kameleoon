package com.kameleoon.test.model;

import com.kameleoon.test.model.dto.Quote;
import com.kameleoon.test.model.repos.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class QuoteManager {
    @Autowired
    QuoteRepository quoteRepository;
    /**
     * Извлкчь все записи пользователей
     * @return список пользователей
     */
    public List<Quote> listAll() {
        List<Quote> result;
        result = (List<Quote>)quoteRepository.findAll();
        int size = result.size();
        return result;
    }
    /**
     * Извлечь запись квоты по её идентификатору
     * @param id - идентификатор квоты
     * @return - квота с указанным идентификатором
     */
    public Quote get (Long id) {
        return quoteRepository.findById(id).get();
    }

    /**
     * Сохранить информацию о пользователе в БД
     * @param quote - квота, которая будет сохранена в БД
     */
    public void save (Quote quote) {
        quoteRepository.save(quote);
    }

    /**
     * Удалить из БД информацию о пользователе с указанным идентификатором
     * @param id - идентификатор пользвателя
     */
    public void delete (Long id) {
        quoteRepository.deleteById(id);
    }


    public boolean exists (Long quoteId) {
        return quoteRepository.existsById(quoteId);
    }


}
