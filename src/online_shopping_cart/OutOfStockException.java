package online_shopping_cart;

public class OutOfStockException extends Exception 
{
    public OutOfStockException(String message) 
    {
        super(message);
    }
}

