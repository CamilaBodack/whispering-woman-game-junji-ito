package com.camilabodack.junjiitogame;

import java.util.List;
import java.util.Random;

public class Mayumi {

    public String ask(List<String> questions) {
        Random random = new Random();
        String randomQuestion = questions.get(random.nextInt(questions.size()));
        return randomQuestion;

    }
}
