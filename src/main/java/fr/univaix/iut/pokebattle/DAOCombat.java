package fr.univaix.iut.pokebattle;

import java.util.List;

public interface DAOCombat extends DAO<Combat, Integer>{
	
	public List<Combat> findByPoke(Pokemon poke);
	public Pokemon findWinner(Integer numCombat);

}
