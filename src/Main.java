import java.util.Scanner;

public class Main {

    public static Product[] products = {new Product("Хлеб", 50, true), new Product("Пачка гречки", 135, false),
            new Product("Упаковка яиц", 65, false), new Product("Мороженка", 53, true)};
    public static int MIN_COST_FOR_BONUS = 1000;

    // В стоимости этих товаров каждые три товара должны стоить как два:

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин!");
        System.out.println("Наш ассортимент:");
        for (int i = 0; i < products.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + products[i].getTitleOfProduct() + " за " + products[i].getPriceOfProduct() + " за шт. ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите номер товара и количество через пробел или end: ");
            String line = scanner.nextLine();

            if ("end".equals(line)) {
                break;
            }

            String[] parts = line.split(" ");
            int productNum = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);

            products[productNum].addCountOfProducts(productCount);
        }

        System.out.println("Ваша корзина покупок:");
        int sum = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i].isOnSale()) {
                sum += products[i].getPriceOfProduct() * ((products[i].getCountOfProducts() / 3) * 2);
            } else {
                sum += products[i].getPriceOfProduct() * products[i].getCountOfProducts();
            }
        }

        boolean doBonus = sum >= MIN_COST_FOR_BONUS;
        sum = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i].getCountOfProducts() != 0) {

                int countOfProductsForSaleing = doBonus ? products[i].getCountOfProducts() / 3 * 2 + 1 : products[i].getCountOfProducts() / 3 * 2;
                int countOfProductsForNotSaleing = doBonus ? products[i].getCountOfProducts() + 1 : products[i].getCountOfProducts();

                if (products[i].getCountOfProducts() / 3 * 2 == 0) {
                    countOfProductsForSaleing = 1;
                }

                if (products[i].isOnSale()) {
                    System.out.println("\t" + products[i].getTitleOfProduct() + " " + countOfProductsForSaleing + " шт. за " + products[i].getPriceOfProduct() + " руб. за шт. (распродажа!)");
                    if (countOfProductsForSaleing == 1) {
                        sum += products[i].getPriceOfProduct();
                    } else {
                        sum += countOfProductsForSaleing * products[i].getPriceOfProduct();
                    }
                } else {
                    System.out.println("\t" + products[i].getTitleOfProduct() + " " + countOfProductsForNotSaleing + " шт. за " + products[i].getPriceOfProduct() + " руб. за шт.");
                    sum += countOfProductsForNotSaleing * products[i].getPriceOfProduct();
                }
            }
        }
        System.out.println("Итого: " + sum + " руб.");
    }
}