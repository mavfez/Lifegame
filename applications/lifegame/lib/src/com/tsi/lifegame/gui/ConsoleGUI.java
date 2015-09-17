package com.tsi.lifegame.gui;

import com.tsi.lifegame.core.Universe;
import com.tsi.lifegame.core.Cell;
import java.io.Console;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Properties;

public class ConsoleGUI{
	
	private static char charAlive;
	private static char charDead;
	private static Cell[][] arrayInitialPatternCells;
	
	public static void main(String[] args) {
 		 
		Console console = System.console();
		int generationNumbers = 0;
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------------------------");
		System.out.println("BIENVENIDOS AL JUEGO DE LA VIDA");
		System.out.println("---------------------------------");
		try{
			readInitialPatternSymbols();
			
			Universe obUniverse = new Universe();
			
			Cell[][] arrayInitialPatternCells = createInitialPatternFromFile();
			
			obUniverse.setArrayInitialPatternCells(arrayInitialPatternCells);
			printInitialPatternCell(arrayInitialPatternCells);
			
			do{
				generationNumbers++;
				System.out.println("GENERACION: "+generationNumbers);
				
				obUniverse.tick();
				
				delay();
				printNextGeneration(arrayInitialPatternCells);
			
			}
			while(true);
			
			
			
		}catch(Exception e){
			System.out.println("Error del sistema: "+e.getMessage());
		}
		
		
    }

	private static void readInitialPatternSymbols() throws Exception{
				   
		//Creamos un Objeto de tipo Properties
		Properties propiedades = new Properties();
			
		//Cargamos el archivo desde la ruta especificada
		propiedades.load(new FileInputStream("seed_symbols.properties"));
		 
		//Obtenemos los parametros definidos en el archivo
		String alive = propiedades.getProperty("alive");
		String dead = propiedades.getProperty("dead");
		charAlive = alive.charAt(0);
		charDead = dead.charAt(0);

	}	
	
	private static Cell[][] createInitialPatternFromFile()throws Exception{
	  int rows  =  0;
	  int columns  =  0;
	  String cadena;
      
	  //leo el archivo
	  FileReader obFileReader = new FileReader("seed.txt");
	  FileReader obFileReader2 = new FileReader("seed.txt");
      BufferedReader obBufferedReader = new BufferedReader(obFileReader);
	  BufferedReader obBufferedReader2 = new BufferedReader(obFileReader2);
      
	  //recorro el archivo y obtengo el numero de filas y columnas que tendrá la grilla del universo
	  while((cadena = obBufferedReader.readLine())!=null) {
		if(rows == 0){
			columns  =  cadena.length();
		}
		rows++; 
      }
	  obBufferedReader.close();
	  
	  Cell[][] arrayInitialPatternCells;
	  arrayInitialPatternCells = new Cell[rows][columns];
 	  	  
	  //recorro nuevamente el archivo para llenar el array del patrón inicial con las celdas
	  int totalRows  =  0;
	  while((cadena = obBufferedReader2.readLine())!=null) {
		
		//se obtiene un array de caracteres de la cadena, en otras palabras toda la cadena separada por caracteres
		char[] charArray  =  cadena.toCharArray();
		for(int i  =  0;  i < charArray.length;  i++){
			Cell obCell = new Cell();
			char currentChar = charArray[i];
			
			if(currentChar  == charDead){
				obCell.setAlive(false);
			}else if(currentChar  == charAlive){
				obCell.setAlive(true);
			}
			
			arrayInitialPatternCells[totalRows][i] = obCell;
		}
		totalRows++;
      }
      obBufferedReader2.close();
	  
	  return arrayInitialPatternCells;
	}
	
	private static void printInitialPatternCell(Cell[][] arrayInitialPatternCells){
		System.out.println("PATRON INICIAL");
		System.out.println("----------------");
		
		int filasPI = arrayInitialPatternCells.length;
		int columnasPI = arrayInitialPatternCells[0].length;
				
		for (int f=0; f<filasPI; ++f)
		{
			for (int c=0; c<columnasPI; ++c)
			{
				Cell obCell = arrayInitialPatternCells[f][c];
				if(obCell.isAlive()){
					System.out.print(charAlive+" ");
				}else{
					System.out.print(charDead+" ");
				}
			}
			System.out.println(" ");
		}
		System.out.println("");
		System.out.println("");
	}
	
	private static void printNextGeneration(Cell[][] arrayInitialPatternCells){
		int filasPI = arrayInitialPatternCells.length;
		int columnasPI = arrayInitialPatternCells[0].length;
				
		for (int f=0; f<filasPI; ++f)
		{
			for (int c=0; c<columnasPI; ++c)
			{
				Cell obCell = arrayInitialPatternCells[f][c];
				if(obCell.isAlive()){
					System.out.print("@ ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println(" ");
		}
		System.out.println("");
		System.out.println("");
	}
	
	private static void delay(){
		try {
			Thread.sleep(800);  //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}