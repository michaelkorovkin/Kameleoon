package com.kameleoon.test.model;

import com.kameleoon.test.model.dto.QuoteValue;
import com.kameleoon.test.model.repos.QuoteValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class QuoteValueManager {
    @Autowired
    QuoteValueRepository quoteValueRepository;

    /**
     * Извлкчь все записи пользователей
     * @return список пользователей
     */
    public List<QuoteValue> listAll() {
        List<QuoteValue> result;
        result = (List<QuoteValue>)quoteValueRepository.findAll();
        int size = result.size();
        return result;
    }

    /**
     * Извлечь запись пользователя по его идентификатору
     * @param id - идентификатор пользователя
     * @return - пользователь с указанным идентификатором
     */
    public QuoteValue get (Long id) {
        return quoteValueRepository.findById(id).get();
    }

    /**
     * Сохранить информацию о пользователе в БД
     * @param user - пользователь, который будет сохранен в БД
     */
    public void save (QuoteValue user) {
        quoteValueRepository.save(user);
    }

    /**
     * Удалить из БД информацию о квоте с указанным идентификатором
     * @param id - идентификатор квоты
     */
    public void delete (Long id) {
/*        deleteQuoteValuesByQuote(id);*/
        quoteValueRepository.deleteById(id);
    }

    /**
     * Существет значение квоты по ее идентификатору?
     * @param id
     * @return
     */
    public boolean exists (Long id) {
        return quoteValueRepository.existsById(id);
    }
    /**
     * Удалить все значения квоты по идентификатору квоты
     * @param quoteId
     */

    public void deleteQuoteValuesByQuote (Long quoteId) {
        List<QuoteValue> quoteValues = quoteValueRepository.selectQuoteViewByQueryId(quoteId);
        quoteValueRepository.deleteAll(quoteValues);
    }
}
