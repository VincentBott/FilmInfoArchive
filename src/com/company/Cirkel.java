package com.company;

public class Cirkel extends Figuur {
    private int straal;

    public Cirkel(int straal) {
        super("circle");
        this.straal = straal;

    }

    public double getOppervlakte() {
        return Math.PI * straal * straal;
    }



}
