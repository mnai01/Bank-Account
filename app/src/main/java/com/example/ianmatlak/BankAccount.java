package com.example.ianmatlak;

public class BankAccount {
    private String m_Name;
    private Double m_Balance;

    BankAccount(){
        m_Name = "test";
        m_Balance = 100.00;
    }

    BankAccount(String Name, Double Balance){
        m_Name = Name;
        m_Balance = Balance;
    }

    @Override
    public String toString() {
        return m_Name;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public Double getM_Balance() {
        return m_Balance;
    }

    public void setM_Balance(Double m_Balance) {
        this.m_Balance = m_Balance;
    }

}