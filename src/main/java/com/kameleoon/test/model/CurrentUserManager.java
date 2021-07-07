package com.kameleoon.test.model;

import com.kameleoon.test.model.dto.User;

public class CurrentUserManager {
    private User currentUser;
    private static CurrentUserManager currentUserManager = null;


    private CurrentUserManager () {


    }
    public static CurrentUserManager initCurrentUserManager () {
        if (currentUserManager == null) {
            currentUserManager = new CurrentUserManager();
        }

        return currentUserManager;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
