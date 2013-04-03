package fr.univaix.iut.pokebattle;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Pokemon.FIND_ALL, query = "SELECT p FROM Pokemon p"),
        @NamedQuery(name = Pokemon.FIND_BY_TYPE, query = "SELECT p FROM Pokemon p WHERE p.type1 = :ftype"),
	@NamedQuery(name = Pokemon.FIND_BY_NAME, query = "SELECT p FROM Pokemon p WHERE p.nomReelPoke = :pname")
})
public class Pokemon {
	
	 public static final String FIND_BY_TYPE = "findPokemonByType";
	 public static final String FIND_ALL = "findAllPokemon";
	 public static final String FIND_BY_NAME = "findByPokeName";
	 
	 @Id
	 @Column(name = "NOM_P")
   String nomP;
	 
	 @Column(name = "NOM_D")
   String nomD;
	 
	 @Column(name="CRI")
	 String cri;
	 
	@Column(name = "PVMAX")
	 int pvMax;
	 
	 @Column(name="PVRESTANT")
	 int pvRestant;
	 
	 @Column(name="XP")
	 int xp;
	 
	 @Column(name="LVL")
	 int lvl;
	 
	 @Enumerated(EnumType.STRING)
	    private Type type1;

	    @Enumerated(EnumType.STRING)
	    private Type type2;
	    
	    @Column(name="LOCALISATION")
		 String localisation;
	    
	 @Column(name="NOM_REEL_P")
	 String nomReelPoke;

public String getNomReelPoke() {
	return nomReelPoke;
}

public void setNomReelPoke(String nomReelPoke) {
	this.nomReelPoke = nomReelPoke;
}

public String getLocalisation() {
			return localisation;
		}

		public void setLocalisation(String localisation) {
			this.localisation = localisation;
		}

public Type getType1() {
			return type1;
		}

		public void setType1(Type type1) {
			this.type1 = type1;
		}

		public Type getType2() {
			return type2;
		}

		public void setType2(Type type2) {
			this.type2 = type2;
		}

public Pokemon() {
     // TODO Auto-generated constructor stub
   }    
     
public String getCri() {
	return cri;
}

public void setCri(String cri) {
	this.cri = cri;
}

public Pokemon(String nomP, String nomD, String cri, int pvMax,
			int pvRestant, int xp, int lvl, Type type1, Type type2, String localisation) {
		super();
		this.nomP = nomP;
		this.nomD = nomD;
		this.cri = cri;
		this.pvMax = pvMax;
		this.pvRestant = pvRestant;
		this.xp = xp;
		this.lvl = lvl;
		this.type1 = type1;
		this.type2 = type2;
		this.localisation = localisation;
	}

@Override
public String toString() {
	return "Pokemon [nomP=" + nomP + ", nomD=" + nomD + ", cri=" + cri
			+ ", pvMax=" + pvMax + ", pvRestant=" + pvRestant + ", xp=" + xp
			+ ", lvl=" + lvl + ", type1=" + type1 + ", type2=" + type2
			+ ", localisation=" + localisation + "]";
}

public String getNomP() {
	return nomP;
}

public void setNomP(String nomP) {
	this.nomP = nomP;
}

public String getNomD() {
	return nomD;
}

public void setNomD(String nomD) {
	this.nomD = nomD;
}

public int getPvMax() {
	return pvMax;
}

public void setPvMax(int pvMax) {
	this.pvMax = pvMax;
}

public int getPvRestant() {
	return pvRestant;
}

public void setPvRestant(int pvRestant) {
	this.pvRestant = pvRestant;
}

public int getXp() {
	return xp;
}

public void setXp(int xp) {
	this.xp = xp;
}

public int getLvl() {
	return lvl;
}

public void setLvl(int lvl) {
	this.lvl = lvl;
}
 

   
 }
