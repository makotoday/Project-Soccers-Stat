package main_mi_temps;

public class Joueur {
	
	private int tag_id; //numero du capteur associé au joueur
	private float speed;//vitesse du joueur
	private float direction;//direction de déplacement
	private Position posJoueur;
	private StatistiqueInfo statistique;
	
	Joueur(int tag, float speed, float direct, Position position, StatistiqueInfo stat)
	{
		this.tag_id = tag;
		this.speed = speed;
		this.direction = direct;
		this.posJoueur = position;
		this.statistique = stat;
	}
	
	public static void main(String[] args){
		
	}
	
	@Override
	public String toString()
	{
		String infoJoueur = new String();
		infoJoueur = infoJoueur.concat("numero capteur : "+tag_id+"\n");
		infoJoueur = infoJoueur.concat("vitesse : "+speed+"\n");
		infoJoueur = infoJoueur.concat("diretionCourse : "+direction+"\n");
		infoJoueur = infoJoueur.concat(posJoueur.toString()+"\n");
		infoJoueur = infoJoueur.concat(statistique.toString()+"\n");
		return infoJoueur;
	}
	
	
}
