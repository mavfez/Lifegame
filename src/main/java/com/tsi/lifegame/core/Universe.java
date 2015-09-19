package com.tsi.lifegame.core;

/** 
	This class represent the universe in life's game. This class receives a symbol that represent an alive cell and 
	a symbol that represent a dead cell, in the same way this class receives an array of cells previously filled as a seed
	of the game, after that, just call tick method in a infinite cycle.
*/
public class Universe{
	
	private Cell[][] arrayInitialPatternCells;
		
	/** 
		Create a universe.
	*/
	public Universe()
	{
		 
	}			
	
	/** 
		This method validate whether any live cell with fewer than two live neighbours dies, 
		as if caused by under-population.
		@param obCell Cell to validate
	*/
	private void cellWithFewerThanTwoLiveNeighboursDies(Cell obCell){
		if(obCell!=null){
			int neighboursNumbers = obCell.getNeighboursNumbers();
			if(neighboursNumbers < 2){
				obCell.setAlive(false);
			}
		}
	}
	
	/** 
		This method validate whether any live cell with two or three 
		live neighbours lives on to the next generation.
		@param obCell Cell to validate
	*/
	private void cellWithTwoOrThreeLiveNeighboursLives(Cell obCell){
		if(obCell!=null){
			int neighboursNumbers = obCell.getNeighboursNumbers();
			if(neighboursNumbers >= 2 && neighboursNumbers <= 3){
				obCell.setAlive(true);
			}
		}
	}
	
	/** 
		This method validate whether any live cell with more than three live neighbours dies, 
		as if by overcrowding..
		@param obCell Cell to validate
	*/
	private void cellWithMoreThanThreeLiveNeighboursDies(Cell obCell){
		if(obCell!=null){
			int neighboursNumbers = obCell.getNeighboursNumbers();
			if(neighboursNumbers > 3){
				obCell.setAlive(false);
			}
		}
	}
	
	/** 
		This method validate whether any dead cell with exactly three live neighbours becomes a live cell,
		as if by reproduction.
		@param obCell Cell to validate
	*/
	private void cellWitThreeLiveNeighboursBecomesALiveCell(Cell obCell){
		if(obCell!=null){
			int neighboursNumbers = obCell.getNeighboursNumbers();
			if(neighboursNumbers == 3){
				obCell.setAlive(true);
			}
		}
	}	
	
	/** 
		Method that set the seed of cells with the game will start
		@param arrayInitialPatternCells array of initials cells
	*/
	public void setArrayInitialPatternCells(Cell[][] arrayInitialPatternCells){
		this.arrayInitialPatternCells = arrayInitialPatternCells;
	}
		
	
	/**
		This method apply the rules and change state of each one cell in the grid
	*/
	public void tick(){
							
			int rowBoundary = arrayInitialPatternCells.length;
			int columnBoundary = arrayInitialPatternCells[0].length;
					
			for (int f=0; f<rowBoundary; ++f)
			{
				for (int c=0; c<columnBoundary; ++c)
				{
					Cell currentCell = arrayInitialPatternCells[f][c];
					int neighboursNumbers = this.countNeighboursNumbers(f,c);
					currentCell.setNeighboursNumbers(neighboursNumbers);
				}
			}
			
			for (int f=0; f<rowBoundary; ++f)
			{
				for (int c=0; c<columnBoundary; ++c)
				{
					Cell currentCell = arrayInitialPatternCells[f][c];
					if(currentCell.isAlive()){
						this.cellWithFewerThanTwoLiveNeighboursDies(currentCell);
						
						this.cellWithTwoOrThreeLiveNeighboursLives(currentCell);
						
						this.cellWithMoreThanThreeLiveNeighboursDies(currentCell);
						
					}else{
						this.cellWitThreeLiveNeighboursBecomesALiveCell(currentCell);
					}
				}
			}
	}
									
	/**
	 This method return the live neighbours number of a cell
	 @param rowCell the row of cell, position in grid.	 
	 @param columnCell the column of cell, position in grid.
	 @return int live neighbours number	
	*/
	private int countNeighboursNumbers(int rowCell, int columnCell){
		int neighboursNumbers = 0;
		
		int rowBoundary = arrayInitialPatternCells.length;
		int columnBoundary = arrayInitialPatternCells[0].length;
		
		//get top neighbour 
		int rowCell_TopNeighbour = rowCell-1;
		if(rowCell_TopNeighbour >= 0){
			Cell tCell = arrayInitialPatternCells[rowCell_TopNeighbour][columnCell];
			if(tCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
			}
		}
										
		//get down neighbour 
		int rowCell_DownNeighbour = rowCell+1;
		if(rowCell_DownNeighbour < rowBoundary){
			Cell dCell = arrayInitialPatternCells[rowCell_DownNeighbour][columnCell];
			if(dCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
				//System.out.println("down neighbour ");
			}
		}
												
		//get right neighbour 
		int columnCell_RightNeighbour = columnCell+1;
		if(columnCell_RightNeighbour < columnBoundary){
			Cell rCell = arrayInitialPatternCells[rowCell][columnCell_RightNeighbour];
			if(rCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
			}
		}
							
		//get left neighbour 
		int columnCell_LeftNeighbour = columnCell-1;
		if(columnCell_LeftNeighbour >= 0){
			Cell lCell = arrayInitialPatternCells[rowCell][columnCell_LeftNeighbour];
			if(lCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
			}
		}
								
		//get right-top neighbour
		int columnCell_RighTopNeighbour = columnCell+1;		
		int rowCell_RighTopNeighbour = rowCell-1;		
		if( (rowCell_RighTopNeighbour >= 0) && (columnCell_RighTopNeighbour < columnBoundary) ){
			Cell rtCell = arrayInitialPatternCells[rowCell_RighTopNeighbour][columnCell_RighTopNeighbour];
			if(rtCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
			}
		}
																		
		//get right-down neighbour
		int columnCell_RighDownNeighbour = columnCell+1;		
		int rowCell_RighDownNeighbour = rowCell+1;
		if( (rowCell_RighDownNeighbour < rowBoundary) && (columnCell_RighDownNeighbour < columnBoundary) ){
			Cell rdCell = arrayInitialPatternCells[rowCell_RighDownNeighbour][columnCell_RighDownNeighbour];
			if(rdCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
			}
		}			
						
		//get left-top neighbour 
		int columnCell_LeftTopNeighbour = columnCell-1;		
		int rowCell_LeftTopNeighbour = rowCell-1;
		if( (rowCell_LeftTopNeighbour >= 0) && (columnCell_LeftTopNeighbour >= 0) ){
			Cell ltCell = arrayInitialPatternCells[rowCell_LeftTopNeighbour][columnCell_LeftTopNeighbour];
			if(ltCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
			}
		}
									
		//get left-down neighbour 
		int columnCell_LeftDownNeighbour = columnCell-1;		
		int rowCell_LeftDownNeighbour = rowCell+1;
		if( (rowCell_LeftDownNeighbour < rowBoundary) && (columnCell_LeftDownNeighbour >= 0) ){
			Cell ldCell = arrayInitialPatternCells[rowCell_LeftDownNeighbour][columnCell_LeftDownNeighbour];
			if(ldCell.isAlive()){
				neighboursNumbers = neighboursNumbers + 1;
			}
		}
						
		return neighboursNumbers;
	}
 
}