package myproject;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("admin", "1234");
        Cart cart = new Cart();

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1,"Laptop",55000,"Electronics"));
        products.add(new Product(2,"Smart Watch",2500,"Electronics"));
        products.add(new Product(3,"T-Shirt",799,"Fashion"));
        products.add(new Product(4,"Shoes",1999,"Fashion"));
        products.add(new Product(5,"Cake",650,"Home Bakery"));
        products.add(new Product(6,"Mixer",3200,"Household"));

        System.out.println("===== GLOBAL QUEST E-COMMERCE =====");

        System.out.print("Username: ");
        String u = sc.next();

        System.out.print("Password: ");
        String p = sc.next();

        if(!user.login(u,p)) {
            System.out.println("Invalid Login");
            return;
        }

        System.out.println("Login Successful!");

        while(true){

            System.out.println("\n1.View Products");
            System.out.println("2.Add to Cart");
            System.out.println("3.View Cart");
            System.out.println("4.Place Order");
            System.out.println("5.Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    System.out.println("\nAvailable Products");
                    for(Product pr : products)
                        System.out.println(pr);
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    boolean found = false;

                    for(Product pr : products){
                        if(pr.getId()==id){
                            cart.addProduct(pr);
                            found = true;
                        }
                    }

                    if(!found)
                        System.out.println("Product not found.");
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    Order.placeOrder(cart);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}