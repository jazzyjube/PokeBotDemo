package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.PokeBot;

public class Pokemon2Main {
	public static void main(String[] args) {
        BotRunner.runBot(new PokeBot(), "twitter4jDialga.properties");
    }
}
