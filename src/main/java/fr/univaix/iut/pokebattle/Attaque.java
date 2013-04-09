package fr.univaix.iut.pokebattle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attaque {
	
	@Id
	@Column(name="NOM_A")
	private String nomA;
	
	@Column(name="PPMAX")
	private int ppMax;

	public Attaque(){}
	public Attaque(String nomA, int ppMax) {
		super();
		this.nomA = nomA;
		this.ppMax = ppMax;
	}

	public String getNomA() {
		return nomA;
	}

	public void setNomA(String nomA) {
		this.nomA = nomA;
	}

	public int getPpMax() {
		return ppMax;
	}

	public void setPpMax(int ppMax) {
		this.ppMax = ppMax;
	}

	@Override
	public String toString() {
		return "Attaque [nomA=" + nomA + ", ppMax=" + ppMax + "]";
	}

}
