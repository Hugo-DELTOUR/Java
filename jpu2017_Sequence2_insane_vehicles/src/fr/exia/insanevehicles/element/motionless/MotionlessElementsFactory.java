package fr.exia.insanevehicles.element.motionless;

import fr.exia.insanevehicles.element.Element;

/**
 * <h1>A factory for creating MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class MotionlessElementsFactory {

    /** The Constant DITCH. */
    private static final DitchNormal    DITCH_NORMAL    = new DitchNormal();

    private static final DitchLeft    DITCH_LEFT    = new DitchLeft();
    
    private static final DitchRight    DITCH_RIGHT    = new DitchRight();
    /** The Constant MACADAM. */
    private static final Macadam  MACADAM  = new Macadam();

    /** The Constant OBSTACLE. */
    private static final Obstacle OBSTACLE = new Obstacle();

    /** The Constant MEDIAN. */
    private static final Median MEDIAN = new Median();
    /**
     * Creates a new ditch object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchNormal() {
        return DITCH_NORMAL;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMacadam() {
        return MACADAM;
    }

    public static MotionlessElement createDitchLeft() {
        return DITCH_LEFT;
    }
    
    public static MotionlessElement createDitchRight() {
        return DITCH_RIGHT;
    }
    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }
    
    public static MotionlessElement createMedian() {
        return MEDIAN;
    }

	public static Element create(char c) {
		// TODO Pour demain !!!!!
		switch(c){
		case ' ':
			return createMacadam();
		case '^':
			return createMedian();
		case '|':
			return createDitchNormal();
		case '/':
			return createDitchRight();
		case 'X' :
			return createObstacle();
		case '\\':
			return createDitchLeft();
		}
		throw new IllegalArgumentException("Invalid caracter "+c);
	}

}
