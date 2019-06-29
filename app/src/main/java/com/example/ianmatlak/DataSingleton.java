package com.example.ianmatlak;

import java.util.ArrayList;

public final class DataSingleton {

    private static DataSingleton INSTANCE = null;

    private ArrayList<BankAccount> m_BankAccount = new ArrayList<BankAccount>();

    private DataSingleton() {
        m_BankAccount.add(new BankAccount("Checking", 1000.00));
        m_BankAccount.add(new BankAccount("Savings", 10000.00));

    }

    public ArrayList<BankAccount> getM_BankAccount() {   ///maybe do not need
        return m_BankAccount;
    }

    public void setM_BankAccount(ArrayList<BankAccount> m_BankAccount) {
        this.m_BankAccount = m_BankAccount;
    }

    public ArrayList<BankAccount> getBankAccountList() {
        return m_BankAccount;
    }

    private ArrayList<BankAccount> getBankAccountByName(String name) {
        for (int i = 0; i <= m_BankAccount.size(); i++) {
            if (m_BankAccount.equals(name)) {
                return m_BankAccount;
            } else {
                return null;
            }
        }
        return null;
    }

    public static DataSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSingleton();
        }
        return INSTANCE;
    }
}