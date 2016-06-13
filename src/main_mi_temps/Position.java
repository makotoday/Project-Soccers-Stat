package main_mi_temps;

public class Position {
	private float x_pos;
	private float y_pos;
	private float heading;
	public Position(float x, float y , float head){
		x_pos = x;
		y_pos = y;
		heading = head;
	}
	@Override
	public String toString()
	{
		String position = new String("");
		position = position.concat("x : "+x_pos);
		position = position.concat("y : "+y_pos);
		position = position.concat("heading" +heading);
		
		return position;
	}
}
