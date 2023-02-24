package io.n0sense.myexam.service;

public interface UserService {
    boolean checkLogin(String username, String password);
    boolean register(String username, String password);
}
