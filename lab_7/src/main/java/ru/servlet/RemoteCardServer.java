package ru.servlet;
import java.rmi.RemoteException;

public class RemoteCardServer implements Card {

    @Override
    public CardItem createCard() throws RemoteException {
        return DB.createCard();
    }

}