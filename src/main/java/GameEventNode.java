class GameEventNode {
    /** This class creates a game event node
     * @author TaraLennon and Khadija Mohammadi
     * @verison 1
     */
    private GameEvent gameState;
    //stores specific game event
    private GameEventNode next;
    //stores next game event node


    public GameEventNode(GameEvent gameState) {
        //one parameter constructor
        this.gameState = gameState;
        next = null;
    }
    /**
     * Gets the game state
     * @return GameEvent representing the game state
     */
    public GameEvent getGameState() {
        return gameState;
    }
    /**
     * Sets the game state
     * @param gameState GameEvent representing the game state
     */
    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }
    /**
     * Gets the next field
     * @return GameEventNode representing the next node
     */
    public GameEventNode getNext() {
        return next;
    }
    /**
     * Sets the next field
     * @param next GameEventNode representing the next node
     */
    public void setNext(GameEventNode next) {
        this.next = next;
    }
}
