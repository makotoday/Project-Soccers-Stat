package main_mi_temps;

public class StatistiqueInfo {
	
	private float totalDistance;
	private float energie;
	
	public StatistiqueInfo(float distance, float energie)
	{
		this.totalDistance = distance;
		this.energie = energie;
	}
	
	@Override
	public String toString()
	{
		String stat = new String("statistique :\n");
		stat = stat.concat("distance parcourue : "+totalDistance);
		stat = stat.concat("energie : "+energie);
		return stat;
	}
	
}
