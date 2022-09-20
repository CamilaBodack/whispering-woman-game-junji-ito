package com.camilabodack.junjiitogame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Mayumi mayumi = new Mayumi();
        Mitsu mitsu = new Mitsu();

        List<Phrase> questions = Arrays.asList(Phrase.values());
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

    public static void conversation(Mayumi mayumi, Mitsu mitsu, List<Phrase> questions) {
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
                Phrase question = mayumi.ask(questions);
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

    public static boolean checkMitsuInstructions(Phrase mayumiQuestion, String mitsuAnswear) {
        Phrase question = mayumiQuestion;
        String checkAnswear = mitsuAnswear.toLowerCase();
        boolean correctInstruction;
        switch (question) {
            case ANDAR:
                correctInstruction = checkAnswear.matches("^.*(andar|devagar|passos).*$");
                break;
            case CORRER:
                correctInstruction = checkAnswear.matches("^.*(n[ãa]o|caminh[ear]|cuidado)+.*$");
                break;
            case SENTAR:
                correctInstruction = checkAnswear.matches("^.*(sim|cadeira)+.+$");
                break;
            case PISCAR:
                correctInstruction = checkAnswear.matches("^.*(sim|olhos|palpebra)+.+$");
                break;
            case LEVANTAR:
                correctInstruction = checkAnswear.matches("^.*(sim|n[aã]o|devagar).+$");
                break;
            case DORMIR:
                correctInstruction = checkAnswear.matches("^.*(sim|n[aã]o)+.+$");
                break;
            case SUCO:
                correctInstruction = checkAnswear.matches("^.*(sim|n[ãa]o|suco|copo|beber)+.*$");
                break;
            case RESPIRAR:
                correctInstruction = checkAnswear.matches("^.*(sim|devagar|calma)+.*$");
                break;
            case RIR:
                correctInstruction = checkAnswear.matches("^.*rir.*$");
                break;
            case JANTAR:
                correctInstruction = checkAnswear.matches("^.*sim+.*hora+.*$");
                break;
            case PE:
                correctInstruction = checkAnswear.matches("^.*(sim|n[ãa]o)+.*$");
                break;
            case COMER:
                correctInstruction = checkAnswear.matches("^.*(manteiga|gel[ée]ia|quantidade)+.*$");
                break;
            default:
                correctInstruction = false;
                break;

        }
        return correctInstruction;
    }


}
