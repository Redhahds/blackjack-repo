import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private List<Carte> cartesMain;

    public Main(){
        this.cartesMain = new ArrayList<>();
    }

    public void ajouterCarte(Carte carte){
        if(carte != null){
            cartesMain.add(carte);
        }
    }

    public void vider(){
        if(cartesMain != null){
            cartesMain.clear();
        }
    }

    public List<Carte> getCartes(){
        return Collections.unmodifiableList(cartesMain);
    }

    public boolean estBlackjack(){
        return cartesMain.size() == 2 && calculerScore() == 21;
    }

    public boolean estBust(){
        return calculerScore() > 21;
    }

    public int calculerScore(){
        int somme = 0;
        int nbAs = 0;
        for (Carte carte : cartesMain) {
            somme = somme + carte.getPointsBase();
            if(carte.getPointsBase() == 11){
                nbAs++;
            }
        }
        while(somme > 21 && nbAs > 0){
            somme = somme - 10;
            nbAs--;
        }
        return somme;
    }

}