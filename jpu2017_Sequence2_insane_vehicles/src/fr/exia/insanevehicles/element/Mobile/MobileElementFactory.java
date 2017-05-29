package fr.exia.insanevehicles.element.Mobile;

/**
 * <h1>A factory for creating MobileElements objects.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class MobileElementFactory {

    /** The Constant VEHICLE. */
    private static final MyVehicles VEHICLE = new MyVehicles();

    /**
     * Creates a new vehicle object.
     *
     * @return the motionless element
     */
    public static MyVehicles createVehicle() {
        return VEHICLE;
    }

}
