package com.kameleoon.test.model;

import com.kameleoon.test.model.dto.User;
import com.kameleoon.test.model.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserManager {
    @Autowired
    UserRepository userRepo;

    public UserManager () {

    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Извлкчь все записи пользователей
     * @return список пользователей
     */
    public List<User> listAll() {
        List<User> result;
        result = (List<User>)userRepo.findAll();
        return result;
    }



    /**
     * Извлечь запись пользователя по его идентификатору
     * @param id - идентификатор пользователя
     * @return - пользователь с указанным идентификатором
     */
    public User get (Long id) {
        return userRepo.findById(id).get();
    }

    /**
     * Сохранить информацию о пользователе в БД
     * @param user - пользователь, который будет сохранен в БД
     */
    public void save (User user) {
        if (userRepo.existsById(user.getId())){
            User existUser = userRepo.findById(user.getId()).get();
            existUser.setCreateDate(user.getCreateDate());
            existUser.setComment(user.getComment());
            existUser.setUserPassword(user.getUserPassword());
            existUser.setUserName(user.getUserName());
            existUser.setChangeDate(user.getChangeDate());
            userRepo.save(existUser);
        } else {
            userRepo.save(user);
        }

    }

    /**
     * Удалить из БД информацию о пользователе с указанным идентификатором
     * @param id - идентификатор пользвателя
     */
    public void delete (Long id) {
        userRepo.deleteById(id);
    }
}
