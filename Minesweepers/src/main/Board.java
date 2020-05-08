package main;

import java.util.Random;
import java.util.Scanner;

public class Board {
	   
		/*
	     * Mine variable to set up the mine
	     * Board variable to draw the board
	     */
		
		private int[][] mines;
	    private char[][] board;
	    private int Row, Column;
	    Random random = new Random();
	    Scanner input = new Scanner(System.in);
	    
	   /*
	    * Board Constructor
	    * Instantiates the board and mines
	    * 10x10 Board
	    */
	    
	    public Board (){
	        mines = new int[12][12];
	        board = new char[12][12];
	        startMines();
	        randomMines();
	        fillTips();
	        startBoard();
	    }
	    
	    
	    /*
	     * If the number of cells unmarked is 10 on the board
	     * Then display that the game is over
	     * Method returns true
	     */
	    public boolean win(){
	        int count=0;
	       
	        for(int Row = 1 ; Row < 11 ; Row++)
	          
	        	for(int column = 1 ; column < 11 ; column++)
	                
	        		if(board[Row][column]=='_')
	                    count++;
	        
	        if(count == 10)
	            return true;
	        else
	            return false;                
	    }
	   
	    /*
	     * Checks all the neighboring cells of the board of mines, except if these territories are 
	     * located on rows 9 or 0, or 0 or 9 columns. 
	     * During the check, we check if the neighbor has a mine, and if we do not have 
	     * this house show on the board of characters:
	     */
	    
	    public void openNeighbors(){
	        for(int i=-1 ; i<2 ; i++)
	            for(int j=-1 ; j<2 ; j++)
	                //Transform into character, the numbers are in decimal base
	            	//Determines the character representation for a specific digit in the specified radix
	            	if((mines[Row+i][Column+j] != -1) && (Row != 0 && Row != 11 && Column != 0 && Column != 11) )
	                    board[Row+i][Column+j]= Character.forDigit(mines[Row+i][Column+j], 10);
	        
	    }
	    
	   /*
	    * Returns what exists in the block when we pass the row and column.
	    */
	    
	    
	    public int getPosition(int Row, int Column){
	        return mines[Row][Column];
	    }
	    
	   /*
	    * Returns 'true' if you lose (if there is a mine where you played) and 'false', 
	    * if there is not a mine in the location you chose.
	    */
	    
	    public boolean setPosition(){
	            
	           while((Row< 1 || Row > 10 || Column < 1 || Column > 10) || (board[Row][Column] != '_') ) {
	              
	        	   try {
	            	  
	            	System.out.print("\nLine: "); 
	                Row = input.nextInt();
	                System.out.print("Column: "); 
	                Column = input.nextInt();
	                
	                if((board[Row][Column] != '_') && ((Row < 11 && Row > 0) && (Column < 11 && Column > 0)))
	                    System.out.println("Field already shown");
	                
	         //catches the exception that input must be between 1 and 10
	                } catch (ArrayIndexOutOfBoundsException e) {
	            	  System.out.println("Board length cannot exceed 10");
	            }
	              }
	            
	            if(getPosition(Row, Column)== -1)
	                return true;
	            else
	                return false;
	           
	    }
	    
	    /*
	     * Displaying the Row and Column numbers for the board.
	     * Displays the whole Board of characters formatted.
	     */
	    
	    public void show(){
	        System.out.println("\n     Rows");
	        for(int Line = 10 ; Line > 0 ; Line--){
	            System.out.print("       "+Line + " ");
	            
	            for(int Column = 1 ; Column < 11 ; Column++){
	                    System.out.print("   "+ board[Line][Column]);
	            }
	                
	            System.out.println();
	        }
	            
	        System.out.println("\n            1   2   3   4   5   6   7   8   9   10");
	        System.out.println("                      Columns");
	        
	    }
	    
	   /*
	    * Filling the Markings 
	    */
	    
	    public void fillTips(){
	        for(int line=1 ; line < 11 ; line++)
	            for(int column=1 ; column < 11 ; column++){
	                
	            	/*
	            	 * Puts each block of the board the number of mines that exist around.
	            	 * Checking how many bombs are around the cell.
	            	 * It will check the surroundings if there is no mine.
	            	 * 
	            	 */
	                    for(int i=-1 ; i<=1 ; i++)
	                       
	                    	for(int j=-1 ; j<=1 ; j++)
	                          
	                    		if(mines[line][column] != -1)
	                               
	                    			/*
	                    			 * Check to see if mine is around, then increment the board
	                    			 * because it receives the number of mines around.
	                    			 */
	                    			 
	                    			
	                    			if(mines[line+i][column+j] == -1)
	                                    mines[line][column]++;
	                
	            }
	            
	    }
	    
	   /*
	    * Showing mines if the player hits them 
	    * Marks the mines with the asterisk.
	    */
	    
	    
	    public void showMines(){
	        for(int i=1 ; i < 11; i++)
	            for(int j=1 ; j < 11; j++)
	                if(mines[i][j] == -1)
	                    board[i][j]='*';
	        
	        show();
	    }
	  
	    /*
	     * Drawing the board for the game
	     */
	    
	    public void startBoard(){
	        
	    	for(int i=1 ; i<mines.length ; i++)
	            for(int j=1 ; j<mines.length ; j++)
	                board[i][j]= '_';
	    }
	    
	   /*
	    * Initializes the mines on in the game.
	    */
	   
	    
	    public void startMines(){
	        for(int i=0 ; i<mines.length ; i++)
	            for(int j=0 ; j<mines.length ; j++)
	                mines[i][j]=0;
	    }
	    
	    /**
	     * Select 10 random locations to place the mines.
	     * Using the -1 Integer to represent the mines.
	     * The Boolean variable will loop until there are 10 different mines.
	     */
	    
	    
	    public void randomMines(){
	        boolean check;
	        int Line, Column;
	        for(int i=0 ; i<10 ; i++){
	            
	            do{
	                Line = random.nextInt(8) + 1;
	                Column = random.nextInt(8) + 1;
	                
	                if(mines[Line][Column] == -1)
	                    check=true;
	                else
	                    check = false;
	            }while(check);
	            
	            mines[Line][Column] = -1;
	        }
	    }
	}

