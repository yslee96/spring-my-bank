package com.example.mybank.base;

import com.example.mybank.MyAccount;

public interface BaseBank{
    String setUserAccount(BaseAccount userAccount);
    Boolean hasAccount(String name);
    Boolean printAccountInfo(String name);
    Boolean deposit(String name, int money);
    Boolean withdraw(String name, int money);
    Boolean remit(String sender, int money, BaseBank receiveBank, String receiver);
}
