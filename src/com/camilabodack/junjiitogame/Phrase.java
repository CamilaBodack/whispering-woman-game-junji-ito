package com.camilabodack.junjiitogame;

public enum Phrase {
    ANDAR("Devo andar ?"),
    CORRER("Devo correr ?"),
    SENTAR("Possor sentar ?"),
    PISCAR("Posso piscar ?"),
    LEVANTAR("Posso me levantar ?"),
    DORMIR("Devo dormir ?"),
    SUCO("Suco de laranja, de maçã, de uva ? qual devo beber ?"),
    RESPIRAR("Posso respirar ?"),
    RIR("Agora posso rir ? Ou chorar ?"),
    JANTAR("Devo jantar ?"),
    PE("Devo ficar de pé ?"),
    COMER("Devo passar manteiga ou geléia no pão ?");

    private String phrase;


    Phrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return phrase;
    }
}
