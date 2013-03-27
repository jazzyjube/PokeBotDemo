package fr.univaix.iut.pokebattle;

import javax.persistence.Column;
import javax.persistence.Id;

public class Combat {
	@Id
	 @Column(name = "NUM_COMBAT")
  int numCombat;
	
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
