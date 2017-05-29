package util;

public class Utilitaires {
    /**
     * 
     * @param delay En millis
     */
    public static void sleep(long delay){ 
    	try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
    	
    }

	public static void clear() {
		// TODO Auto-generated method stub
		int repeat =50;
		
		while (repeat-- >0 ){
			System.out.println();
		}
	}
    
    
    
}
