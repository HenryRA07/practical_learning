
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.poo.practical_learning.problems;


import java.util.ArrayList;

/**
 *
 * @author henry
 */
public class Account {
    private String name;
    private float balance;
    private String numberAccount;
    private ArrayList<String> movimiento = new ArrayList<>();

    public Account(String name, String numberAccount) {
        this.name = name;
        this.balance = 0.0f;
        this.numberAccount = numberAccount;
    }
    
    public void deposit(float balance){
        validateNegativa(balance);
        movimiento.add(("Deposito de: "+balance));
        this.balance+=balance;
    }
    
    public void withdraw(float balance){
        validateNegativa(balance);
        validateWithdraw(balance);
        movimiento.add(("Retiro de: "+balance));
        this.balance-=balance;
    }
    
    private void validateWithdraw(float balance){
        if (this.balance-balance<0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }
    
    private void validateNegativa(float balance){
        if(balance<0){
            throw new IllegalArgumentException("No ingrese numeros negativos");
        }
    }
    
    public void presentDat(){
        System.out.println("Representate "+this.name+" correspondiente al numero de cuenta: "+this.numberAccount);
        System.out.println("Saldo actual: "+this.balance);
        movimiento.forEach(movimiento->System.out.println(movimiento));
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
