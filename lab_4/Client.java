import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
   private static final int SERVER_PORT = 8080;

   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      System.out.println("Введите адрес сервера (Если клиент рядом то enter)");
      String server = input.nextLine();

      if (server.length() == 0) {
         System.out.println("Запускаю локальный клиент localhost:8080");
         server = "localhost";
      }

      try {
         System.out.println("Подключение к " + server + " на порт " + SERVER_PORT);
         Socket client = new Socket(server, SERVER_PORT);
         System.out.println("Подключаемся к " + client.getRemoteSocketAddress());

         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         out.writeUTF("Привет из " + client.getLocalSocketAddress());

         InputStream inFromServer = client.getInputStream();
         BufferedReader in = new BufferedReader(new InputStreamReader(inFromServer));

         try {
            while (true) {
               System.out.println("Сервер прислал: " + in.readLine());
               if (in.readLine() == "500")
                  client.close();
            }
         } catch (IOException e) {

            e.printStackTrace();
         } finally {
            client.close();
         }

      } catch (IOException e) {
         System.out.println("Сервер не запущен или не найден");
         e.printStackTrace();
      }
   }
}

