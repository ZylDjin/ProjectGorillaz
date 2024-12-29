package com.javarush.kkozlov.game;

import com.javarush.kkozlov.util.State;
import com.javarush.kkozlov.util.Quest;
import com.javarush.kkozlov.util.QuestStage;
import com.javarush.kkozlov.util.Selectors;
import com.javarush.kkozlov.util.Choice;

import java.util.List;

public class GameOne extends Quest {

    private static final String IMAGE_PATH = "img/GameOne/";
    private static final String DEFAULT_CHOICE = "Default Choice";

    public GameOne() {
        super("GameOne", 1, initializeStages());
    }

    private static List<QuestStage> initializeStages() {
        return List.of(
                createStage("Пролог", 0, State.PLAYING, "stage00.png",
                        """
                        Ведьмак Геральт и его друг Лютик, отдыхая после напряженных приключений, решают провести день на рыбалке...
                        """, Selectors.NONE, DEFAULT_CHOICE, 1, "Далее"),
                createStage("", 1, State.PLAYING, "stage1.png",
                        """
                        Внезапно, Геральт заметил странную бутылку, плавающую на поверхности воды...
                        """, Selectors.NONE, DEFAULT_CHOICE, 2, "Далее"),
                createStage("Находка", 2, State.PLAYING, "stage2.png",
                        """
                        Геральт, слегка озадаченный, внимательнее присмотрелся к бутылке...
                        """, Selectors.OPTIONS,
                        new Choice("Открыть бутылку, чтобы узнать, что внутри", 3),
                        new Choice("Не открывать бутылку", 7),
                        "Выбрать"),
                createStage("Поражение!", 7, State.LOST, "stage7.png",
                        """
                        Вы выкинули бутылку обратно в озеро. На этом приключение заканчивается...
                        """, Selectors.NONE, DEFAULT_CHOICE, 0, "Пройти заново"),
                createStage("Джин", 3, State.PLAYING, "stage3.png",
                        """
                        Вы решаете открыть бутылку. Как только крышка соскальзывает, перед вами появляется могучее существо...
                        """, Selectors.OPTIONS,
                        new Choice("Объяснить джину, что вы не враг", 4),
                        new Choice("Сразиться с джином", 8),
                        "Выбрать"),
                createStage("Желание", 4, State.PLAYING, "stage4.png",
                        """
                        Успокоившись, джин смотрит на вас и кажется, начинает понимать, что произошло...
                        """, Selectors.INPUT, DEFAULT_CHOICE, 5, "Загадать желание"),
                createStage("", 5, State.PLAYING, "stage5.png",
                        """
                        Вы произносите свое желание. Джин секунду смотрит на вас...
                        """, Selectors.NONE, DEFAULT_CHOICE, 6, "Далее"),
                createStage("Победа!", 6, State.WON, "stage6.png",
                        """
                        Очнувшись вы замечаете, что мир вокруг изменился...
                        """, Selectors.NONE, DEFAULT_CHOICE, 0, "Пройти заново")
        );
    }

    private static QuestStage createStage(String title, int id, State state, String imageFile,
                                          String text, Selectors selector, Object option1,
                                          Object option2, String button) {
        QuestStage.QuestStageBuilder builder = QuestStage.builder()
                .title(title)
                .id(id)
                .state(state)
                .image(IMAGE_PATH + imageFile)
                .text(text)
                .selector(selector)
                .button(button);

        if (option1 instanceof String) {
            builder.defaultOption(new Choice((String) option1, (int) option2));
        } else if (option1 instanceof Choice && option2 instanceof Choice) {
            builder.option1((Choice) option1).option2((Choice) option2);
        }

        return builder.build();
    }
}