package fr.univaix.iut.pokebattle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PeutApprendre {
	
	@Id
	@ManyToOne
	@JoinColumn(name="NOM_P")
	private Pokemon poke;
	
	@Id
	@ManyToOne
	@JoinColumn(name="NOM_A")
	private Attaque attaque;
	
	@Column(name="LEVEL")
	private int level;
	
	public PeutApprendre(){}
	
	public PeutApprendre(Pokemon poke, Attaque attaque, int level) {
		this.poke = poke;
		this.attaque = attaque;
		this.level = level;
	}
	
	public Pokemon getPoke() {
		return poke;
	}

	public void setPoke(Pokemon poke) {
		this.poke = poke;
	}

	public Attaque getAttaque() {
		return attaque;
	}

	public void setAttaque(Attaque attaque) {
		this.attaque = attaque;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "PeutApprendre [Poke=" + poke + ", attaque=" + attaque
				+ ", level=" + level + "]";
	}
	

}
