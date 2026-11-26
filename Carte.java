public class Carte {
    
    public enum Couleur {
        PIQUE("de Pique"), COEUR("de Coeur"), CARREAU("de Carreau"), TREFLE("de Trèfle");
        private final String symbole;

        Couleur(String symbole) {
            this.symbole = symbole;
        }

        public String getSymbole() {
            return symbole;
        }
    }

    public enum Valeur {
        DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), DIX(10), VALET(10), DAME(10), ROI(10), AS(11);
        private final int pointsBase;

        Valeur(int pointsBase) {
            this.pointsBase = pointsBase;
        }

        public int getPointsBase() {
            return pointsBase;
        }
    }

    private Couleur couleur;
    private Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    public int getPointsBase() {
        return valeur.getPointsBase();
    }

    public boolean estUnAs() {
        return valeur == Valeur.AS;
    }

    @Override
    public String toString() {
        return valeur.name() + " " + couleur.getSymbole();
    }
}