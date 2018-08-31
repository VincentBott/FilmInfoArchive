package com.company;

public abstract class Figuur implements Comparable<Figuur>{
    private String naam;

    public Figuur(String naam) {

        this.naam = naam;
    }

    @Override
    public int compareTo(Figuur o) {
        return Double.compare(getOppervlakte(),o.getOppervlakte());
    }

    @Override
    public String toString() {
        return naam;
    }

    public abstract double getOppervlakte();

}
