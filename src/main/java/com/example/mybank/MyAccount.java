package com.example.mybank;

import com.example.mybank.base.BaseAccount;

public class MyAccount implements BaseAccount {
    private int balance;
    private String userName;
    private String branch;
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
        System.out.printf("--- ACCOUNT INFO ---\n");
        System.out.printf("user:    %s\n",this.userName);
        System.out.printf("balance: %d\n",this.balance);
        System.out.printf("branch:  %s\n",this.branch);
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
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){ return this.userName; }
    public void setBranch(String branch){ this.branch = branch; }
    public String getBranch(){ return this.branch; }
}
