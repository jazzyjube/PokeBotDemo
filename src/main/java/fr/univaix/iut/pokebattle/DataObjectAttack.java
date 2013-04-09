package fr.univaix.iut.pokebattle;

public class DataObjectAttack {
    private String niveau;
    private String nom;
    private String puissance;
    private String precision;
    private int pp;

    public DataObjectAttack(String niveau, String nom, String puissance, String precision, 
                            String pp) {
        this.niveau = niveau;
        this.nom = nom;
        this.puissance = puissance;
        this.precision = precision;
        this.pp = Integer.parseInt(pp);
    }

    @Override
    public String toString() {
        return "DataObjectAttack{" +
                "niveau='" + niveau + '\'' +
                ", nom='" + nom + '\'' +
                ", puissance=" + puissance +
                ", precision=" + precision +
                ", pp=" + pp +
                '}';
    }

	public String getNiveau() {
		return niveau;
	}

	public String getNom() {
		return nom;
	}

	public String getPuissance() {
		return puissance;
	}

	public String getPrecision() {
		return precision;
	}

	public int getPp() {
		return pp;
	}
	
}
