import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * 
 */

public class Room 
{
    private final String description;
    private PickableObject pickableObject;
    private final HashMap<String, Room> exits = new HashMap<>();        // stores exits of this room.
    private Room lastRoom;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
    }

    /**
     * Constructor.
     *
     * @param description the description.
     * @param pickableObject the pickable object.
     */
    public Room(String description, PickableObject pickableObject)
    {
        this.description = description;
        this.pickableObject = pickableObject;
    }
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * @return the objekt of the room.
     */
    public PickableObject getPickableObject() {
        return pickableObject;
    }

    public boolean canStepToNextRoom() {
        final PickableObject pickableObject = getPickableObject();
        return pickableObject == null | (pickableObject != null && pickableObject.isPicked());
    }

    public Room getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(Room lastRoom) {
        this.lastRoom = lastRoom;
    }

}

