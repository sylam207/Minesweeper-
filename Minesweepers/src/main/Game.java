package main;

public class Game {
    
	private Board board;
    boolean finish = false;
    boolean win = false;
   
    /*
     * Game Constructor creating a board
     * Creates a new Board for the Game class
     * Play Method uses the Board
     */
    
    public Game(){
        board = new Board();
        Play(board);
    }
    
   /*
    * Play method
    */
    
    public void Play(Board board){
       
    	// Looping through the game
    	do{
            board.show();
            finish = board.setPosition();
            
           //If the game is finish displays the win method
            if(!finish){
                board.openNeighbors();
                finish = board.win();
            }
            
        }while(!finish);
        
        /*
         * Returns true because the player is win, then we display a message of congratulations.
         * Otherwise displays lost and the amount of mines
         */
        
        if(board.win()){
            System.out.println("Congratulations, you let the 10 fields with the mines in!");
            board.showMines();
        } else {
            System.out.println("Mine! You lost!");
            board.showMines();
        }
    }
}
