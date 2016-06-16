package view;
//ajouter une 
import javax.swing.JFileChooser;

public class Repertoire extends JFileChooser {
	
	
	private String path; 
	
	
	
	public Repertoire(){
		super(FindCurrentDir()); 
		if(this.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			path=this.getSelectedFile().getAbsolutePath(); 
		}
		
	}
	public static  String FindCurrentDir(){
		return System.getProperty("user.dir"); //user.dir pour recuperer le chemin d repertoire courrent 
	}
	public static void main(String [] arg){
		
		Repertoire choix=new Repertoire(); 
		System.out.println(choix.getPath());
		
	}
	public String getPath(){
		return  new String(path); 
	}
	// methode retournant vrai si le string est null sinon faux;  
	public boolean isPathNUll(){
		if(path==null){
			
			return true; 
		}
		return false; 
	}
	
	
	
}
