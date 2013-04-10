package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonOwnerCell implements SmartCell {

	public String ask(Tweet question) {

		String tweet = question.getText();
		String name = question.getScreenName();

		if (tweet.contains("Owner")) {
			String str[] = tweet.split(" ");
			String nompoke = str[0].substring(1);

			EntityManager em = DAOFactoryJPA.getEntityManager();
			
			Pokemon poke = em.find(Pokemon.class, nompoke);
			
			if (poke.getNomD() == null) {
				return "@" + name + " No owner" + " #PokeBattle";
			}
			return "@" + name + " @" + poke.getNomD() + " is my owner"
					+ " #PokeBattle";
		}
		return null;
	}
}
