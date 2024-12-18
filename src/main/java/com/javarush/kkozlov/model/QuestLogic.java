package com.javarush.kkozlov.model;


public class QuestLogic {
    private String currentState;

    public QuestLogic() {
        this.currentState = "start";
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String state) {
        this.currentState = state;
    }

    public String processAction(String action) {
        if ("start".equals(currentState)) {
            if ("explore".equals(action)) {
                currentState = "forest";
                return "You enter a dark forest...";
            } else if ("wait".equals(action)) {
                currentState = "village";
                return "You decide to wait and find a friendly village.";
            }
        }
        return "Unknown action.";
    }

    public boolean isGameOver() {
        return "forest".equals(currentState) || "village".equals(currentState);
    }
}
