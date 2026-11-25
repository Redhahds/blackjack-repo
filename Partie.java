public class Partie {

    private Paquet paquet;
    private Main joueur;
    private Main croupier;

    private enum resultat {
        EN_COURS, WIN, LOSE, EVEN
        
    }
    private resultat res = resultat.EN_COURS;

    public Partie(Paquet paquet, Main joueur, Main croupier){
        this.paquet = paquet;
        this.joueur = joueur;
        this.croupier = croupier;
    }

    public resultat getRes(){ 
        return res;
    }

    public void demarrerManche(){
        joueur.vider();
        croupier.vider();
        paquet.melanger();
        for(int i = 0; i<2; i++){
            croupier.ajouterCarte(paquet.piocher());
            joueur.ajouterCarte(paquet.piocher());
        }
        if(croupier.estBlackjack() && joueur.estBlackjack()){
            res = resultat.EVEN;
        }
        else if(croupier.estBlackjack()){
            res = resultat.LOSE;
        }
        else if(joueur.estBlackjack()){
            res = resultat.WIN;
        }
        else{
            suite();
        }
    }

    public void suite(){

    }
}
