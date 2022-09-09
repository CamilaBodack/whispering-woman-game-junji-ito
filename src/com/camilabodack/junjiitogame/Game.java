package com.camilabodack.junjiitogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends Thread {

    public static void main(String[] args) {

        Mayumi mayumi = new Mayumi();
        Mitsu mitsu = new Mitsu();

        List<String> questions = new ArrayList<>();

        questions.add("Devo andar ?");
        questions.add("Devo correr ?");
        questions.add("Possor sentar ?");
        questions.add("Posso piscar ?");
        questions.add("Posso me levantar ?");
        questions.add("Devo dormir ?");
        questions.add("Devo tomar café ou chá ?");
        questions.add("Suco de laranja, de maça, de uva ? qual devo beber ?");
        questions.add("Hoje devo usar qual roupa ?");
        questions.add("Posso respirar ?");
        questions.add("O que devo fazer agora ?");
        questions.add("Agora posso rir ? Ou chorar ?");
        questions.add("Devo jantar ?");
        questions.add("Devo caminhar primeiro com a perna esquerda ou direita ?");
        questions.add("Devo ficar de pé ?");
        questions.add("Devo me deitar de barriga para cima ou para baixo ?");
        questions.add("Devo passar manteiga ou geléia no pão ?");

        List<String> answears = new ArrayList<>();

        answears.add("Srta. Mayumi... sente-se na cadeira");
        answears.add("Ande até a cadeira");
        answears.add("Abaixe-se devagar");
        answears.add("Então respire fundo até se acalmar");
        answears.add("Vamos passear pelo jardim");


        wellComeMitsu();
        System.out.println("Mayumi pergunta: " + mayumi.ask(questions));

    }
        public static void wellComeMitsu() {
            System.out.println("""
                        Seja bem vinda, Srta Mitsu ...
                        Minha filha possui uma condição a qual a impede ter de uma rotina normal ...
                        Ela faz diversas perguntas as quais se não forem respondidas corretamente...
                        fazem com que ela fique agitada, fazendo mais e mais perguntas ... 
                    """);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Mitsu, deseja aceitar realmente esse emprego ? 1 - Sim | 2 - Não");
            int continuar = scanner.nextInt();
            if (continuar != 1){
                System.out.println("Sem problemas, obrigada Srta Mitsu.");
            }

        }


}
