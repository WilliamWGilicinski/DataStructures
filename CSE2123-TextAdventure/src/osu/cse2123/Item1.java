package osu.cse2123;

/**
 * Concrete class that creates an item object
 *
 * @author William Gilicinski
 * @version April 28th, 2021
 *
 */

public class Item1 implements Item {

    //Set up private variables
    private String name;
    private String desc;

    public Item1() {
        this.name = "";
        this.desc = "";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.desc;
    }

}
