package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;

public class PokemonOwnerCellTest {
	PokemonOwnerCell cell = new PokemonOwnerCell();

    @Test
    public void testSalutOwner() {
    	Tweet tweet = new Tweet("maitre_peter", "@sala_meche Owner ?");
        assertEquals("@maitre_peter @maitre_peter is my owner", cell.ask(tweet));
    }

    

}