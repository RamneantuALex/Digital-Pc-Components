package entity.sisteme.electronice;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "")
public class SistemeElectronice {
    @Id
    private int pret;
    private String descriere;
    private boolean promotie;
    private int stoc;
    private String recenzie;

   public SistemeElectronice(){}

    public SistemeElectronice(int pret, String descriere, boolean promotie, int stoc, String recenzie) {
        this.pret = pret;
        this.descriere = descriere;
        this.promotie = promotie;
        this.stoc = stoc;
        this.recenzie = recenzie;
    }



    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public boolean isPromotie() {
        return promotie;
    }

    public void setPromotie(boolean promotie) {
        this.promotie = promotie;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public String getRecenzie() {
        return recenzie;
    }

    public void setRecenzie(String recenzie) {
        this.recenzie = recenzie;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sisteme_Electronice{")
                .append("pret=").append(pret)
                .append(", descriere='").append(descriere).append('\'')
                .append(", promotie=").append(promotie)
                .append(", stoc=").append(stoc)
                .append(", recenzie='").append(recenzie).append('\'')
                .append('}');
        return builder.toString();
    }


}
