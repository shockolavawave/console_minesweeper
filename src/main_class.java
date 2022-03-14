import java.util.*;

//class for constructing the matrix
class xon{

    Random ran = new Random();

    xon(int row, int col){

        int mines = (int) ((float)row*col*15)/100;      // percent of mines is can be changed
        boolean control = true;
        int mod = (row*col)/mines + 1;          // most important variable
        int buff;
        int fails = 0;

        char[][] mat = new char[row][col];
        // filling up the matrix with squares
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                mat[i][j] = '\u25a1';

        System.out.println("The number of mines is: " + mines);

        // assigning the characters (mines)
        while (control) {
            int buff_mines = mines;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    if(buff_mines == 0)
                        break;

                    buff = ran.nextInt();
                    if (buff % mod == 0) {
                        mat[i][j] = '\u2022';
                        buff_mines--;
                    }
                }
                if(buff_mines == 0)
                    break;
            }

            if (buff_mines != 0) {
                fails++;

                if(fails == Integer.MAX_VALUE){
                    System.out.println("Something went wrong." + '\n' + "Exiting...");
                    System.exit(0);
                }

                // refilling the matrix with blanks
                for(int i = 0; i < row; i++)
                    for(int j = 0; j < col; j++)
                        mat[i][j] = '\u25a1';

                continue;
            }
            control = false;
        }

        // printing the matrix with mines only
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j] + " ");

            System.out.println();
        }

        System.out.println("\n\n");

        // calculating the indicators
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // skipping mines
                if (mat[i][j] == '\u2022')
                    continue;

                // upper left cell
                if (i == 0 && j == 0) {

                    if(mat[i][j+1]   == '\u2022') count++;
                    if(mat[i+1][j]   == '\u2022') count++;
                    if(mat[i+1][j+1] == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // upper edge cells
                if (i == 0 && j != 0 && j != (col - 1)) {

                    if(mat[i][j-1]   == '\u2022') count++;
                    if(mat[i][j+1]   == '\u2022') count++;
                    if(mat[i+1][j-1] == '\u2022') count++;
                    if(mat[i+1][j]   == '\u2022') count++;
                    if(mat[i+1][j+1] == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // upper right cell
                if (i == 0 && j == (col - 1)) {

                    if(mat[i][j-1]   == '\u2022') count++;
                    if(mat[i+1][j-1] == '\u2022') count++;
                    if(mat[i+1][j]   == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // left edge cells
                if (i != 0 && i != (row - 1) && j == 0) {

                    if(mat[i-1][j]   == '\u2022') count++;
                    if(mat[i-1][j+1] == '\u2022') count++;
                    if(mat[i][j+1]   == '\u2022') count++;
                    if(mat[i+1][j]   == '\u2022') count++;
                    if(mat[i+1][j+1] == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // middle cells
                if (i != 0 && j != 0 &&
                    i != (row - 1) && j != (col - 1)) {

                    if(mat[i-1][j-1] == '\u2022') count++;
                    if(mat[i-1][j]   == '\u2022') count++;
                    if(mat[i-1][j+1] == '\u2022') count++;
                    if(mat[i][j-1]   == '\u2022') count++;
                    if(mat[i][j+1]   == '\u2022') count++;
                    if(mat[i+1][j-1] == '\u2022') count++;
                    if(mat[i+1][j]   == '\u2022') count++;
                    if(mat[i+1][j+1] == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // right edge cells
                if (i != 0 && i != (row - 1) && j == (col - 1)) {

                    if(mat[i-1][j-1] == '\u2022') count++;
                    if(mat[i-1][j]   == '\u2022') count++;
                    if(mat[i][j-1]   == '\u2022') count++;
                    if(mat[i+1][j-1] == '\u2022') count++;
                    if(mat[i+1][j]   == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // lower left corner
                if (i == (row - 1) && j == 0) {

                    if(mat[i-1][j]   == '\u2022') count++;
                    if(mat[i-1][j+1] == '\u2022') count++;
                    if(mat[i][j+1]   == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // lower edge cells
                if (i == (row - 1) && j != 0 && j != (col - 1)) {

                    if(mat[i-1][j-1] == '\u2022') count++;
                    if(mat[i-1][j]   == '\u2022') count++;
                    if(mat[i-1][j+1] == '\u2022') count++;
                    if(mat[i][j-1]   == '\u2022') count++;
                    if(mat[i][j+1]   == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }

                // lower right cell
                if (i == (row - 1) && j == (col - 1)) {

                    if(mat[i-1][j-1] == '\u2022') count++;
                    if(mat[i-1][j]   == '\u2022') count++;
                    if(mat[i][j-1]   == '\u2022') count++;

                    if (count > 0) {
                        mat[i][j] = Character.forDigit(count, 10);
                        count = 0;
                    }
                }
            } // end of for j
        } // end of for i

        //printing the matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j] + " ");

            System.out.println();
        }

        System.out.println('\n' + "The number of failed allocation is: " + fails);
    }
}

// class with main method
public class main_class{

    static Scanner scObj = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            System.out.print("Enter number of rows: ");
            int row = scObj.nextInt();
            System.out.print("Enter number of columns: ");
            int col = scObj.nextInt();

            if (row < 10 || col < 10)
                throw new Exception("Very few rows and/or columns." + '\n' + "(minimum is 10x10 matrix.)");

            System.out.println();

            new xon(row, col);

        } catch (Exception e) {
            System.out.println("An error has occurred: " + e.getMessage() + '\n' + "Exiting...");
            System.exit(0);
        }
    }
}
