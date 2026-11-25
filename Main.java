import java.util.ArrayList;
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

}