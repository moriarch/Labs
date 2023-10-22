package ru.servlet;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Card extends Remote {

    CardItem createCard() throws RemoteException;
    CardItem getCard(int number) throws  RemoteException;
    CardItem pushBalance(int number, int balance) throws  RemoteException;

}