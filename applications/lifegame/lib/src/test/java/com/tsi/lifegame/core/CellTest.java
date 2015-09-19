package com.tsi.lifegame.core;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.tsi.lifegame.core.Cell;

/** 
	This is the test class for Cell class
*/
public class CellTest {
	
	public CellTest(){
			
	}
		
	/** 
		This method test the creation of a cell of the Game of Life 
	*/
	@Test
	public void createCell(){
		Cell obCell = new Cell();
		assertTrue(obCell instanceof Cell);
	}
	
	/** 
		This method test wether a cell is alive. 
		Each of which is in one of two possible states, alive or dead.
	*/
	@Test
	public void isCellAlive(){
		Cell obCell = new Cell();
		assertTrue(obCell.isAlive());
	}

	
}