public class Partie {

    private Paquet paquet;
    private Main joueur;
    private Main croupier;

    public enum Resultat {
        EN_COURS, WIN, LOSE, EVEN, C_BLACKJACK, J_BLACKJACK, E_BLACKJACK
    }
    private Resultat res = Resultat.EN_COURS;

    public Partie(Paquet paquet, Main joueur, Main croupier){
        this.paquet = paquet;
        this.joueur = joueur;
        this.croupier = croupier;
    }

    public Resultat getRes(){ 
        return res;
    }

    public void demarrerManche(){
        res = Resultat.EN_COURS;
        joueur.vider();
        croupier.vider();
        paquet.melanger();
        for(int i = 0; i<2; i++){
            croupier.ajouterCarte(paquet.piocher());
            joueur.ajouterCarte(paquet.piocher());
        }
        if(croupier.estBlackjack() && joueur.estBlackjack()){
            res = Resultat.E_BLACKJACK;
        }
        else if(croupier.estBlackjack()){
            res = Resultat.C_BLACKJACK;
        }
        else if(joueur.estBlackjack()){
            res = Resultat.J_BLACKJACK;
        }
    }

    public void setPaquet(Paquet paquet) {
        this.paquet = paquet;
    }

    public void hitJoueur(){
        joueur.ajouterCarte(paquet.piocher());
        if(joueur.estBust()){
            res = Resultat.LOSE;
        }
        else{
            res = Resultat.EN_COURS;
        }
    }

    public void standJoueur(){
        if (res != Resultat.EN_COURS) return;
        while (croupier.calculerScore() < 17) {
            croupier.ajouterCarte(paquet.piocher());
        }
        if(croupier.estBust()){
            res = Resultat.WIN;
        }
        else{
            if(joueur.calculerScore() < croupier.calculerScore()){
                res = Resultat.LOSE;
            }
            else if(joueur.calculerScore() > croupier.calculerScore()){
                res = Resultat.WIN;
            }
            else{
                res = Resultat.EVEN;
            }
        }
    }
}
