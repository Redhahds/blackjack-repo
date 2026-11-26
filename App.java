public class App {
    public static void main(String[] args) {
        Paquet paquet = new Paquet();
        Main joueur = new Main();
        Main croupier = new Main();
        
        Partie partie = new Partie(paquet,joueur,croupier);
        partie.demarrerManche();
        

        // while(partie.getRes() == Partie.resultat.EN_COURS){
            System.out.println("Vos cartes : \n");
            System.out.println(joueur.getCartes());
            System.out.println("Carte du croupier: "+ croupier.getCartesCroupier());
        // }

        // Partie.resultat issue = partie.getRes();

        // switch (issue) {
        //     case WIN:
        //         System.out.println("GAGNÉ !!!");
        //         break;

        //     case LOSE:
        //         System.out.println("Perdu !");
        //         break;
        
        //     case EVEN:
        //         System.out.println("Égalité chacun reprend sa mise");
        //         break;

        //     default:
        //         System.out.println("On continue");;
        //         break;
        // }
    }
}
