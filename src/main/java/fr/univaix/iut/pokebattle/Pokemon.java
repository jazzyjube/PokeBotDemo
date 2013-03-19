package fr.univaix.iut.pokebattle;

import javax.persistence.*;

@Entity
 public class Pokemon {
	 
	 @Id
	 @Column(name = "NOM_P")
   String nomP;
	 
	 @Column(name = "NOM_D")
   String nomD;
	 
	 @Column(name = "PVMAX")
	 int pvMax;
	 
	 @Column(name="PVRESTANT")
	 int pvRestant;
	 
	 @Column(name="XP")
	 int xp;
	 
	 @Column(name="LVL")
	 int lvl;
   public Pokemon() {
     // TODO Auto-generated constructor stub
   }    
     
   public Pokemon(String nomP, String nomD, int pvMax, int pvRestant, int xp, int lvl) {
     super();
     this.nomP = nomP;
     this.nomD = nomD;
     this.pvMax = pvMax;
     this.pvRestant = pvRestant;
     this.xp = xp;
     this.lvl = lvl;
     
   }

@Override
public String toString() {
	return "Pokemon [nomP=" + nomP + ", nomD=" + nomD + ", pvMax=" + pvMax
			+ ", pvRestant=" + pvRestant + ", xp=" + xp + ", lvl=" + lvl + "]";
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