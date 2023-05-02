
class GameEvent {
    /** This class creates a game event
     * @author TaraLennon & Khadija Mohammadi
     * @verison 1
     */
    private int playerNumber;
    //unique ID for player
    private String eventType;
    //tag for different event categories
    private String eventDetails;
    //description of the game event


    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        // a three parameter constructor
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

    /**
     * Gets the player number
     * @return integer representing player number
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Sets the player number
     * @param playerNumber integer representing player number
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    /**
     * Gets the event type
     * @return String representing the event type
     */
    public String getEventType() {
        return eventType;
    }
    /**
     * Sets the event type
     * @param eventType String representing the event type
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    /**
     * Gets the event details
     * @return String representing the event details
     */
    public String getEventDetails() {
        return eventDetails;
    }
    /**
     * Sets the event details
     * @param eventDetails String representing the event details
     */
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}

