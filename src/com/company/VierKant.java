package com.company;

public class VierKant extends Figuur {
    private int zijde;

    public VierKant(int zijde) {
        super("vierkant");
        this.zijde = zijde;

    }

    public double getOppervlakte() {
        return (double)(zijde * zijde);
    }


}
