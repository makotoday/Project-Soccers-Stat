package main_mi_temps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Read_file{
	
	private String[] array;
	private ArrayList<EnregistrementImage> lesEnregistrements;
	private ArrayList<Date> lesDates;
	private int nbDates; //ou nombre d'enregistrements
	private MetreCarre[][] stade;
	
	public Read_file(ArrayList<EnregistrementImage> enregistrements)
	{
		lesEnregistrements = enregistrements;
		for(int x=0;x<105;x++)
		{
			for(int y=0;y<68;y++)
			{
				stade[x][y] = new MetreCarre(x,y,x+1,y+1);
			}
		}
	}
	
	
	public void chargement()
	{
		try{
			FileReader file = new FileReader("infoJeu.csv");
			BufferedReader bufRead = new BufferedReader(file);
		
			lesDates = new ArrayList<Date>();
			String line;
			//info joueur
			Joueur joueur;
			int idJoueur;
			float speed, direction;
			float x , y , heading;
			Position posj;
			StatistiqueInfo statj;
			nbDates=0;

				do{
				line = bufRead.readLine();//lecture d'une ligne
				array = line.split(",");
				Date  timeLine =lireDate(array[0]);
				lesDates.add(timeLine);
				nbDates++;
				EnregistrementImage unEnreg = new EnregistrementImage(timeLine);
					do
					{
					
					idJoueur = Integer.parseInt(array[1]);
					x = Float.parseFloat(array[2]);		
					y = Float.parseFloat(array[3]);
					heading = Float.parseFloat(array[4]);
					posj = new Position(x,y,heading);
					direction = Float.parseFloat(array[5]);
					statj = new StatistiqueInfo(Float.parseFloat(array[6]),Float.parseFloat(array[8]));
					speed = Float.parseFloat(array[7]);
					joueur = new Joueur(idJoueur, speed, direction, posj, statj);
					unEnreg.addJoueur(joueur);

					line = bufRead.readLine();
					if(line==null)break;
					array = line.split(",");
					timeLine = lireDate(array[0]);

				}while(timeLine.equals(lesDates.get(nbDates-1)));

				lesEnregistrements.add(unEnreg);
				
				//System.out.println(lesEnregistrements.get(0));
			}while(line!=null);
			bufRead.close();
			file.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		nbDates--;
	}
	
	public Date lireDate(String timeString)
	{
		//Create a date format to read all the dates
		int lengt = timeString.length();
		timeString = timeString.substring(1, lengt-1);

		if(lengt==21)//il n'y a pas de millisecondes
		{
			timeString = timeString.concat(".000");
		}else if(lengt<25)
		{
			for(int i=lengt;i<25;i++)
			{
				timeString = timeString.concat("0");
			}
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date timeOfLine = new Date();
		try{
			timeOfLine = df.parse(timeString);
			
		}catch(ParseException e){
			e.printStackTrace();
		}
		return timeOfLine;

	}
	
	public static void main(String[] args){
		ArrayList<EnregistrementImage> enregistrements = new ArrayList<EnregistrementImage>();
		Read_file rfile = new Read_file(enregistrements);
		rfile.chargement();
	}

	public ArrayList<EnregistrementImage> getLesEnregistrements() {
		return lesEnregistrements;
	}


	public int getNbDates() {
		return nbDates;
	}



}
