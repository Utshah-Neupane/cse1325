package store;

public class Main {

    public static void main(String[] args) {
        // Create a customer
        Customer customer1 = new Customer("Prof Rice", "george.rice@uta.edu");
        Customer customer2 = new Customer("Ashley Green", "ash_933@gmail.com");
        Customer customer3 = new Customer("Richard Red Nguyen", "ricxgyn734@gmail.com");
        Customer customer4 = new Customer("Reeya Timalsina", "rtim@yahoo.com");

        // Create some products
        Plant cactus = new Plant("Cactus Cereus Peruvianus", 4990, Exposure.SUN);
        Plant philodendron = new Plant("'White Princess' Philodendron", 5500, Exposure.PARTSUN);
        Tool pruners = new Tool("Bypass Pruners", 2299);
        Tool cart = new Tool("Large Gardener's Cart", 34900);

        // Create some items
        Item item1 = new Item(cactus, 4);
        Item item2 = new Item(philodendron, 3);
        Item item3 = new Item(pruners, 2);
        Item item4 = new Item(cart, 1);

        // Create an order
        Order order = new Order(customer1);
        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);
        order.addItem(item4);

        // Display the order
        System.out.println(order);
    }
}
