package osu.cse2123;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Concrete class for the room object
 *
 * @author William Gilicinski
 * @version April 28th, 2021
 */

public class Room1 implements Room {

    //Set up private variables
    private String name;
    private List<String> desc;
    private Map<String, String> exit;
    private List<Item> item;

    public Room1() {
        this.name = "";
        this.desc = new LinkedList<>();
        this.exit = new HashMap<>();
        this.item = new LinkedList<>();
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
    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        String block = "";
        for (int i = 0; i < this.desc.size(); i++) {
            block += this.desc.get(i) + System.lineSeparator();
        }
        return block;
    }

    @Override
    public void setExit(String direction, String dest) {
        this.exit.put(direction, dest);
    }

    @Override
    public boolean hasExit(String direction) {
        return this.exit.containsKey(direction);
    }

    @Override
    public String getExit(String direction) {
        return this.exit.get(direction);
    }

    @Override
    public void addItem(Item it) {
        this.item.add(it);
    }

    @Override
    public boolean hasItem(String name) {
        boolean exist = false;

        //Iterates through the list to check if the item exists
        for (int i = 0; i < this.item.size() && !exist; i++) {
            exist = name.equalsIgnoreCase(this.item.get(i).getName());
        }

        return exist;
    }

    @Override
    public Item removeItem(String name) {
        Item value = new Item1();
        boolean stop = false;

        //Iterates through the list until the item index is found
        for (int i = 0; i < this.item.size() && !stop; i++) {
            if (name.equalsIgnoreCase(this.item.get(i).getName())) {
                value = this.item.remove(i);
                stop = true;
            }
        }

        return value;
    }

    @Override
    public String toString() {
        String output = "---" + System.lineSeparator();

        output += this.getName() + System.lineSeparator();
        output += this.getDesc() + System.lineSeparator();
        output += this.exit.toString() + System.lineSeparator();
        output += this.item.toString();

        return output;

    }

}
