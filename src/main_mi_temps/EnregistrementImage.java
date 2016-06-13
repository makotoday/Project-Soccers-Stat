package main_mi_temps;

import java.util.Date;

public class EnregistrementImage {
	//enregistre les informations de tout les joueurs a une date donnée
	private int maxJoueur = 12;
	private Joueur[] lesJoueurs; 
	private int indiceJoueur;
	private Date dateEnregistrement;
	
	public EnregistrementImage(Date dateImage)
	{
		this.dateEnregistrement = dateImage;
		lesJoueurs = new Joueur[maxJoueur];
		this.indiceJoueur =0;
	}
	
	public void addJoueur(Joueur nouveauJoueur)
	{
		lesJoueurs[indiceJoueur] = nouveauJoueur;
		indiceJoueur++;
	}
	
	@Override
	public String toString()
	{
		String infoEnreg  = new String();
		infoEnreg = infoEnreg.concat("date : "+dateEnregistrement.toString()+"\n");
		for(int i=0;i< indiceJoueur;i++)
		{
			infoEnreg = infoEnreg.concat("joueur "+(indiceJoueur+1)+lesJoueurs[i].toString());
		}
		return infoEnreg;
	}
	

}
