package ru.servlet;
import java.rmi.RemoteException;

public class RemoteCardServer implements Card {

    @Override
    public CardItem createCard() throws RemoteException {
        int minValue = 100;
        int maxValue = 1000000;
        int randomValue = minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
        return DB.createCard(randomValue,0);
    }
    @Override
    public CardItem getCard(int number) throws RemoteException {
        return DB.getCard(number);
    }
    @Override
    public CardItem pushBalance(int number, int balance) throws RemoteException {
        return DB.pushBalance(number, balance);
    }

}