package com.detail.api.detailapi.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.detail.api.detailapi.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserFileDAO implements UserDAO {
    Map<Integer,User> users;
    private ObjectMapper objectMapper;
    private static int nextId;
    private String filename;

    public UserFileDAO(@Value("${users.file}") String filename, ObjectMapper objectMapper) throws IOException {
        this.filename = filename;
        this.objectMapper = objectMapper;
        load();
    }

    private synchronized static int nextId() {
        int id = nextId;
        ++nextId;
        return id;
    }

    private User[] getUserArray() {
        return getUserArray(null);
    }

    private boolean save() throws IOException {
        User[] userArray = getUserArray();

        objectMapper.writeValue(new File(filename),userArray);
        return true;
    }

    private boolean load() throws IOException {
        this.users = new TreeMap<>();
        nextId = 0;

        User[] userArray = objectMapper.readValue(new File(filename),User[].class);

        for (User user : userArray) {
            users.put(user.getLoginID(),user);
            if (user.getLoginID() > nextId)
                nextId = user.getLoginID();
        }

        ++nextId;
        return true;
    }
    
    public User[] getUserArray(String containsText) {
        ArrayList<User> userArrayList = new ArrayList<>();

        for (User user : users.values()) {
            if (containsText == null || user.getUsername().contains(containsText)) {
                userArrayList.add(user);
            }
        }

        User[] userArray = new User[userArrayList.size()];
        userArrayList.toArray(userArray);
        return userArray;
    }

    @Override
    public User[] getUsers() throws IOException {
        synchronized(users) {
            return getUserArray();
        }
    }

    @Override
    public User[] findUser(String search) throws IOException {
        synchronized(users) {
            return getUserArray(search);
        }
    }

    @Override
    public User getUser(int loginID) throws IOException {
        synchronized(users){
            if(users.containsKey(loginID))
                return users.get(loginID);
            else   
                return null;
        }
    }

    @Override
    public User createUser(User user) throws IOException {
        synchronized(users){
            User newUser = new User(nextId(), user.getUsername(), user.isAdmin(), user.getCarsList());
            users.put(newUser.getLoginID(), newUser);
            save();
            return newUser;
        }
    }

    @Override
    public User updateUser(User user) throws IOException {
        synchronized(users) {
            if (!users.containsKey(user.getLoginID())) {
                return null;
            }
            users.put(user.getLoginID(), user);
            save();
            return user;
        }
    }

    @Override
    public boolean deleteUser(int loginID) throws IOException {
        synchronized(users){
            if(users.containsKey(loginID))
            {
                users.remove(loginID);
                return save();
            }
            else
                return false;
        }
    }
}
