package online_shopping_cart;

import java.util.Stack;

public class Cart 
{
    Stack<ProductBean> cartStack = new Stack<>();

    public void addProduct(ProductBean product) 
    {
        cartStack.push(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void undoLastAddition()
    {
        if (!cartStack.isEmpty()) 
        {
            ProductBean removed = cartStack.pop();
            System.out.println("Removed last item: " + removed.getName());
        } else {
            System.out.println("Cart is empty, nothing to undo.");
        }
    }

    public void viewCart() 
    {
        if (cartStack.isEmpty()) 
        {
            System.out.println("Cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("Cart items:");
        for (ProductBean p : cartStack)
        {
            System.out.println("- " + p.getName() + " ₹" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: ₹" + total);
        
    }
}
