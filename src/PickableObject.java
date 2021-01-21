/**
 * Pickable Object - Class representing a object which can be picked in a room.
 */
public class PickableObject {

    // ---- Fields

    private final String name;
    private final boolean mustBePicked;
    private boolean isPicked;


    // ---- Constructor

    /**
     * Constructor.
     *
     * @param name         the name.
     * @param mustBePicked {@code true} if the instance must be picked in a room, {@code false} otherwise.
     */
    public PickableObject(String name, boolean mustBePicked) {
        this.name = name;
        this.mustBePicked = mustBePicked;
    }


    // ---- Methods

    public String getName() {
        return name;
    }

    public boolean isMustBePicked() {
        return mustBePicked;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        this.isPicked = picked;
    }

}
