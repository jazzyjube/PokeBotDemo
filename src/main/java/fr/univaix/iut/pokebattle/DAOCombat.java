package fr.univaix.iut.pokebattle;

import java.util.List;

public interface DAOCombat extends DAO<Combat, Integer>{
	
	List<Combat> findByPoke(Pokemon poke);
	Pokemon findWinner(Integer numCombat);

}
