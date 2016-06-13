package main_mi_temps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Read_file{
	
	private String[] array;
	private String timeString;
	
	
	public void chargement()
	{
		try{
			FileReader file = new FileReader("infoJeu.csv");
			BufferedReader bufRead = new BufferedReader(file);
			
			EnregistrementImage enregTest;
			String line = bufRead.readLine();//lecture d'une ligne
			//info joueur
			Joueur joueur;
			int idJoueur;
			float speed, direction;
			float x , y , heading;
			Position posj;
			StatistiqueInfo statj;
			
			while(line!=null){

				array = line.split(",");
				Date timeLine = lireDate(array[0]);
				enregTest = new EnregistrementImage(timeLine);
				idJoueur = Integer.parseInt(array[1]);
				x = Float.parseFloat(array[2]);		
				y = Float.parseFloat(array[3]);
				heading = Float.parseFloat(array[4]);
				posj = new Position(x,y,heading);
				direction = Float.parseFloat(array[5]);
				statj = new StatistiqueInfo(Float.parseFloat(array[6]),Float.parseFloat(array[8]));
				speed = Float.parseFloat(array[7]);
				joueur = new Joueur(idJoueur, speed, direction, posj, statj);
				enregTest.addJoueur(joueur);
				System.out.println(enregTest);
				//line = bufRead.readLine();
				line =null;
			}
			bufRead.close();
			file.close();
			}catch(IOException e){
				e.printStackTrace();
			}

		
	}
	
	public Date lireDate(String timeString)
	{
		//Create a date format to read all the dates

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timeString = timeString.substring(1, 20);
		System.out.println(timeString);
		Date timeOfLine = new Date();
		try{
			timeOfLine = df.parse(timeString);
			
		}catch(ParseException e){
			e.printStackTrace();
		}
		return timeOfLine;

	}
	
	public static void main(String[] args){
		Read_file rfile = new Read_file();
		rfile.chargement();
		
	}

}
