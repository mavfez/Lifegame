
package com.tsi.lifegame.core;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.tsi.lifegame.core.Universe;
import com.tsi.lifegame.core.Cell;
import java.lang.reflect.Method;

/** 
	This is the test class for Universe class
*/
public class UniverseTest{
	
	public UniverseTest(){
		
	}
	
	/* 
		This method test the creation of a universe of the Game of Life
	*/
	@Test
	public void createUniverse(){
		Universe obUniverse = new Universe();
		assertTrue(obUniverse instanceof Universe);
	}
	
	
	/* 
		This method test whether any live cell with fewer than two live neighbours dies, 
		as if caused by under-population.
	*/
	@Test
	public void cellWithFewerThanTwoLiveNeighboursDies(){
		Cell obCell = new Cell();
		obCell.setNeighboursNumbers(1);
		
		try{
			Object returnValue = executePrivateMethod(Universe.class, 
												  "cellWithFewerThanTwoLiveNeighboursDies", 
												  new Class[]{Cell.class}, 
												  new Cell[]{obCell});
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
				
		assertFalse(obCell.isAlive());
	}
		

	/* 
		This method test whether any live cell with two or three 
		live neighbours lives on to the next generation.
	*/
	@Test
	public void cellWithTwoOrThreeLiveNeighboursLives(){
		Cell obCell = new Cell();
		obCell.setNeighboursNumbers(2);
		
		try{
			Object returnValue = executePrivateMethod(Universe.class, 
												  "cellWithTwoOrThreeLiveNeighboursLives", 
												  new Class[]{Cell.class}, 
												  new Cell[]{obCell});
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
				
		assertTrue(obCell.isAlive());
	}
	
	/* 
		This method test whether any live cell with more than three live neighbours dies, 
		as if by overcrowding..
	*/
	@Test
	public void cellWithMoreThanThreeLiveNeighboursDies(){
		Cell obCell = new Cell();
		obCell.setNeighboursNumbers(4);
		
		try{
			Object returnValue = executePrivateMethod(Universe.class, 
												  "cellWithMoreThanThreeLiveNeighboursDies", 
												  new Class[]{Cell.class}, 
												  new Cell[]{obCell});
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
				
		assertFalse(obCell.isAlive());
	}
	
	/*
		This method test whether any dead cell with exactly three live neighbours becomes a live cell,
		as if by reproduction.
	*/
	@Test
	public void cellWitThreeLiveNeighboursBecomesALiveCell(){
		Cell obCell = new Cell();
		obCell.setAlive(false);
		obCell.setNeighboursNumbers(3);
		
		try{
			Object returnValue = executePrivateMethod(Universe.class, 
												  "cellWitThreeLiveNeighboursBecomesALiveCell", 
												  new Class[]{Cell.class}, 
												  new Cell[]{obCell});
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
				
		assertTrue(obCell.isAlive());
	}
	
	/* 
		This method permit to invoke a private method of a any class
		@param clazz Class that has the privete method to execute
		@param methodName Name of private method to execute
		@param parameterClasses List of Class's Type of the parameters of the method to execute
		@param parameters List of object of the parameters of the method to execute
	*/
	private Object executePrivateMethod(Class clazz, String methodName, 
										Class[] parameterClasses, 
										Object[] parameters) throws Exception{
        
			Method method = clazz.getDeclaredMethod(methodName, parameterClasses);
			method.setAccessible(true);
			Object instance = clazz.newInstance();
			return method.invoke(instance, parameters);
        
    }
		
}