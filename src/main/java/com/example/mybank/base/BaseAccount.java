package com.example.mybank.base;

public interface BaseAccount {
    void setBalance(int balance);
    int getBalance();
    void printInfo();
    void addBalance(int money);
    Boolean subBalance(int money);
}
