package osu.cse2123;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Add your header here
 *
 * @author William Gilicinski
 * @version April 28th, 2021
 *
 */

public class Game {

    /**
     * Imports the rooms from a text file into a set of room items
     *
     * @param fname
     * @return rooms Set of rooms
     */
    public static List<Room> importRoom(String fname) {
        List<Room> rooms = new LinkedList<>();

        //Try catch is used for a file not found exception
        try {
            //Creates file scanner
            File roomFile = new File(fname);
            Scanner in = new Scanner(roomFile);

            //Loops the creation of rooms until there are none to add
            while (in.hasNext()) {
                //Adds name from the first line
                Room temp = new Room1();
                String name = in.nextLine();
                temp.setName(name);

                /**
                 * Creates the exits, the second line of each room description
                 * has a (letter: room name,) the code goes through all of the
                 * exits and assigns them a room and direction
                 */
                String exits = in.nextLine();
                String[] exitsArr = exits.split(",");
                for (int i = 0; i < exitsArr.length; i++) {
                    String direction = exitsArr[i].substring(0, 1);
                    String roomName = exitsArr[i].substring(2);

                    if (direction.equals("N")) {
                        direction = "north";
                    } else if (direction.equals("E")) {
                        direction = "east";
                    } else if (direction.equals("S")) {
                        direction = "south";
                    } else if (direction.equals("W")) {
                        direction = "west";
                    } else if (direction.equals("U")) {
                        direction = "up";
                    } else {
                        direction = "down";
                    }

                    temp.setExit(direction, roomName);
                }

                //Creates the formated list of strings based
                String descLine = "";
                List<String> description = new LinkedList<>();
                while (!descLine.equals("---")) {
                    descLine = in.nextLine();
                    if (!descLine.equals("---")) {
                        description.add(descLine);
                    }
                }
                temp.setDesc(description);
                //Adds the room to the list of rooms
                rooms.add(temp);
            }
            //close file reader
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(fname + " not found");
        }
        return rooms;
    }

