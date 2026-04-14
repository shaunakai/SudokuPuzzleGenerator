import java.util.ArrayList; 
public class Sudoku 
{
    public static void main(String[] args)
    {
        int[][] board = startingBoard();
        fillingSudokuBoard(board);
        printBoard(board);

    }
    
    public static int[][] startingBoard(){
        int[][] SudokuBoard = new int[9][9];
        return SudokuBoard;
    }

    public static boolean fillingSudokuBoard(int[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){

                if (board[i][j] == 0){

                    ArrayList<Integer> starterBoard = new ArrayList<Integer>();

                    for (int k = 0; k < 9; k++){
                        starterBoard.add(k + 1);
                    }
            
                    for (int n = 0; n < starterBoard.size();n++){
                        int randoNum = (int)(Math.random() * starterBoard.size());

                        int gettingChecked = starterBoard.get(n);
                        starterBoard.set(n, starterBoard.get(randoNum));
                        starterBoard.set(randoNum, gettingChecked);
                    }

                    for (int m = 0; m <starterBoard.size(); m++){
                        int addNum = starterBoard.get(m);

                        if(numberIsValid(board, i, j, addNum)){
                            board[i][j] = addNum;

                            if(fillingSudokuBoard(board)){
                                return true;
                            }

                            board[i][j] = 0;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(int[][] board){
        for (int i = 0; i < 9; i++){
            if(i % 3 == 0 ){
                System.out.println("+-------+-------+-------+");
            }

            for(int j = 0; j < 9; j++){
                if(j%3==0){
                    System.out.print("| ");
                }

                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }
    
    public static boolean checkRow(int[][] board, int row, int numMade){
        for (int i = 0; i < 9; i++){
            if (board[row][i] == numMade){
                return true;
            }
        }
        return false;
    }

    public static boolean checkCol(int[][] board, int col, int numMade){
        for (int i = 0; i < 9; i++){
            if(board[i][col] == numMade){
                return true;
            }
        }
        return false;
    }

    public static boolean check3x3(int[][] board, int row, int col, int numMade){
        int startOfRow = 0;
        int startOfCol = 0;
        
        if (row < 3){
            startOfRow = 0;
        } else if(row < 6){
            startOfRow = 3;
        } else{
            startOfRow = 6;
        }

        if (col < 3){
            startOfCol = 0;
        } else if(col < 6){
            startOfCol = 3;
        } else{
            startOfCol = 6;
        }

        for (int i = startOfRow; i < startOfRow + 3; i++){
            for(int j = startOfCol; j < startOfCol + 3; j++){
                if(board[i][j] == numMade){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean numberIsValid(int[][] board, int row, int col, int numMade){
        if(checkRow(board,row,numMade)){
            return false;
        }
        if(checkCol(board,col,numMade)){
            return false;
        }
        if(check3x3(board,row,col,numMade)){
            return false;
        }
        return true;
    }
}