import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paquet {
    private List<Carte> cartes;
    public Paquet() {
        cartes = new ArrayList<>();
        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            for (Carte.Valeur valeur : Carte.Valeur.values()) {
            cartes.add(new Carte(couleur, valeur));
            }
        }
    }

    public Carte piocher(){
        if(cartes.isEmpty()){
            return null;
        }
        return cartes.remove(0);
    }

    public boolean presqueVide(){
        return cartes.size() < 5;
    }

    public void melanger(){
        Collections.shuffle(cartes);
    }

}