    /**
     * Imports the items in the items.txt file and updates the rooms with their
     * appropriate items
     *
     * @param fname
     *            file name ("items.txt")
     * @param rooms
     *            list of rooms
     * @updates rooms Gives the rooms their items
     * @return items a list of all the items
     */
    public static List<Item> importItem(String fname, List<Room> rooms) {

        List<Item> items = new LinkedList<>();

        //Try and catch is used for a file not found exception
        try {

            //Creates scanner
            File roomFile = new File(fname);
            Scanner in = new Scanner(roomFile);

            //Iterates until all the items from the file are imported
            while (in.hasNext()) {
                //Set temp variable
                Item temp = new Item1();
                //Set name of item
                String name = in.nextLine();
                temp.setName(name);
                //Set description of item
                String desc = in.nextLine();
                temp.setDesc(desc);
                /**
                 * Sets location of item by iterating over list of rooms to find
                 * the correct room to place the item in
                 */
                String location = in.nextLine();
                for (Room rm : rooms) {
                    if (rm.getName().equals(location)) {
                        rm.addItem(temp);
                    }
                }
                //Add the temp variable and skip over the seperator lines
                items.add(temp);
                in.nextLine();
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(fname + " not found");
        }
        return items;
    }

    /**
     * Outputs the text when the player enters a room
     *
     * The text will be formatted in such a manner below: Name of room
     * Description of room Exits of room Items in room (if items exist in the
     * room)
     *
     * @param room
     */
    public static void outputText(Room room, List<Item> items) {
        //Display name of room
        System.out.println(room.getName());
        //Display description of room
        System.out.print(room.getDesc());

        /**
         * Displays the exits of the room. Because of the limitations of the
         * room class, a list of all the directions are used to find if they
         * exist for that room, and if they do they are displayed
         */
        System.out.print("There are exits in the following directions: ");

        String[] directions = { "east", "north", "south", "west", "up",
                "down" };
        String output = "";
        for (int i = 0; i < directions.length; i++) {
            if (room.hasExit(directions[i])) {
                output += directions[i] + ", ";
            }
        }
        output = output.substring(0, output.length() - 2);
        System.out.println(output);

        //Displays the items in the room
        String output2 = "";
        for (Item it : items) {
            if (room.hasItem(it.getName())) {
                output2 += it.getDesc() + ", ";
            }
        }
        if (output2.length() > 2) {
            output2 = output2.substring(0, output2.length() - 2);
        }
        if (output2.length() > 0) {
            System.out.println("There is " + output2 + " here.");
        }
        System.out.println();
    }

    /**
     * Finds if the user wants to exit the program
     *
     * @param reader
     */
    public static boolean inputQuit(String input) {

        boolean keepGoing = true;

        if (input.equalsIgnoreCase("quit")) {
            keepGoing = false;
        }

        return keepGoing;
    }

    /**
     * Finds what the user wants to do based on their input.
     *
     * @param input
     *            User input
     * @param inventory
     *            Current inventory
     * @param currentRoom
     * @param rooms
     *            List of the rooms
     * @return current room Will change the room the user is in depending on if
     *         they want to change their location
     */
    public static Room inputContinue(String input, List<Item> inventory,
            Room currentRoom, List<Room> rooms) {

        /**
         * Finds the first and second word the user inputs. This is used as the
         * first word is used to denote an action and the second word, if a
         * second word is used, describes how the user is performing the action.
         */
        int space = input.indexOf(' ');
        String firstWord = input;
        String secondWord = input;

        if (space > 0) {
            firstWord = input.substring(0, space);
            secondWord = input.substring(space + 1);
        }

        /**
         * Displays the user's inventory by iterating over it
         */
        if (firstWord.equalsIgnoreCase("inventory")) {
            System.out.println("You are currently carrying:");
            //If the inventory is empty
            if (inventory.size() == 0) {
                System.out.println("   nothing");
            } else {
                for (int i = 0; i < inventory.size(); i++) {
                    System.out.println("   " + inventory.get(i).getDesc());
                }
            }
            System.out.println();
        }

        /**
         * Changes the room the user wants to be in
         */
        else if (firstWord.equalsIgnoreCase("go")) {
            if (currentRoom.hasExit(secondWord.toLowerCase())) {
                //Gets the room connected to the direction
                String exitRoom = currentRoom.getExit(secondWord);
                for (int i = 0; i < rooms.size(); i++) {
                    //Changes the current room the player is standing in
                    if (rooms.get(i).getName().equalsIgnoreCase(exitRoom)) {
                        currentRoom = rooms.get(i);
                    }
                }
            } else {
                System.out.println("Not a valid exit");
            }

        }

        /**
         * Picks up an item on the ground and puts it into the inventory while
         * taking it out of the room
         */
        else if (firstWord.equalsIgnoreCase("get")) {
            if (currentRoom.hasItem(secondWord)) {
                Item temp = currentRoom.removeItem(secondWord);
                inventory.add(temp);
                System.out.println("You pick up " + temp.getDesc() + ".");
            } else {
                System.out.println("There is no " + secondWord + " here.");
            }
            System.out.println();
        }

        /**
         * Drops an item from the user's inventory and adds it to a room
         */
        else if (firstWord.equalsIgnoreCase("drop")) {
            boolean valid = false;
            int itemNum = 0;
            //Finds if the item is in the user inventory
            if (inventory.size() > 0) {
                for (int i = 0; i < inventory.size() && !valid; i++) {
                    valid = inventory.get(i).getName()
                            .equalsIgnoreCase(secondWord);
                    itemNum = i;
                }
            }
            //If the item is in the user inventory, the item is dropped
            if (valid) {
                Item temp = inventory.get(itemNum);
                System.out.println("You drop " + temp.getDesc() + ".");
                currentRoom.addItem(inventory.get(itemNum));
                inventory.remove(itemNum);
            } else {
                System.out.println("That item is not in your inventory");
            }
            System.out.println();

            /**
             * Else is used when the user enters an unknown command
             */
        } else {
            System.out.println("Not a valid input\n");
        }
        return currentRoom;
    }

    public static void main(String[] args) {
        //Create scanner
        Scanner reader = new Scanner(System.in);
        //Creates the list of rooms, items, and the user inventory
        List<Room> rooms = importRoom("rooms.txt");
        List<Item> items = importItem("items.txt", rooms);
        List<Item> inventory = new LinkedList<>();

        //Start the user in the starter room
        Room currentRoom = rooms.get(0);
        boolean keepGoing = true;

        //Iterates until the user wants to stop playing
        while (keepGoing) {
            //Outputs room and gets user input
            outputText(currentRoom, items);
            System.out.print("> ");
            String input = reader.nextLine();
            //If the user want to continue, program implements the users input
            if (inputQuit(input)) {
                currentRoom = inputContinue(input, inventory, currentRoom,
                        rooms);
            } else {
                //Prompts the user making sure if they want to end the game
                System.out.println("Are you sure you want to quit?");
                System.out.print("> ");
                String sureQuit = reader.nextLine();
                if (sureQuit.equals("y")) {
                    keepGoing = false;
                }
            }
        }

        reader.close();
    }

}
