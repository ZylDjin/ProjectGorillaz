package com.javarush.kkozlov.service;

import com.javarush.kkozlov.model.QuestLogic;

/**
 * Сервис для управления игровой логикой.
 */
public class QuestService {

    private final QuestLogic questLogic;

    public QuestService(QuestLogic questLogic) {
        this.questLogic = questLogic;
    }

    /**
     * Обрабатывает действие игрока.
     *
     * @param action Действие пользователя.
     * @return Результат действия.
     */
    public String processAction(String action) {
        if (questLogic.isGameOver()) {
            return "Игра завершена. Начните заново.";
        }
        return questLogic.proceed(action);
    }

    /**
     * Проверяет, завершена ли игра.
     *
     * @return true, если игра завершена.
     */
    public boolean isGameOver() {
        return questLogic.isGameOver();
    }

    /**
     * Получает описание текущего состояния.
     *
     * @return Описание состояния.
     */
    public String getStateDescription() {
        return questLogic.getCurrentStateDescription();
    }

    /**
     * Сбрасывает состояние игры.
     */
    public void resetGame() {
        questLogic.reset();
    }
}