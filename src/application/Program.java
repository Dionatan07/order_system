package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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

        System.out.println();
        System.out.print("How many items to this order? ");
        int n = key.nextInt();

        for (int i = 1; i <= n;i++){
            key.nextLine();
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = key.nextLine();
            System.out.print("Product price: ");
            double productPrice = key.nextDouble();

            Product product= new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantity = key.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
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
