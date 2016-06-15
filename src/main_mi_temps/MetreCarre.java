package main_mi_temps;

public class MetreCarre {
	private int xdebut;
	private int ydebut;
	private int xfin;
	private int yfin;
	int maxJoueur = 16;
	int[] nbPassage;//compte le passage pour chaque joueur
	
	MetreCarre(int xdeb,int ydeb,int xf,int yf)
	{
		this.xdebut = xdeb;
		this.ydebut =ydeb;
		this.xfin = xf;
		this.yfin = yf;
		this.nbPassage = new int[maxJoueur];
		for(int i=0;i<maxJoueur;i++)
		{
			nbPassage[i] =0;
		}
	}
}
