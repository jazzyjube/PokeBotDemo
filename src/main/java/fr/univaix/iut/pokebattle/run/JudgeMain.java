package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.JudgeBot;

public class JudgeMain {
	public static void main(String[] args) {
        BotRunner.runBot(new JudgeBot(), "twitter4judge.properties"); // a changer
    }
}
