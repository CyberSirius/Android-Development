package com.mentormate.academy.registerandloginredo.engine;

import java.util.ArrayList;

/**
 * Created by Strashimir on 15.12.2014 г..
 */
public class DbManager {
    private static DbManager instance;
    private static int currentId;
    private User currentUser;
    private ArrayList<User> users;

    public DbManager() {
        currentUser = null;
        users = new ArrayList<User>();
        currentId = 0;
    }

    public static DbManager getInstance() {
        if (instance == null) {
            instance = new DbManager();
        }
        return instance;
    }

    public static int getCurrentId() {
        return ++currentId;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}