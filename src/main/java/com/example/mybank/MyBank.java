package com.example.mybank;

import com.example.mybank.base.BaseAccount;
import com.example.mybank.base.BaseBank;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyBank implements BaseBank<Map<String, MyAccount>>{

    private Map<String, MyAccount> userAccounts = null;
    private Set<String> branches = new HashSet<>();

    public void setBranches(Set<String> branches) { this.branches = branches; }

    public void printBranchInfo(){
        System.out.printf("--- BRANCH INFO ---\n");
        if(this.branches ==null){
            System.out.printf("No Branch Exists\n");
        }
        else {
            for (String branch : branches) {
                System.out.printf("%s\n", branch);
            }
        }
    }
    public boolean hasBranch(String branchName){ return this.branches.contains(branchName); }
    @Override
    public void setUserAccount(Map<String, MyAccount> userAccounts) {
        for(MyAccount account : userAccounts.values()){
            branches.add(account.getBranch());
        }
        this.userAccounts = userAccounts;
    }
    @Override
    public Boolean hasAccount(String name){
        return this.userAccounts.containsKey(name);
    }
    @Override
    public Boolean printAccountInfo(String name){
        if(!this.hasAccount(name))
            return false;
        this.userAccounts.get(name).printInfo();
        return true;
    }
    @Override
    public Boolean deposit(String name, int money){
        if(!this.hasAccount(name))
            return false;
        this.userAccounts.get(name).addBalance(money);
        return true;
    }
    @Override
    public Boolean withdraw(String name, int money){
        if(!this.hasAccount(name))
            return false;
        return this.userAccounts.get(name).subBalance(money);
    }
    @Override
    public Boolean remit(String sender, int money, BaseBank receiveBank, String receiver){
        if(this.hasAccount(sender) && this.withdraw(sender, money)){
            if(receiveBank.deposit(receiver, money)) {
                System.out.println("Transmission Success");
                return true;
            }
            System.out.println("Invalid Transmission : Receiving Failure");
            this.deposit(sender, money);
            return false;
        }
        System.out.println("Invalid Transmission : Sending Failure");
        return false;
    }
}
