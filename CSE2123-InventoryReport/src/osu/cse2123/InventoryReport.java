package osu.cse2123;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A program that generates an inventory report
 *
 * @name William Gilicinski
 * @version March 11th, 2021
 *
 */

public class InventoryReport {

    /**
     * Gets the filename from the user and outputs the header
     *
     * @param reader
     * @return The file name that the user inputed
     */
    public static String header(Scanner reader) {
        System.out.print("Enter an inventory filename: ");
        String name = reader.nextLine();
        System.out.println("Product Inventory Summary Report");
        System.out.println(
                "----------------------------------------------------------------------");
        System.out.println(
                "Product Name              I Code     Type Quant. Price  Rating # Rat.");
        System.out.println(
                "------------------------- ---------- ---- ------ ------ ------ ------");
        return name;
    }

    /**
     * Reads the input file and creates a list out of it
     *
     * @param fileName
     * @return fileList - the list of all the inputs
     */
    public static List<String> getList(String fileName) {
        List<String> fileList = new LinkedList<>();

        //Scans the file and adds each line to a list
        try {
            File listFile = new File(fileName);
            Scanner inFile = new Scanner(listFile);
            while (inFile.hasNext()) {
                fileList.add(inFile.nextLine());
            }
            inFile.close();

        } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found");
        }

        return fileList;
    }

    /**
     * Takes the list of strings and turns it into a list of product types
     *
     * @param list
     * @return
     */
    public static List<Product> getProductList(List<String> list) {

        List<Product> productList = new LinkedList<>();
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            //Adds the new product to an array
            Product name = new Product();
            productList.add(name);

            //Gets the string of information for the product
            temp = list.get(i);

            //Splits the information around the comma, and then adds in all of
            //the info.
            String[] info = temp.split(",");
            name.setName(info[0]);
            name.setInventoryCode(info[1]);
            name.setType(info[4]);
            name.setQuantity(Integer.parseInt(info[2]));
            name.setPrice(100 * Integer.parseInt(info[3]));

            //Adds in the user ratings
            if (info.length > 5) {
                for (int j = 5; j < info.length; j++) {
                    name.addUserRating(Integer.parseInt(info[j]));
                }
            }

        }

        return productList;
    }

    /**
     * Prints out the formatted body of the information
     *
     * @param productList
     */
    public static void body(List<Product> productList) {
        //Outputs the main body by going though each product
        for (int i = 0; i < productList.size(); i++) {
            System.out.printf("%-26.25s", productList.get(i).getName());
            System.out.printf("%-11s", productList.get(i).getInventoryCode());
            System.out.printf("%-5s", productList.get(i).getType());
            System.out.printf("%6d", productList.get(i).getQuantity());
            //Because price is stored as an int, it needs to be transformed back
            //into a double
            double price = productList.get(i).getPrice() / 10000.0;
            System.out.printf("%7.2f", price);

            String rating = "";
            if (productList.get(i).getUserRatingCount() > 0) {
                rating = starString(productList.get(i).getAvgUserRating());
            }
            System.out.printf("%7s", rating);
            System.out.printf(" %6d%n",
                    productList.get(i).getUserRatingCount());
        }
    }

    /**
     * Creates the footer for the information. Calculates the highest and lowest
     * average user value ratings
     *
     * @param productList
     */
    public static void footer(List<Product> productList) {
        System.out.println(
                "----------------------------------------------------------------------");
        System.out.println("Total products in database: " + productList.size());

        int idxHigh = 0;
        int idxLow = 0;

        //Finds which average user value rating is the highest and lowest
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getUserRatingCount() == 0) {
                idxLow = i;
            } else if (productList.get(i).getAvgUserRating() > productList
                    .get(idxHigh).getAvgUserRating()) {
                idxHigh = i;
            } else if (productList.get(i).getAvgUserRating() < productList
                    .get(idxLow).getAvgUserRating()) {
                idxLow = i;
            }
        }

        //Creates the star value representation of the user ratings
        String highString = "";
        String lowString = "";

        //Checks if there are 1 or more user reviews to prevent divide by 0
        //error
        if (productList.get(idxHigh).getUserRatingCount() > 0) {
            highString = starString(
                    productList.get(idxHigh).getAvgUserRating());
        }
        if (productList.get(idxLow).getUserRatingCount() > 0) {
            lowString = starString(productList.get(idxLow).getAvgUserRating());
        }

        System.out.println("Highest Average Ranked Item: "
                + productList.get(idxHigh).getName() + " " + "(" + highString
                + ") ");
        System.out.println("Lowest Average Ranked Item: "
                + productList.get(idxLow).getName() + " " + "(" + lowString
                + ") ");

        System.out.println(
                "----------------------------------------------------------------------");

    }

    /**
     * Creates a string with the amount of stars in num
     *
     * @param num
     * @return a string of "*"
     */
    public static String starString(int num) {
        String rating = "";
        for (int j = 0; j < num; j++) {
            rating += "*";
        }
        return rating;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String fileName = header(reader);
        List<String> fileList = getList(fileName);
        List<Product> productList = getProductList(fileList);
        body(productList);
        footer(productList);

    }

}
