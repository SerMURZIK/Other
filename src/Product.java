public class Product {
    private String titleOfProduct;
    private int priceOfProduct;
    private boolean isOnSale;
    private int countOfProducts;

    public Product(String titleOfProduct, int priceOfProduct, boolean isOnSale) {
        this.titleOfProduct = titleOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.isOnSale = isOnSale;
    }

    public String getTitleOfProduct() {
        return titleOfProduct;
    }

    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    public int getCountOfProducts() {
        return countOfProducts;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void addCountOfProducts(int countOfProducts) {
        this.countOfProducts += countOfProducts;
    }
}
