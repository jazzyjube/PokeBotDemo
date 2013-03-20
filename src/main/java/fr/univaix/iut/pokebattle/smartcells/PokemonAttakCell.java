package fr.univaix.iut.pokebattle.smartcells;


import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;


public class PokemonAttakCell implements SmartCell {
	
    public String ask(Tweet question) {   	
    	
    	String Tweet = question.getText();
    	String Name = question.getScreenName();
    	
    	String str[] = Tweet.split(" ");
    	String adversaire = str[3];
    	String attack = str[2];
  
    	if (Tweet.contains("attack"))
    	{
    		return adversaire + " #attack " + attack + "! /cc @" + Name;
    	}
    	return null ;
    	}
}
