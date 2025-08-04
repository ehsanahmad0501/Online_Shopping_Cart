package online_shopping_cart;

import java.util.*;

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        ArrayList<ProductBean> products = new ArrayList<>();
        products.add(new ProductBean(1, "Laptop", 45000.0, 5));
        products.add(new ProductBean(2, "Mobile", 18000.0, 3));
        products.add(new ProductBean(3, "Headphones", 1500.0, 10));

        while (true) {
            System.out.println("\n---- Shopping Menu ----");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Undo Last Addition");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (ProductBean p : products) {
                        System.out.println(p.getId() + ". " + p.getName() +
                            " ₹" + p.getPrice() + " [" + p.getQuantity() + " left]");
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to add: ");
                    int id = sc.nextInt();
                    boolean found = false;

                    for (ProductBean p : products) {
                        if (p.getId() == id) {
                            found = true;
                            try {
                                if (p.getQuantity() <= 0)
                                    throw new OutOfStockException("Product is out of stock.");

                                p.setQuantity(p.getQuantity() - 1);
                                cart.addProduct(p);
                            } catch (OutOfStockException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid product ID.");
                    }
                    break;

                case 3:
                    cart.undoLastAddition();
                    break;

                case 4:
                    cart.viewCart();
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    System.exit(0);
            }
        }
    }
}

