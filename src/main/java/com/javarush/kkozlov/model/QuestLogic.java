package com.javarush.kkozlov.model;


import java.util.HashMap;
import java.util.Map;

/**
 * Логика квеста, реализующая переходы между состояниями.
 */
public class QuestLogic {
    private String currentState;
    private final Map<String, String> states;

    public QuestLogic() {
        this.currentState = "start";
        this.states = new HashMap<>();
        initializeStates();
    }

    /**
     * Инициализация всех возможных состояний и переходов.
     */
    private void initializeStates() {
        states.put("start-explore", "Вы нашли дом с закрытой дверью.");
        states.put("start-wait", "Вы остались на месте, и наступила ночь.");
        states.put("house-enter", "Вы вошли в дом и услышали шум.");
        states.put("house-run", "Вы сбежали, но кто-то вас преследует.");
        states.put("run-hide", "Вы спрятались и переждали опасность.");
        states.put("enter-find", "Вы нашли безопасное место.");
    }

    /**
     * Обрабатывает действие пользователя и переходит в новое состояние.
     *
     * @param action Действие пользователя.
     * @return Сообщение о результате действия.
     */
    public String proceed(String action) {
        String key = currentState + "-" + action;
        if (states.containsKey(key)) {
            currentState = action; // Обновление текущего состояния.
            return states.get(key);
        }
        return "Это действие недоступно.";
    }

    /**
     * Проверяет, завершена ли игра.
     *
     * @return true, если игра завершена.
     */
    public boolean isGameOver() {
        return currentState.equals("wait") || currentState.equals("find");
    }

    /**
     * Возвращает описание текущего состояния.
     *
     * @return Текущее описание.
     */
    public String getCurrentStateDescription() {
        return states.getOrDefault(currentState, "Начальное состояние.");
    }

    /**
     * Сбрасывает игру в начальное состояние.
     */
    public void reset() {
        currentState = "start";
    }
}
