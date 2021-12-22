package osu.cse2123;

/**
 * A simple class for holding product information.
 *
 * @author William Gilicinski
 * @version March 18th, 2021
 */

public class Product {

    private String name;
    private String type;
    private String code;
    private int quantity;
    private int price;

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
        this.code = "";
        this.price = 0;
        this.quantity = 0;
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
        this.quantity = 0;
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
     * returns the String representation of this object (See project write-up
     * for details)
     *
     * @return the String representation of this object
     */
    @Override
    public String toString() {
        return "(" + this.name + ", " + this.code + ", " + this.type + ", "
                + this.price + ")";
    }

    /**
     * returns true if other equals this, false otherwise.
     *
     * @return true if other has the same value as this, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        boolean equal = false;
        if (other == this) {
            equal = true;
        } else if (other instanceof Product) {
            //Creates a product object that points to the other object
            Product localOther = (Product) other;
            //Nested ifs that must pass in order to determine if the values
            //are the same
            if (this.name.equals(localOther.name)) {
                if (this.code.equals(localOther.code)) {
                    if (this.type.equals(localOther.type)) {
                        equal = this.price == localOther.price;
                    }
                }
            }
        }
        return equal;
    }

    /**
     * returns an integer value for hashing (See the project write-up for
     * details)
     *
     * @return an integer value suitable for use in a HashMap or HashSet
     */
    @Override
    public int hashCode() {
        int code = 0;

        code += this.name.hashCode() + this.price + this.type.hashCode()
                + this.code.hashCode();

        return code;
    }
}
