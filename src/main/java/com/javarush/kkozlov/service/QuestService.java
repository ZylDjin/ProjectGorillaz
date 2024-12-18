package com.javarush.kkozlov.service;

import com.javarush.kkozlov.model.QuestLogic;

public class QuestService {

    private final QuestLogic questLogic;

    public QuestService(QuestLogic questLogic) {
        this.questLogic = questLogic;
    }

    /**
     * Обрабатывает действие игрока.
     *
     * @param action Действие, выбранное игроком.
     * @return Результат обработки действия.
     */
    public String processAction(String action) {
        if (questLogic.isGameOver()) {
            return "The game is already over. Restart to play again.";
        }
        return questLogic.processAction(action);
    }

    /**
     * Проверяет, завершена ли игра.
     *
     * @return true, если игра завершена, иначе false.
     */
    public boolean isGameOver() {
        return questLogic.isGameOver();
    }

    /**
     * Получает текущее состояние игры.
     *
     * @return Текущее состояние игры.
     */
    public String getCurrentState() {
        return questLogic.getCurrentState();
    }
}
