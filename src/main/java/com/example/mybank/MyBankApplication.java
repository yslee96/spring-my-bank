package com.example.mybank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.mybank.base.BaseBank;
import com.example.mybank.base.BaseAccount;
@SpringBootApplication
public class MyBankApplication {
    private static Logger logger = LogManager.getLogger(MyBankApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/applicationContext.xml");

        BaseBank bank1 = (BaseBank) context.getBean("bank1");
        BaseBank bank2 = (BaseBank) context.getBean("bank2");
        BaseAccount account1 = (BaseAccount) context.getBean("account1");
        BaseAccount account2 = (BaseAccount) context.getBean("account2");

        String account1Id = bank1.setUserAccount(account1);
        String account2Id = bank2.setUserAccount(account2);
        bank1.printAccountInfo(account1Id);
        bank2.printAccountInfo(account2Id);
        System.out.println();

        System.out.println("#1 Test For Deposit");
        System.out.println("Deposit 20000, 40000 respectively");
        bank1.deposit(account1Id, 20000);
        bank2.deposit(account2Id, 40000);
        bank1.printAccountInfo(account1Id);
        bank2.printAccountInfo(account2Id);
        System.out.println();

        System.out.println("#2 Test For Valid Withdrawal");
        System.out.println("Deposit 10000, 20000 respectively");
        bank1.withdraw(account1Id, 10000);
        bank2.withdraw(account2Id, 20000);
        bank1.printAccountInfo(account1Id);
        bank2.printAccountInfo(account2Id);
        System.out.println();

        System.out.println("#3 Test For Invalid Withdrawal");
        System.out.println("Withdraw 20000, 40000 respectively");
        bank1.withdraw(account1Id, 20000);
        bank2.withdraw(account2Id, 40000);
        System.out.println();
        bank1.printAccountInfo(account1Id);
        bank2.printAccountInfo(account2Id);
        System.out.println();

        System.out.println("#4 Test For Valid Transmission");
        System.out.println("Transmit 10000 from Wendy to Joy");
        bank2.remit(account2Id, 10000, bank1, account1Id);
        bank1.printAccountInfo(account1Id);
        bank2.printAccountInfo(account2Id);
        System.out.println();

        System.out.println("#5 Test For Invalid Transmission - send money to which not exist");
        System.out.println("Transmit 10000 from Joy to random account (ID: 2022)");
        bank1.remit(account1Id, 10000, bank1, "2022");
        bank1.printAccountInfo(account1Id);
        bank2.printAccountInfo(account2Id);
        System.out.println();

        System.out.println("#6 Test For Invalid Transmission - send money that exceeds sender's current balance");
        bank1.printAccountInfo(account1Id);
        System.out.println("Transmit 40000 from Joy to Wendy");
        bank1.remit(account1Id, 40000, bank2, account2Id);
        bank1.printAccountInfo(account1Id);
        bank2.printAccountInfo(account2Id);
        System.out.println();

        //SpringApplication.run(MyBankApplication.class, args);

    }

}
