package org.example.Datos;

import org.example.Modelos.Resena;
import org.example.Modelos.Vino;

import java.time.LocalDate;
import java.util.ArrayList;

public class Datos {
    private ArrayList<Vino> vinos;

    public Datos() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                Resena resena1 = new Resena("Me gusto", true, LocalDate.of(2024, 5, 22), 8);
                Resena resena2 = new Resena("Muy bueno", true, LocalDate.of(2024, 5, 18), 7);
                ArrayList<Resena> resenas1 = new ArrayList<>();
                resenas1.add(resena1);
                resenas1.add(resena2);
                Vino vino1 = new Vino(i +1, "imagen.jpg", "Vino Nº " + i, )
            }
        }
        //String Boolean Date Float Vino

        Resena resena3 = new Resena();
        Resena resena4 = new Resena();
        ArrayList<Resena> resenas2 = new ArrayList<>();
        resenas2.add(resena3);
        resenas2.add(resena4);

        Resena resena5 = new Resena();
        Resena resena6 = new Resena();
        ArrayList<Resena> resenas3 = new ArrayList<>();
        resenas3.add(resena5);
        resenas3.add(resena6);

        Vino vino2 = new Vino(resenas2);
        Vino vino3 = new Vino(resenas3);
        ArrayList<Vino> vinos = new ArrayList<>();
        vinos.add(vino1);
        vinos.add(vino2);
        vinos.add(vino3);
        this.vinos = vinos;
    }

    public ArrayList<Vino> getVinos() {
        return vinos;
    }

    public void setVinos(ArrayList<Vino> vinos) {
        this.vinos = vinos;
    }

}
