package com.detail.api.detailapi.persistence;

import java.io.IOException;

import com.detail.api.detailapi.model.User;

public interface UserDAO {
    User[] getUsers() throws IOException;

    User[] findUser(String search) throws IOException;

    User getUser(int loginID) throws IOException;

    User createUser(User user) throws IOException;

    User updateUser(User user) throws IOException;

    boolean deleteUser(int loginID) throws IOException;
}
