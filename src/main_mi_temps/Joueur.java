package main_mi_temps;

public class Joueur {
	
	private int tag_id; //numero du capteur associ� au joueur
	private float speed;//vitesse du joueur
	private float direction;//direction de d�placement
	private Position posJoueur;
	private StatistiqueInfo statistique;
	
	public Joueur(int tag, float speed, float direct, Position position, StatistiqueInfo stat)
	{
		this.tag_id = tag;
		this.speed = speed;
		this.direction = direct;
		this.posJoueur = position;
		this.statistique = stat;
	}
	
	public Joueur(Joueur j)
	{
		this.tag_id = j.getTag();
		this.posJoueur = j.getPosition();
		this.speed = j.getspeed();
		this.direction = j.getDirection();
		j.statistique = this.getStatistique();
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
	//retourne l'identifiant capteur du joueur
	public int getTag(){
		return new Integer(this.tag_id); 
	}
	public float getspeed(){
		return new Float(this.speed); 
	}
	public float getDirection(){
		return new Float(this.direction); 
	}
	public Position getPosition(){
		return this.posJoueur; 
	}

	public StatistiqueInfo getStatistique() {
		return statistique;
	}

}
