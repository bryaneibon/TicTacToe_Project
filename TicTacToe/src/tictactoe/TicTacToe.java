package tictactoe;
import java.util.Scanner;

public class TicTacToe {
    private static String currentValue = ""; // Will stock the current value and update after each turn.
    private static int gameLimit = 9;  // Define a maximum of rounds available, depending on the coordinates method.


    public static void main(String[] args) {
        String [][] ticTacToe = new String[3][3];

        drawEmptyboard(ticTacToe);
        drawTicTacToe(ticTacToe);     // Apres avoir remplie l'array, on le dessine
        gameStatus(ticTacToe);
    }

    private static void drawEmptyboard(String[][] game) {
        // Start the game by creating a empty board.
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                game[i][j] = " ";
            }
        }
    }
    private static void drawTicTacToe(String [][] game){
        // Then Design the board.
        System.out.println("---------");
        for (int i = 0; i < game.length; i++) {
            if(i == 0) {System.out.print("| ");}
            for (int j = 0; j < game.length; j++) {
                System.out.print(game[i][j] + " ");
                if (j == 2 && i == 0){
                    System.out.print("|");
                    System.out.println();
                    System.out.print("| ");
                }
                else if (j == 2 && i == 1){
                    System.out.print("|");
                    System.out.println();
                    System.out.print("| ");
                }
                else if (j == 2 && i == 2){
                    System.out.print("|");
                    System.out.println();
                }
            }
        }
        System.out.println("---------");
    }

    private static void gameStatus(String [][] game){
        while(!isImpossible(game)){
            coordinates(game);
            drawTicTacToe(game);
            if (findAwinner(game)){
                System.out.println(whoIsTheWinner(game) + " wins");
                return;
            }

            if (gameLimit == 0){
                System.out.println("Draw");
                return;
            }
        }

        if (isImpossible(game)){
            System.out.println("Impossible");
            return;
        }
    }

    public static void coordinates(String [][] game){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinates: ");
        int firstCordinate = scanner.nextInt();
        int secondCordinate = scanner.nextInt();

        if(firstCordinate == 1 && secondCordinate == 1){
            firstCordinate = 2;
            secondCordinate = 0;
        }else if(firstCordinate == 3 && secondCordinate == 1){
            firstCordinate = secondCordinate = 2;
        }else if(firstCordinate == 1  && secondCordinate == 2){
            secondCordinate = 0;
        }else if(firstCordinate == 2 && secondCordinate == 2){
            firstCordinate = secondCordinate = 1;
        }else if(firstCordinate == 3 && secondCordinate == 2){
            firstCordinate = 1;
        }else if(firstCordinate == 1 && secondCordinate == 3){
            firstCordinate = secondCordinate = 0;
        }else if(firstCordinate == 2 && secondCordinate == 3){
            firstCordinate = 0;
            secondCordinate = 1;
        }else if(firstCordinate == 3 && secondCordinate == 3){
            firstCordinate = 0;
            secondCordinate = 2;
        }


        while(firstCordinate > 3 || secondCordinate > 3){
            System.out.println("Coordinates should be from 1 to 3!");
            System.out.print("Enter the coordinates: ");
            firstCordinate = scanner.nextInt();
            secondCordinate = scanner.nextInt();

            if(firstCordinate == 1 && secondCordinate == 1){
                firstCordinate = 2;
                secondCordinate = 0;
            }else if(firstCordinate == 3 && secondCordinate == 1){
                firstCordinate = secondCordinate = 2;
            }else if(firstCordinate == 1  && secondCordinate == 2){
                secondCordinate = 0;
            }else if(firstCordinate == 2 && secondCordinate == 2){
                firstCordinate = secondCordinate = 1;
            }else if(firstCordinate == 3 && secondCordinate == 2){
                firstCordinate = 1;
            }else if(firstCordinate == 1 && secondCordinate == 3){
                firstCordinate = secondCordinate = 0;
            }else if(firstCordinate == 2 && secondCordinate == 3){
                firstCordinate = 0;
                secondCordinate = 1;
            }else if(firstCordinate == 3 && secondCordinate == 3){
                firstCordinate = 0;
                secondCordinate = 2;
            }
        }

        while (game[firstCordinate][secondCordinate].equals("X") ||
               game[firstCordinate][secondCordinate].equals("O")){
            System.out.println("This cell is occupied! Choose another one!");
            System.out.print("Enter the coordinates: ");
            firstCordinate = scanner.nextInt();
            secondCordinate = scanner.nextInt();

            while(firstCordinate > 3 || secondCordinate > 3){
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.print("Enter the coordinates: ");
                firstCordinate = scanner.nextInt();
                secondCordinate = scanner.nextInt();
            }

            if(firstCordinate == 1 && secondCordinate == 1){
                firstCordinate = 2;
                secondCordinate = 0;
            }else if(firstCordinate == 3 && secondCordinate == 1){
                firstCordinate = secondCordinate = 2;
            }else if(firstCordinate == 1  && secondCordinate == 2){
                secondCordinate = 0;
            }else if(firstCordinate == 2 && secondCordinate == 2){
                firstCordinate = secondCordinate = 1;
            }else if(firstCordinate == 3 && secondCordinate == 2){
                firstCordinate = 1;
            }else if(firstCordinate == 1 && secondCordinate == 3){
                firstCordinate = secondCordinate = 0;
            }else if(firstCordinate == 2 && secondCordinate == 3){
                firstCordinate = 0;
                secondCordinate = 1;
            }else if(firstCordinate == 3 && secondCordinate == 3){
                firstCordinate = 0;
                secondCordinate = 2;
            }
        }

        if (currentValue.equals("")){
            currentValue = "X";
        } else if (currentValue.equals("X")){
            currentValue = "O";
        } else if (currentValue.equals("O")){
            currentValue = "X";
        }
        game[firstCordinate][secondCordinate] = currentValue;
        gameLimit -= 1;
    }

    private static boolean isImpossible(String [][] game){
        int X = 0;
        int O = 0;
        boolean isImpossible;

        /* premiere etape de verification */
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                if (game[i][j].equals("X")) {
                    X += 1;
                } else if (game[i][j].equals("O")) {
                    O += 1;
                }
            }
        }
        int difference = Math.abs(X-O);
        if (difference > 1){
            isImpossible = true;
        } else{
            isImpossible = false;
        }

        /*Prochaine etape de verification*/
        boolean moreThanOneWinner1 = (game[0][0].equals(game[0][1]) && game[0][0].equals(game[0][2]) && !game[0][0].equals(" ")) &&
                ((game[0][0].equals(game[1][1]) && game[0][0].equals(game[2][2])) ||
                        (game[0][0].equals(game[1][0]) && game[0][0].equals(game[2][0])) ||
                        (game[2][0].equals(game[2][1]) && game[2][0].equals(game[2][2])) ||
                        (game[2][0].equals(game[1][1]) && game[2][0].equals(game[0][2])) ||
                        (game[0][2].equals(game[1][2]) && game[0][2].equals(game[2][2])) ||
                        (game[0][1].equals(game[1][1]) && game[0][1].equals(game[2][1])) ||
                        (game[1][0].equals(game[1][1]) && game[1][0].equals(game[1][2])));

        boolean moreThanOneWinner2 = (game[0][0].equals(game[1][0]) && game[0][0].equals(game[2][0]) && !game[0][0].equals(" ")) &&
                ((game[0][0].equals(game[0][1]) && game[0][0].equals(game[0][2])) ||
                        (game[0][0].equals(game[1][1]) && game[0][0].equals(game[2][2])) ||
                        (game[2][0].equals(game[2][1]) && game[2][0].equals(game[2][2])) ||
                        (game[2][0].equals(game[1][1]) && game[2][0].equals(game[0][2])) ||
                        (game[0][2].equals(game[1][2]) && game[0][2].equals(game[2][2])) ||
                        (game[0][1].equals(game[1][1]) && game[0][1].equals(game[2][1])) ||
                        (game[1][0].equals(game[1][1]) && game[1][0].equals(game[1][2])));


        if (moreThanOneWinner1){
            isImpossible = moreThanOneWinner1;
        } else if(moreThanOneWinner2){
            isImpossible = moreThanOneWinner2;
        }
        return isImpossible;
    }

    private static boolean findAwinner(String[][] game){
        boolean winner = (game[0][0].equals(game[0][1]) && game[0][0].equals(game[0][2]) && !game[0][0].equals(" ")) ||
                (game[0][0].equals(game[1][1]) && game[0][0].equals(game[2][2]) && !game[0][0].equals(" ")) ||
                (game[0][0].equals(game[1][0]) && game[0][0].equals(game[2][0]) && !game[0][0].equals(" ")) ||
                (game[2][0].equals(game[2][1]) && game[2][0].equals(game[2][2]) && !game[2][0].equals(" ")) ||
                (game[2][0].equals(game[1][1]) && game[2][0].equals(game[0][2]) && !game[2][0].equals(" ")) ||
                (game[0][2].equals(game[1][2]) && game[0][2].equals(game[2][2]) && !game[0][2].equals(" ")) ||
                (game[0][1].equals(game[1][1]) && game[0][1].equals(game[2][1]) && !game[0][1].equals(" ")) ||
                (game[1][0].equals(game[1][1]) && game[1][0].equals(game[1][2]) && !game[1][0].equals(" "));

        return winner;
    }

    private static String whoIsTheWinner(String[][] game) {

        String winnerIsXorO = "";

        if ((game[0][0].equals(game[0][1]) && game[0][0].equals(game[0][2])) ||
                (game[0][0].equals(game[1][1]) && game[0][0].equals(game[2][2])) ||
                (game[0][0].equals(game[1][0]) && game[0][0].equals(game[2][0]))) {
            winnerIsXorO = game[0][0];
        } else if((game[2][0].equals(game[2][1]) && game[2][0].equals(game[2][2])) ||
                (game[2][0].equals(game[1][1]) && game[2][0].equals(game[0][2]))){
            winnerIsXorO = game[2][0];
        } else if((game[0][2].equals(game[1][2]) && game[0][2].equals(game[2][2]))){
            winnerIsXorO = game[0][2];
        } else if ((game[0][1].equals(game[1][1]) && game[0][1].equals(game[2][1]))){
            winnerIsXorO = game[0][1];
        } else if((game[1][0].equals(game[1][1]) && game[1][0].equals(game[1][2]))){
            winnerIsXorO = game[1][0];
        }
        return winnerIsXorO;
    }
}