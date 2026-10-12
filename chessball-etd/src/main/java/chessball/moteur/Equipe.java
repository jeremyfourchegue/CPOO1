package chessball.moteur;
import java.util.ArrayList;
import java.util.List;

public final class Equipe {
    public static final int EFFECTIF = 5;
    private  Couleur couleur;
    private  List<Piece> lstpieces;
    public Equipe(Couleur couleur){
        this.couleur=couleur;
        lstpieces= new ArrayList<>();
    }


    public Couleur couleur(){
        return  couleur;
    }
    public List<Piece> pieces(){
        return  lstpieces;
    }
    public void ajouter(Piece piece){
        if(!lstpieces.contains(piece)&&piece.equipe()==null){
            lstpieces.add(piece);
            piece.setEquipe(this);
        }
        else if(piece.equipe()!=null){
           throw new IllegalStateException("La pièce appartient déjà à une autre équipe.");
        }
        else if(lstpieces.size()>=EFFECTIF){
           throw new IllegalStateException("Il y a déja le nb de joueur");
        }
    }
}