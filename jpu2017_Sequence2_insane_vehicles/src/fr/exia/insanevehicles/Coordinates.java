package fr.exia.insanevehicles;

public class Coordinates {

	private int x;
	private int y;

	public Coordinates(){
		this(0,0);
	}

	public Coordinates(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void addY(int nbrDePas) {
		// TODO Auto-generated method stub
		
		this.y = this.y + nbrDePas;
	}
}
