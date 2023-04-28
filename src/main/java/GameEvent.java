 class GameEvent {
    private int playerNumber;
    private String eventType;
    private String eventDetails;
    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

     public void setPlayerNumber(int thePlayerNumber) {
         this.playerNumber = thePlayerNumber;
     }

     public void setEventType(String theEventType) {
         this.eventType = theEventType;
     }
     public void setEventDetails(String theEventDetails) {
        this.eventDetails = theEventDetails;
     }

     public int getPlayerNumber() {
         return playerNumber;
     }

     public String getEventType() {
         return eventType;
     }

     public String getEventDetails() {
         return eventDetails;
     }
 }
