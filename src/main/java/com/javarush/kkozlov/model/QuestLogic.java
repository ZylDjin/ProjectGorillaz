package com.javarush.kkozlov.model;



public class QuestLogic {
    private String currentState;
    private boolean gameOver;

    public QuestLogic() {
        this.currentState = "start";
        this.gameOver = false;
    }

    public String processAction(String action) {
        if (currentState.equals("start")) {
            if (action.equals("explore")) {
                currentState = "forest";
                return "You enter a dark forest...";
            } else if (action.equals("wait")) {
                currentState = "village";
                return "You decide to wait and find a friendly village.";
            }
        } else if (currentState.equals("forest")) {
            gameOver = true;
            return "A monster attacks you. Game Over.";
        } else if (currentState.equals("village")) {
            gameOver = true;
            return "The villagers help you find your way. You win!";
        }
        return "Unknown action.";
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
