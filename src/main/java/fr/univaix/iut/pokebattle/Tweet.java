package fr.univaix.iut.pokebattle;

public class Tweet {
    private String text;
    private String screenName;

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet(String screenName, String text) {
        this.screenName = screenName;
        this.text = text;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getText() {
        return text;
    }
    
    public String getSubstring(int i) {
    	String str[] = this.text.split(" ");
    	return str[i].substring(1);
    }
}