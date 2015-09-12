package com.tsi.lifegame.core;

/** 
	This class represent a Cell in life's game.
*/
public class Cell {
	
	private boolean alive;
	private int neighboursNumbers;
	
	public Cell(){
		this.alive = true;	
	}
	
	/** 
		This method return whether cell is alive.
		@return boolean that define whether cell is live or dead.
	*/
	public boolean isAlive(){
		return alive;
	}
	
	/** 
		This method permit set whether a cell live or dead
		@param alive boolean parameter that define whether cell is live or dead
	*/
	public void setAlive(boolean alive){
		this.alive = alive;
	}
	
	/** 
		This method return the cell's neighbours number.
		@return neighboursNumbers numers of neighbours
	*/
	public int getNeighboursNumbers(){
		return neighboursNumbers;
	}
	
	/** 
		This method permit set the cell's neighbours number.
		@param neighboursNumbers numers of neighbours
	*/
	public void setNeighboursNumbers(int neighboursNumbers)
	{
		this.neighboursNumbers = neighboursNumbers;
	}
		
}