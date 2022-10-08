package application;

import entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner key = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = key.nextLine();
        System.out.print("Email: ");
        String email = key.nextLine();
        System.out.print("Birth date (dd/MM/yyyy): ");
        Date birthDate = sdf.parse(key.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(key.next());

        Order order = new Order(new Date(), status, client);

        String path = "C:\\temp\\order.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] vect = line.split(";");
                String productName = vect[0];
                double productPrice = Double.parseDouble(vect[1]);

                Product product = new Product(productName, productPrice);

                int quantity = Integer.parseInt(vect[2]);

                OrderItem orderItem = new OrderItem(quantity, productPrice, product);

                order.addItem(orderItem);
                line = br.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + sdf2.format(order.getMoment()));
        System.out.println("Order status: " + order.getStatus());
        System.out.println(client);
        System.out.println("Order items: ");
        System.out.println(order);

    }
}
