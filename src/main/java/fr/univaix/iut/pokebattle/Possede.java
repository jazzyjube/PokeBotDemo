package fr.univaix.iut.pokebattle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@IdClass(PossedeID.class)
@NamedQuery(name = Possede.FIND_ALL_BY_POKE, query="SELECT p.attaque FROM Possede p WHERE p.pokemon = :pokemon")
public class Possede {
	
	public static final String FIND_ALL_BY_POKE = "findAllAtk";
	@Id
	@ManyToOne
	@JoinColumn(name="NOM_P")
	private Pokemon pokemon;
	
	@Id
	@ManyToOne
	@JoinColumn(name="NOM_A")
	private Attaque attaque;
	
	@Column(name="PPRESTANT")
	int ppRestant;

	public Possede(){}
	public Possede(Pokemon pokemon, Attaque attaque, int ppRestant) {
		super();
		this.pokemon = pokemon;
		this.attaque = attaque;
		this.ppRestant = ppRestant;
	}

	@Override
	public String toString() {
		return "Possede [pokemon=" + pokemon + ", attaque=" + attaque
				+ ", ppRestant=" + ppRestant + "]";
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Attaque getAttaque() {
		return attaque;
	}

	public void setAttaque(Attaque attaque) {
		this.attaque = attaque;
	}

	public int getPpRestant() {
		return ppRestant;
	}

	public void setPpRestant(int ppRestant) {
		this.ppRestant = ppRestant;
	}
	
}
