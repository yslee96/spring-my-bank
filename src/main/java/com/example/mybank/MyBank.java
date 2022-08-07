package com.example.mybank;

import com.example.mybank.base.BaseAccount;
import com.example.mybank.base.BaseBank;

import java.util.HashMap;
import java.util.Map;
public class MyBank implements BaseBank{
    Map<String, BaseAccount> accountMap;
    private Integer accountNum;
    public MyBank(){
        this.accountMap = new HashMap<>();
        this.accountNum = 0;
    }
    private String getAccountNum(){
        String accountNum = this.accountNum.toString();
        this.accountNum += 1;
        return accountNum;
    }

    @Override
    public String setUserAccount(BaseAccount userAccount) {
        String accountNum = this.getAccountNum();
        this.accountMap.put(accountNum, userAccount);
        return accountNum;
    }

    @Override
    public Boolean hasAccount(String name){
        return this.accountMap.containsKey(name);
    }
    @Override
    public Boolean printAccountInfo(String name){
        if(!this.hasAccount(name))
            return Boolean.FALSE;
        this.accountMap.get(name).printInfo();
        return Boolean.TRUE;
    }
    @Override
    public Boolean deposit(String name, int money){
        if(!this.hasAccount(name))
            return Boolean.FALSE;
        this.accountMap.get(name).addBalance(money);
        return Boolean.TRUE;
    }
    @Override
    public Boolean withdraw(String name, int money){
        if(!this.hasAccount(name))
            return Boolean.FALSE;
        return this.accountMap.get(name).subBalance(money);
    }
    @Override
    public Boolean remit(String sender, int money, BaseBank receiveBank, String receiver){
        if(this.hasAccount(sender) && this.withdraw(sender, money)){
            if(receiveBank.deposit(receiver, money)) {
                return Boolean.TRUE;
            }
            System.out.println("Invalid Transmission : Receiving Failure");
            this.deposit(sender, money);
            return Boolean.FALSE;
        }
        System.out.println("Invalid Transmission : Sending Failure");
        return Boolean.FALSE;
    }


}
