package fr.exia.insanevehicles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import fr.exia.insanevehicles.element.Element;
import fr.exia.insanevehicles.element.Mobile.Mobile;
import fr.exia.insanevehicles.element.Mobile.MobileElementFactory;
import fr.exia.insanevehicles.element.motionless.MotionlessElementsFactory;
import util.Utilitaires;


/**
 * <h1>The Class InsaneVehiclesGames.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class InsaneVehiclesGames {

    /** The Constant ROAD_VIEW. */
    public static final int ROAD_VIEW   = 15;

    /** The Constant ROAD_QUOTA. */
    public static final int ROAD_QUOTA  = 20;

    /** The road. */
    private Road            road;

	private Mobile voiture;

	private Mobile MACADAM;

    /**
     * Instantiates a new insane vehicles games.
     * @throws FileNotFoundException 
     */
    public InsaneVehiclesGames() throws FileNotFoundException {
       
    	// Creer la route et les element immobile
    	this.setRoad(createRoad("../res/road.txt"));
        
        // Ajouter le vehicle
        addVehicleOnTheRoad();
    }
    	
    public Road createRoad(String file) throws FileNotFoundException{
    	String realPath = this.getClass().getClassLoader().getResource(".").getPath();
    	realPath +=file;
    	File target = new File(realPath);
    	
    	Scanner input = new Scanner(target);
    	
       	int width = Integer.parseInt(input.nextLine());
    	int height = Integer.parseInt(input.nextLine());
    	
    	Road road = new Road(width, height, ROAD_VIEW, ROAD_QUOTA);
    	
    	int y = 0;
    	while(input.hasNextLine()){
    		String line = input.nextLine();
    		
    		for(int x = 0; x < width; x++){
//    			Je recupere caract a la position XY 
    			char c = line.charAt(x);
//    			Factory cree un element avec le carac donné
    			Element e = MotionlessElementsFactory.create(c);
//    			Je place l'element sur la route
    			road.setOnTheRoadXY(e, x, y);
    			
    		}
    		
    		y++;
    		
    	}
    	
    	input.close();
    	
    	return road;
    	
    }
    
    private void addVehicleOnTheRoad(){
    	
    	//Je fabrique mon objet à partir de ma factory
    	voiture = MobileElementFactory.createVehicle();
    	
    	//Je place mon vehicle sur la route
    	this.getRoad().setOnTheRoadXY(voiture, getRoad().getWidth()/2, 1);
    }

    /**
     * Play.
     */
    public final void play() {
        while(true){ 	
        	// Deplacer vehicule
        	moveY(getVehicle(), 1);
        	//afficher
        	Utilitaires.clear();
        	this.getRoad().show(0);
        	//delay
        	Utilitaires.sleep(1000);        	
        }

    }
    
    private Mobile getVehicle() {
		return voiture;
	}

	public void moveY(Mobile element, int nbrDePas){
    	Coordinates coord = getRoad().getOnTheRoad(element);
    	
    	getRoad().removeOnTheRoad(coord, MACADAM);
    	coord.addY(nbrDePas);
    	Element e =getRoad().removeOnTheRoad(coord, element);
    	
    	//TO DO implementer function + ce qui va avec!!!!!!!!!
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public final Road getRoad() {
        return this.road;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setRoad(final Road road) {
        this.road = road;
    }
}
