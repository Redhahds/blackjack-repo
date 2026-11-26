import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Création d'un nouveau paquet et création de la main du croupier et du joueur
        Paquet paquet = new Paquet();
        Main joueur = new Main();
        Main croupier = new Main();
        // lancement d'une partie
        Partie partie = new Partie(paquet,joueur,croupier);
        String rejouer = "o";
        
        while(rejouer.equals("o")){
            if(paquet.presqueVide()){
                paquet = new Paquet();
                partie.setPaquet(paquet);
                // pas besoin de remélanger ca se fait automatiquement dans partie.demarrerManche();
            }
            partie.demarrerManche();
            // tant que la partie est en cours
            while(partie.getRes() == Partie.Resultat.EN_COURS){
                System.out.println("Vos cartes : "+ joueur.getCartes());
                System.out.println("Cela vous fait un score de "+ joueur.calculerScore());
                System.out.println("Carte du croupier: "+ croupier.getCartesCroupier());
                System.out.println("Ce qui lui fait pour le moment : "+ croupier.getCartesCroupier().getPointsBase()+ "\n");
                System.out.println("Entrez p pour piocher ou r pour rester : ");
                // choix du joueur si il souhaite piocher ou non
                String choix = scanner.nextLine().trim().toLowerCase();
                // gestion du résultat
                if (choix.equals("p") || choix.equals("piocher")) {
                    partie.hitJoueur();
                } else if (choix.equals("r") || choix.equals("rester")) {
                    partie.standJoueur();
                } else {
                    System.out.println("Choix invalide, tape 'p' ou 'r'.");
                }
            }

            //gestion de l'issue de la partie en fonction des cartes piochées et de l'aléatoire liée au paquet
            Partie.Resultat issue = partie.getRes();

            switch (issue) {
                case WIN:
                    System.out.println("Vos cartes : "+ joueur.getCartes());
                    System.out.println("Cela vous fait un score final de "+ joueur.calculerScore());
                    System.out.println("Cartes du croupier après avoir pioché : "+ croupier.getCartes());
                    System.out.println("Ce qui lui fait un score final de : "+ croupier.calculerScore());
                    System.out.println("GAGNÉ !!!");
                    break;

                case LOSE:
                    System.out.println("Vos cartes : "+ joueur.getCartes());
                    System.out.println("Cela vous fait un score final de "+ joueur.calculerScore());
                    System.out.println("Cartes du croupier après avoir pioché : "+ croupier.getCartes());
                    System.out.println("Ce qui lui fait un score final de : "+ croupier.calculerScore());
                    System.out.println("Perdu !");
                    break;
            
                case EVEN:
                    System.out.println("Vos cartes : "+ joueur.getCartes());
                    System.out.println("Cela vous fait un score final de "+ joueur.calculerScore());
                    System.out.println("Cartes du croupier après avoir pioché : "+ croupier.getCartes());
                    System.out.println("Ce qui lui fait un score final de : "+ croupier.calculerScore());
                    System.out.println("Égalité chacun reprend sa mise");
                    break;

                case C_BLACKJACK:
                    System.out.println("Vos cartes : "+ joueur.getCartes());
                    System.out.println("Cela vous fait un score final de "+ joueur.calculerScore());
                    System.out.println("Cartes du croupier après avoir pioché : "+ croupier.getCartes());
                    System.out.println("Ce qui lui fait un score final de : "+ croupier.calculerScore());
                    System.out.println("Le croupier a fait un Blackjack et pas toi... Perdu!");
                    break;
                
                case J_BLACKJACK:
                    System.out.println("Vos cartes : "+ joueur.getCartes());
                    System.out.println("Cela vous fait un score final de "+ joueur.calculerScore());
                    System.out.println("Cartes du croupier après avoir pioché : "+ croupier.getCartes());
                    System.out.println("Ce qui lui fait un score final de : "+ croupier.calculerScore());
                    System.out.println("T'a fait un Blackjack bravo !!!");
                    break;
                
                case E_BLACKJACK:
                    System.out.println("Vos cartes : "+ joueur.getCartes());
                    System.out.println("Cela vous fait un score final de "+ joueur.calculerScore());
                    System.out.println("Cartes du croupier après avoir pioché : "+ croupier.getCartes());
                    System.out.println("Ce qui lui fait un score final de : "+ croupier.calculerScore());
                    System.out.println("Vous avez tous les deux fait un BlackJack, égalité chacun reprend sa mise.");
                    break;

                default:
                    System.out.println("Vos cartes : "+ joueur.getCartes());
                    System.out.println("Cela vous fait un score final de "+ joueur.calculerScore());
                    System.out.println("Cartes du croupier après avoir pioché : "+ croupier.getCartes());
                    System.out.println("Ce qui lui fait un score final de : "+ croupier.calculerScore());
                    System.out.println("On continue");;
                    break;
            }

            System.out.println("Voulez vous rejouer? : ");
            System.out.println("('o' pour Oui, 'n' pour Non ");
            rejouer = scanner.nextLine().trim().toLowerCase();
        }
       
        scanner.close(); 
    }

}
