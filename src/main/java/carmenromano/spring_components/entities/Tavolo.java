package carmenromano.spring_components.entities;


import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Tavolo {
    private static int counter = 0;
    private int numero;
    private int numeroCoperti;
    private boolean occupato;
    private double costoCoperto;

    public Tavolo(double costoCoperto) {
        this.numero = ++counter;
        Random random = new Random();
        this.numeroCoperti = random.nextInt(10);
        this.occupato = false;
        this.costoCoperto = costoCoperto;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "numero=" + numero +
                ", numeroCoperti=" + numeroCoperti +
                ", occupato=" + occupato +
                '}';
    }
}
