package nouveau.threads.exo;

public class Tirelire {

    private int solde;

    public int getSolde() {
        return solde;
    }

    private void setSolde(int solde) {
        this.solde = solde;
    }

    public void depot(int qtt){
        setSolde( getSolde() + qtt );
        System.out.println( "Argent ajouté. Nouveau solde : " + getSolde() );
    }

    public void retrait(int qtt){
        setSolde( getSolde() - qtt );

    }
}
