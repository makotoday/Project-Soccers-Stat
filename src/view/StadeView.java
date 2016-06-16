package view;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.input.ChaseCamera;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class StadeView extends SimpleApplication {
	
	
	private Node field_node;
	private Spatial s;
	private Node player_node;
	
	
	
	@Override
	public void simpleInitApp() {
		//Load a model from test_data (OgreXML + material + texture)
		assetManager.registerLocator("stade.zip", ZipLocator.class);
		Spatial field_geom = assetManager.loadModel("stade/soccer.obj");
		field_node = new Node("field");
		field_node.attachChild(field_geom);
		rootNode.attachChild(field_node);
		
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(-2, -10, 1));
		directionalLight.setColor(ColorRGBA.White.mult(1.3f));
		rootNode.addLight(directionalLight);
		
		//SimpleinitBox();
		SimpleInitPlayer(); 
		
		/**------------------c est le terrain et la camera--------------------------------------------------------------------------------------------------------------**/
		//change the color of the background
		viewPort.setBackgroundColor(new ColorRGBA(0.1f,0.1f,0.1f,1.0f));
		
		/*-----Camera settings-----*/
		flyCam.setEnabled(false);//Disable the default cam
		
		//Enable a chase cam for a target
		ChaseCamera chaseCam = new ChaseCamera(cam,field_geom,inputManager);
		chaseCam.setDragToRotate(true); //activate the windowed input behaviour
		
		//Parameterize the camera motion
		chaseCam.setInvertVerticalAxis(true);
		chaseCam.setRotationSpeed(10.0f);
		chaseCam.setMinVerticalRotation( 0.0001f);
		chaseCam.setMaxVerticalRotation((float) Math.PI/2);
		//chaseCam.setDefaultVerticalRotation((float) Math.PI/2);
		chaseCam.setMinDistance(7.5f);
		chaseCam.setMaxDistance(30.0f);
		
		
		
		
		
	}
	
	
		
	
	public void SimpleInitPlayer(){
		player_node=new Node("player"); 
		Spatial []play= new Spatial[15]; 
		Material mat=new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md"); 
		mat.setColor("Color", ColorRGBA.Cyan);
		float xpos,ypos; 
		xpos=0; ypos=0; 
		for(int i=0; i<15; i++){
			Spatial s=assetManager.loadModel("stade/player.obj"); 
			s.setMaterial(mat);
			play[i]=s; 
			//play[i].setLocalTranslation(xpos, 1, ypos);
			player_node.attachChild(play[i]); 
			rootNode.attachChild(player_node); 
			//xpos=xpos+1.0f; ypos=ypos+1.0f; 
		}
	}
	
	
}
