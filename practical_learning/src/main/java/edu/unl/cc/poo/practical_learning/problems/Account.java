
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.poo.practical_learning.problems;

/**
 *
 * @author henry
 */
public class Account {
    private String name;
    private float balance;
    private String numberAccount;

    public Account(String name, String numberAccount) {
        this.name = name;
        this.balance = 0.0f;
        this.numberAccount = numberAccount;
    }
    
    public float deposit(float balance){
        return this.balance+=balance;
    }
    
    public void withdraw(float balance){
        validate(balance);
        this.balance-=balance;
    }
    
    private void validate(float balance){
        if(this.balance-balance<0){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }
    
}
