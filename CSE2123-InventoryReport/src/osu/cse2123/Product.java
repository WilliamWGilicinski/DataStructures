package osu.cse2123;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple class for holding product information.
 *
 * @author William Gilicinski
 * @version March 11th, 2021
 */

public class Product {

    private String name;
    private String type;
    private String code;
    private int quantity;
    private int price;
    private List<Integer> ratings;

    /**
     * Product constructor - creates a default product with no name or type or
     * inventory code, no ratings, and a price and quantity of 0.
     *
     * @postcond a product object with no name or type or inventory code, no
     *           ratings and a price and quantity of 0
     */
    public Product() {
        this.name = "";
        this.type = "";
        this.quantity = 0;
        this.price = 0;
        this.ratings = new LinkedList<>();
    }

    /**
     * sets the name of the product object
     *
     * @param name
     *            new name for the product
     * @postcond product name is now name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the name of the product
     *
     * @return the name of the product
     */
    public String getName() {
        return this.name;
    }

    /**
     * sets the type of the product
     *
     * @param type
     *            the type of the product
     * @postcond sets the type of the product to type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * returns the type of the product
     *
     * @return - the product type
     */
    public String getType() {
        return this.type;
    }

    /**
     * sets the price of the product in cents. A $10 product will have a price
     * of 1000.
     *
     * @param price
     *            the price of the product
     * @postcond price of the product set to price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * returns the price of the product in cents.
     *
     * @return the price of the product in cents
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * sets the count of this product in our inventory.
     *
     * @param quantity
     *            the number of this product in inventory
     * @postcond quantity of product set to quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * returns the count of this product in our inventory
     *
     * @return the number of this product in inventory
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * sets the inventory code for this product
     *
     * @param code
     *            the new inventory code for the product
     * @postcond the inventory code for the product set to code
     */
    public void setInventoryCode(String code) {
        this.code = code;
    }

    /**
     * returns the inventory code for this product
     *
     * @return the inventory code of the product
     */
    public String getInventoryCode() {
        return this.code;
    }

    /**
     * NOTE: Each individual rating is stored with the product, so you need to
     * maintain a list of user ratings. This method should append a new rating
     * to the end of that list
     *
     * @param rating
     *            the new rating to add to this product
     * @postcond the list of ratings for this product includes rating
     */
    public void addUserRating(int rating) {
        this.ratings.add(rating);
    }

    /**
     * NOTE: See note on addUserRating above. This method should be written to
     * allow you to access an individual value from the list of user ratings
     *
     * @param index
     *            the index of the rating we want to see
     * @precond index < number of ratings for this product
     * @return the rating indexed by the value index
     */
    public int getUserRating(int index) {
        return this.ratings.get(index);
    }

    /**
     * NOTE: See note on addUserRating above. This method should be written to
     * return the total number of ratings this product has associated with it
     *
     * @return the number of ratings associated with this product
     */
    public int getUserRatingCount() {
        return this.ratings.size();
    }

    /**
     * NOTE: see note on addUserRating above. This method should be written to
     * compute the average user rating on demand from a stored list of ratings.
     *
     * @return the average rating for this product as a whole integer value (use
     *         integer math)
     */
    public int getAvgUserRating() {
        int average;
        int total = 0;
        //Adds the scores of the list and divides it by the user count
        for (int i = 0; i < this.getUserRatingCount(); i++) {
            total += this.getUserRating(i);
        }
        average = total / this.getUserRatingCount();

        return average;
    }
}
