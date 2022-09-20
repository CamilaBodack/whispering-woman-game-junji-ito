package com.camilabodack.junjiitogame;

import java.util.List;
import java.util.Random;

public class Mayumi {

    public Phrase ask(List<Phrase> questions) {
        Random random = new Random();
        Phrase randomQuestion = questions.get(random.nextInt(questions.size()));
        return randomQuestion;

    }
}
