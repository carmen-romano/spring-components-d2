package carmenromano.spring_components.entities;

import carmenromano.spring_components.enums.EStatoOrdine;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Ordine {
    private static int counter = 0;

    private int numeroOrdine;
    private EStatoOrdine stato;
    private Tavolo tavolo;
    private List<Item> elementiOrdinati;
    private LocalDateTime oraAcquisizione;


    public Ordine(Tavolo tavolo) {
        this.numeroOrdine = ++counter;
        this.stato = EStatoOrdine.INCORSO;
        this.tavolo = tavolo;
        this.elementiOrdinati = new ArrayList<>();
        this.oraAcquisizione = LocalDateTime.now();
    }

    public void aggiungiElementoOrdinato(Item item) {
        elementiOrdinati.add(item);
    }

    public List<Item> getListaOrdini() {
        return elementiOrdinati;
    }

    public double getImportoTotale() {
        double totale = tavolo.getNumeroCoperti() * tavolo.getCostoCoperto();
        for (Item elemento : elementiOrdinati) {
            totale += elemento.getPrice();
        }
        return totale;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "numeroOrdine=" + numeroOrdine +
                ", stato=" + stato +
                ", tavolo=" + tavolo +
                ", elementiOrdinati=" + elementiOrdinati +
                ", oraAcquisizione=" + oraAcquisizione +
                ", importoTotale=" + getImportoTotale() +
                '}';
    }
}
