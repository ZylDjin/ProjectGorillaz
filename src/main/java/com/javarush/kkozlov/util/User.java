package com.javarush.kkozlov.util;

import com.javarush.kkozlov.game.GameOne;
import lombok.Getter;
import java.util.Map;

@Getter
public class User {

    private final Map<Integer, Quest> allQuests = Map.of(
            1, new GameOne()

    );

    public Quest getQuest(String questId) {
        try {
            int number = Integer.parseInt(questId);
            Quest quest = allQuests.get(number);
            if (quest == null) {
                throw new IllegalArgumentException("Quest not found for questId: " + questId);
            }
            return quest;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Quest not found for questId: " + questId, e);
        }
    }


}