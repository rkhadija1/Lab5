class GameEventNode {
    private GameEvent gameState;
    private GameEventNode next;
    public GameEventNode(GameEvent gameState){
        this.gameState = gameState;
        this.next = null;
    }

    public void setGameState(GameEvent theGameState) {
        this.gameState = theGameState;
    }

    public void setNext(GameEventNode theNext) {
        this.next = theNext;
    }

    public GameEvent getGameState() {
        return gameState;
    }

    public GameEventNode getNext() {
        return next;
    }
}
