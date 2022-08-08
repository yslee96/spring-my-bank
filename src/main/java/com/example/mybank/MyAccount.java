package com.example.mybank;

import com.example.mybank.base.BaseAccount;

public class MyAccount implements BaseAccount {
    private int balance;
    private String userName;
    public MyAccount(){
        this.balance = 0;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void printInfo() {
        System.out.println("--- ACCOUNT INFO ---");
        System.out.println("user: "+ userName + " " + "current balance: " + balance);
    }

    @Override
    public void addBalance(int money) {
        this.balance += money;
    }

    @Override
    public Boolean subBalance(int money) {
        if(this.balance < money) {
            System.out.println("The balance is not sufficient");
            return Boolean.FALSE;
        }
        this.balance -= money;
        return Boolean.TRUE;
    }

}
