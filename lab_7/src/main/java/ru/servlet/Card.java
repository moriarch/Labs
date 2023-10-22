package ru.servlet;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Card extends Remote {

    CardItem createCard(int number, int balance) throws RemoteException;


}