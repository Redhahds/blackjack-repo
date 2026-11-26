public class Partie {

    private Paquet paquet;
    private Main joueur;
    private Main croupier;

    public enum resultat {
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
        res = resultat.EN_COURS;
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
    }

    public void hitJoueur(){
        joueur.ajouterCarte(paquet.piocher());
        if(joueur.estBust()){
            res = resultat.LOSE;
        }
        else{
            res = resultat.EN_COURS;
        }
    }

    public void standJoueur(){
        if (res != resultat.EN_COURS) return;
        while (croupier.calculerScore() < 17) {
            croupier.ajouterCarte(paquet.piocher());
        }
        if(croupier.estBust()){
            res = resultat.WIN;
        }
        else{
            if(joueur.calculerScore() < croupier.calculerScore()){
                res = resultat.LOSE;
            }
            else if(joueur.calculerScore() > croupier.calculerScore()){
                res = resultat.WIN;
            }
            else{
                res = resultat.EVEN;
            }
        }
    }
}
