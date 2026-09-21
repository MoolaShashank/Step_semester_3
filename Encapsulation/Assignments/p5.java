public class Cart {
    private final String cartId;
    private int[] prices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new int[maxItems];
        this.itemCount = 0;
    }

    public void addItem(int price) {
        if (itemCount < prices.length && price > 0) { 
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}
