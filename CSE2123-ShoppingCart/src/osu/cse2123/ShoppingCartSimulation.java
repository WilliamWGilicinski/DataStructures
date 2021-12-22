package osu.cse2123;

/**
 * A simple program that implements an interactive shopping cart.
 *
 * @author William Gilicinski
 * @version March 18th, 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCartSimulation {

    /**
     * Loads a List of Product objects from a file (format given in the project
     * write-up). You should assume that the file is correctly formatted.
     *
     * @param fname
     *            name of properly formatted product file to load data from
     * @precond fname is a properly formatted file as given in the assignment
     * @return List of Product objects as read from the file
     */
    public static List<Product> loadProductsFromFile(String fname)
            throws FileNotFoundException {
        List<String> fileList = new LinkedList<>();

        //Scans the file and adds each line to a list
        File listFile = new File(fname);
        Scanner inFile = new Scanner(listFile);
        while (inFile.hasNext()) {
            fileList.add(inFile.nextLine());
        }
        inFile.close();

        List<Product> productList = new LinkedList<>();
        String temp = "";
        for (int i = 0; i < fileList.size(); i++) {
            //Adds the new product to an array
            Product name = new Product();
            productList.add(name);

            //Gets the string of information for the product
            temp = fileList.get(i);

            //Splits the information around the comma, and then adds in all of
            //the info.
            String[] info = temp.split(",");
            name.setName(info[0]);
            name.setInventoryCode(info[1]);
            name.setPrice(Integer.parseInt(info[2]));
            name.setType(info[3]);
        }

        return productList;
    }

    /**
     * Prints the choices for the user to choose from to the screen (See the
     * project write-up for details)
     *
     * @param prods
     *            List of Product objects to display for purchase
     */
    public static void displayChoices(List<Product> prods) {
        for (int i = 0; i < prods.size(); i++) {
            //Outputs formatted text
            System.out.printf("%-6d%-35s%5.2f%n", (i + 1),
                    prods.get(i).getName(), prods.get(i).getPrice() / (100.00));
        }
        System.out.println();
    }

    /**
     * Prints the current contents of hte shopping cart (See the project
     * write-up for details)
     *
     * @param cart
     *            a Map of (Product,Integer) where the key is the product in the
     *            cart and the value is the quantity of that product in the
     *            cart.
     */
    public static void displayCart(Map<Product, Integer> cart) {
        Set<Product> keys = cart.keySet();
        //Iterates over the map
        for (Product key : keys) {
            //Displays formatted text
            System.out.printf("%-40s%d x %-10.2f%.2f%n", key.getName(),
                    cart.get(key), key.getPrice() / 100.00,
                    (cart.get(key) * (key.getPrice() / 100.0)));
        }
        //Prints the total cost of the current cart
        System.out.printf("Total cost:%11.2f%n", calcTotalPrice(cart));
    }

    /**
     * Adds items into the cart and finds out the quantity of items.
     *
     * @param cart
     * @param reader
     * @param prods
     * @return whether the user wants to quit or not
     */
    public static boolean selectProduct(Map<Product, Integer> cart,
            Scanner reader, List<Product> prods) {

        //User enters which product they want to buy
        boolean keepGoing = true;
        System.out.print("Enter something to add to the cart (0 to quit): ");
        int quantity = 0;
        int productNum = Integer.parseInt(reader.nextLine());

        //Checks if the user wants to quit
        if (productNum != 0) {
            System.out.print("Enter a quantity: ");
            quantity = Integer.parseInt(reader.nextLine());

            //Adds product into the map
            if (productNum <= prods.size()) {
                cart.put(prods.get(productNum - 1), Integer.valueOf(quantity));
            }
            //Updates keepGoing so the program will end
        } else {
            keepGoing = false;
        }
        return keepGoing;
    }

    /**
     * Loops the main body of the text until the user doesn't want to continue
     *
     * @param fileName
     * @param reader
     * @throws FileNotFoundException
     */
    public static void body(String fileName, Scanner reader)
            throws FileNotFoundException {
        boolean keepGoing = true;
        Map<Product, Integer> cart = new HashMap<>();
        //Creates list of products
        List<Product> productList = loadProductsFromFile(fileName);
        //Loops until the user wants to exit
        while (keepGoing) {
            //Shows the product choices
            displayChoices(productList);
            //Lets user select which product and how much they want of it
            keepGoing = selectProduct(cart, reader, productList);
            //Continues if the user didn't enter 0
            if (keepGoing) {
                //Displays the current state of the cart
                System.out.println("Your cart contains:");
                displayCart(cart);
                System.out.println();
                //Confirms user wants to continue
                keepGoing = hitEnter(reader, keepGoing);
            }
        }
        //Adds the final state of the cart and final prices
        footer(cart);
    }

    /**
     * Calculates the total price of whats in the cart
     *
     * @param cart
     * @return the total price of the cart
     */
    public static double calcTotalPrice(Map<Product, Integer> cart) {
        double totalPrice = 0;
        Set<Product> keys = cart.keySet();
        //Iterates over the map
        for (Product key : keys) {
            totalPrice += ((key.getPrice() / 100.0) * cart.get(key));
        }
        return totalPrice;
    }

    /**
     * Checks if the user wants to continue based on if they hit enter or not
     *
     * @param reader
     * @param keepGoing
     * @return keepGoing
     * @updates keepGoing to see if the user wants to continue
     */
    public static boolean hitEnter(Scanner reader, boolean keepGoing) {
        System.out.print("Hit ENTER to continue");
        String next = reader.nextLine();
        if (!next.equals("")) {
            keepGoing = false;
        }
        return keepGoing;
    }

    /**
     * Displays the final purchases the user made
     *
     * @param cart
     *            The map of the users cart
     */
    public static void footer(Map<Product, Integer> cart) {
        System.out.println("Your final purchases: ");
        displayCart(cart);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter an input file: ");
        String fileName = reader.nextLine();
        body(fileName, reader);
    }

}
