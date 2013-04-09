package fr.univaix.iut.pokebattle;

public class PossedeID {

	public String getPokemon() {
		return pokemon;
	}
	public void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}
	public String getAttaque() {
		return attaque;
	}
	public void setAttaque(String attaque) {
		this.attaque = attaque;
	}
	
	public PossedeID (String poke, String attak){
		
		this.attaque= attak;
		this.pokemon=poke;
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attaque == null) ? 0 : attaque.hashCode());
		result = prime * result + ((pokemon == null) ? 0 : pokemon.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		PossedeID other = (PossedeID) obj;
		if (attaque == null) {
			if (other.attaque != null)
			{
				return false;
			}
		} 
		else if (!attaque.equals(other.attaque))
		{
			return false;
		}
		if (pokemon == null) {
			if (other.pokemon != null)
			{
				return false;
			}
		} 
		else if (!pokemon.equals(other.pokemon))
		{
			return false;
		}
		return true;
	}


	private String pokemon;
	private String attaque;
	
}
