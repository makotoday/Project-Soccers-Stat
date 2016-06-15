package main_mi_temps;

import java.util.ArrayList;

public class JeuMiTemps {
	private ArrayList<EnregistrementImage> enregistrements;
	private Read_file rfile;
	private MetreCarre[][] stade;
	
	public JeuMiTemps()
	{
		enregistrements = new ArrayList<EnregistrementImage>();
		stade = new MetreCarre[105][68];
		rfile = new Read_file(enregistrements,stade);
		rfile.chargement();
		System.out.println(enregistrements.get(10000).getJoueur(5).getPosition().getX_pos());
	}
	
	//recuperer nombre d'enregistrements
	public int getnombreEnregistrement()
	{
		return rfile.getNbDates();
	}
	
	//recuperer informations d'un enregistrement
	public EnregistrementImage getEnregistrement(int index)
	{
		return enregistrements.get(index);
	}
	
	//recuperer les informations d'un joueur
	public Joueur getJoueur(EnregistrementImage enreg, int numJoueur)
	{
		return enreg.getJoueur(numJoueur); 
				
	}
	
	
	
	public static void main(String[] args){

		JeuMiTemps premiere = new JeuMiTemps();
	}
	

	
}
