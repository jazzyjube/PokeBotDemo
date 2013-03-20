package fr.univaix.iut.pokebattle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using SmartCells properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() {
    	assertEquals("Sala Sala, Salamèèèèèèche", pokeBot.ask(new Tweet("Salut")));
        assertEquals(null, pokeBot.ask(new Tweet("This is not a question.")));
    }
}
