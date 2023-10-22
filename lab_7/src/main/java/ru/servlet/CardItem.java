package ru.servlet;

import java.io.Serializable;

public class CardItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private int number;
    private int balance;

    private int id;


    public CardItem(){ }


    public CardItem( int number, int balance){
        this.balance = balance;
        this.number = number;
    }
    public CardItem(int id, int number, int balance){

        this.id = id;
        this.balance = balance;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
    public int getBalance() {
        return balance;
    }

    public void setCard(int number) {
        this.number = number;
        this.balance = 0;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}