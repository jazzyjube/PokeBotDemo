package fr.univaix.iut.pokebattle;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = Combat.FIND_ALL, query = "SELECT c FROM Combat c"),
    @NamedQuery(name = Combat.FIND_BY_POKE, query = "SELECT c " +
    		"FROM Combat c WHERE c.poke1 = :pokeko or c.poke2 = :pokeko")
})

public class Combat {
	public static final String FIND_BY_POKE = "findCombatByPoke";
    public static final String FIND_ALL = "findAllCombat";
	@Id
	 @Column(name = "NUM_COMBAT")
  Integer numCombat;
	
	@Column(name = "POKE_1")
	  String poke1;
	
	@Column(name = "POKE_2")
	  String poke2;
	
	@Column(name = "WINNER")
	  String winner;
	
	public Combat(){}
	
	public Combat(int numCombat, String poke1, String poke2, String winner) {
		super();
		this.numCombat = numCombat;
		this.poke1 = poke1;
		this.poke2 = poke2;
		this.winner = winner;
	}

	public int getNumCombat() {
		return numCombat;
	}

	public void setNumCombat(int numCombat) {
		this.numCombat = numCombat;
	}

	public String getPoke1() {
		return poke1;
	}

	public void setPoke1(String poke1) {
		this.poke1 = poke1;
	}

	public String getPoke2() {
		return poke2;
	}

	public void setPoke2(String poke2) {
		this.poke2 = poke2;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Combat [numCombat=" + numCombat + ", poke1=" + poke1
				+ ", poke2=" + poke2 + ", winner=" + winner + "]";
	}

	

}
