package com.camilabodack.junjiitogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

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
        questions.add("Suco de laranja, de maçã, de uva ? qual devo beber ?");
        questions.add("Posso respirar ?");
        questions.add("Agora posso rir ? Ou chorar ?");
        questions.add("Devo jantar ?");
        questions.add("Devo ficar de pé ?");
        questions.add("Devo passar manteiga ou geléia no pão ?");

        conversation(mayumi, mitsu, questions);

    }

    public static boolean getMitsuAnswear() {
        System.out.println("""
                    \n
                    Seja bem vinda, Srta Mitsu ...
                    Minha filha possui uma característica bastante peculiar  ...
                    Ela faz diversas perguntas as quais se não forem respondidas corretamente...
                    fazem com que ela fique agitada, fazendo mais e mais perguntas ...
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mitsu, deseja aceitar realmente esse emprego ? 1 - Sim | 2 - Não");
        int continuar = scanner.nextInt();
        return continuar == 1;
    }

    public static void conversation(Mayumi mayumi, Mitsu mitsu, List<String> questions) {
        int countCorrectInstructions = 0;
        boolean acceptService = getMitsuAnswear();

        if (!acceptService) {
            System.out.println("Sem problemas, obrigada Srta Mitsu.");
            System.exit(0);
        } else {
            System.out.print("""
                    \n
                    O Jogo é composto por 5 perguntas que serão feitas pela Mayumi. 
                    Vencerá caso consiga orienta-la corretamente em 3 ou mais respostas.
                    -----------------------------------------------------------------------------                    
                    Dê informações bem definidas para as perguntas por exemplo:
                    'Devo andar ?'
                    Resposta: Sim, caminhe dando pequenos passos e devagar para não se machucar.
                    ------------------------------------------------------------------------------
                    \n
                    """);
            for (int i = 0; i < 5; i++) {
                String question = mayumi.ask(questions);
                System.out.println(question);
                String mitsuAnswear = mitsu.answear();
                boolean correctAnswear = checkMitsuInstructions(question, mitsuAnswear);

                if (correctAnswear) {
                    System.out.println("Mayumi: ... Assim ? E agora o que devo fazer ?");
                    System.out.println("\nMitsu: ... Preste atenção ... Psss ... Psss\n");
                    System.out.println("Mitsu: .... Pss ... pss ...  psss ...");
                    countCorrectInstructions++;

                }
            }

            if (countCorrectInstructions < 3) {
                System.out.println("""
                        Shigeki Santo (Pai da Mayumi):
                        A Srta Mayumi encontra-se paralisada devido ao estresse.
                        Agradecemos a sua tentativa de ajudá-la.
                        """);
                System.exit(0);
            } else {
                System.out.println("""
                        \n
                        Shikeki Santo (Pai da Mayumi):
                        Estou impressionado com as suas habilidades.
                        É incrível a força mental que você possui...
                        Você esta trazendo sorte a Mayumi também...
                        Obrigada por aceitar esse trabalho e fazê-lo tão bem.
                        """);
            }

        }
    }

    public static boolean checkMitsuInstructions(String mayumiQuestion, String mitsuAnswear) {
        String question = mayumiQuestion.toLowerCase();
        String checkAnswear = mitsuAnswear.toLowerCase();
        boolean correctInstruction;
        switch (question) {
            case "devo andar ?":
                correctInstruction = checkAnswear.matches("^.*(andar|devagar|passos|).*$");
                break;
            case "devo correr ?":
                correctInstruction = checkAnswear.matches("^.*(n[ãa]o|caminh[ear]|cuidado)+.*$");
                break;
            case "devo sentar ?":
                correctInstruction = checkAnswear.matches("^.*(sim|cadeira)+.*$");
                break;
            case "posso piscar ?":
                correctInstruction = checkAnswear.matches("^.*(sim|olhos|palpebra)+.*$");
                break;
            case "posso me levantar ?":
                correctInstruction = checkAnswear.matches("^.*(sim|n[aã]o|devagar).*$");
                break;
            case "devo dormir ?":
                correctInstruction = checkAnswear.matches("^.*(sim|n[aã]o)+.*$");
                break;
            case "suco de laranja, de maçã, de uva ? qual devo beber ?":
                correctInstruction = checkAnswear.matches("^.*(sim|n[ãa]o|suco|copo|beber)+.*$");
                break;
            case "posso respirar ?":
                correctInstruction = checkAnswear.matches("^.*(sim|devagar|calma)+.*$");
                break;
            case "agora posso rir ? ou chorar ?":
                correctInstruction = checkAnswear.matches("^.*rir.*$");
                break;
            case "devo jantar ?":
                correctInstruction = checkAnswear.matches("^.*sim+.*hora+.*$");
                break;
            case "devo ficar de pé ?":
                correctInstruction = checkAnswear.matches("^.*(sim|n[ãa]o)+.*$");
                break;
            case "devo passar manteiga ou geléia no pão ?":
                correctInstruction = checkAnswear.matches("^.*(manteiga|gel[ée]ia|quantidade)+.*$");
                break;
            default:
                correctInstruction = false;
                break;

        }
        return correctInstruction;
    }


}
