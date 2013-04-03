package fr.univaix.iut.pokebattle;

import javax.persistence.*;

@Entity
public class PeutApprendre {
	
	@Id
	@ManyToOne
	@JoinColumn(name="NOM_P")
	private Pokemon Poke;
	
	@Id
	@ManyToOne
	@JoinColumn(name="NOM_A")
	private Attaque attaque;
	
	@Column(name="LEVEL")
	private int level;
	
	public PeutApprendre(){}
	
	public PeutApprendre(Pokemon poke, Attaque attaque, int level) {
		this.Poke = poke;
		this.attaque = attaque;
		this.level = level;
	}
	
	public Pokemon getPoke() {
		return Poke;
	}

	public void setPoke(Pokemon poke) {
		this.Poke = poke;
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
		return "PeutApprendre [Poke=" + Poke + ", attaque=" + attaque
				+ ", level=" + level + "]";
	}
	

}
