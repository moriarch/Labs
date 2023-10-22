package ru.servlet;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {

    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать карту");
            System.out.println("2. Получить баланс карты");
            System.out.println("3. Зачислить баланс");
            System.out.println(" ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.println(" ");
                        Registry registry = LocateRegistry.getRegistry(2732);
                        Card cardHandle = (Card) registry.lookup(UNIQUE_BINDING_NAME);
                        CardItem response = cardHandle.createCard();
                        System.out.println("Number: " + response.getNumber());
                        System.out.println("Balance: " + response.getBalance());

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Номер карты: ");
                    int number = scanner.nextInt();
                    try {
                        System.out.println(" ");
                        System.out.println("Результаты");
                        Registry registry = LocateRegistry.getRegistry(2732);
                        Card cardHandle = (Card) registry.lookup(UNIQUE_BINDING_NAME);
                        CardItem response = cardHandle.getCard(number);
                        System.out.println("Number: " + response.getNumber());
                        System.out.println("Balance: " + response.getBalance());
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("Номер карты: ");
                    int cardNumber = scanner.nextInt();
                    System.out.println("Пополнить на: ");
                    int newBalance = scanner.nextInt();

                    try {
                        System.out.println(" ");
                        System.out.println("Результаты");
                        Registry registry = LocateRegistry.getRegistry(2732);
                        Card cardHandle = (Card) registry.lookup(UNIQUE_BINDING_NAME);
                        CardItem response = cardHandle.pushBalance(cardNumber,newBalance);
                        System.out.println("Number: " + response.getNumber());
                        System.out.println("Balance: " + response.getBalance());
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }
}