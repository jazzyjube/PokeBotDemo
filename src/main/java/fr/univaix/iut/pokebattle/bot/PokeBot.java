package fr.univaix.iut.pokebattle.bot;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.PokemonAnswerCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonAttakCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCatchCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonInfosCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
	private final SmartCell[] smartCells = new SmartCell[]{
            new PokemonAnswerCell(),

            new PokemonCatchCell(),

            new PokemonOwnerCell(),
            
            new PokemonAttakCell(),
            
            new PokemonInfosCell()

    };

    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     * @throws TwitterException 
     */

	@Override

    public String ask(Tweet question) throws TwitterException {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null)
            {
                return answer;
            }
        }
        return null;
    }

}
