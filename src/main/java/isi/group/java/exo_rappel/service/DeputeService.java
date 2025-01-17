

package isi.group.java.exo_rappel.service;

import isi.group.java.exo_rappel.entity.Depute;
import isi.group.java.exo_rappel.entity.Region;

import java.util.ArrayList;
import java.util.List;

public class DeputeService {

    public static List<Depute> getDeputes() {
        // Créer des régions
        Region region1 = new Region(1L, "Dakar");
        Region region2 = new Region(2L, "Saint-Louis");
        Region region3 = new Region(3L, "Thiès");

        // Créer des députés
        List<Depute> deputes = new ArrayList<>();
        deputes.add(new Depute(1L, "DEP001", "Diop", "Mamadou", "1970-03-15", "Parti A", region1));
        deputes.add(new Depute(2L, "DEP002", "Sow", "Fatou", "1985-07-22", "Parti B", region2));
        deputes.add(new Depute(3L, "DEP003", "Ndiaye", "Abdoulaye", "1990-01-10", "Parti C", region1));
        deputes.add(new Depute(4L, "DEP004", "Ba", "Aminata", "1982-11-05", "Parti A", region3));
        deputes.add(new Depute(5L, "DEP005", "Faye", "Cheikh", "1978-05-30", "Parti B", region2));
        return deputes;
    }

}