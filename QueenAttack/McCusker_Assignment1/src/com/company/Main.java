package com.company;

import java.util.*;

public class Main {


    public class queen
    {
        char color = 'E'; // Using the character 'E' to indicate the empty space.
        int attacks;
        int[] position = new int[2];
        public queen(){

        }
    }

    public static  queen[][] chessboard(int n, int m, int w, int b)
    {
        queen[][] board = new queen[n][m];
        Random Randy = new Random();

        for(int a = 0; a < n; a++)
        {
            for(int o = 0; o < m; o++)
            {
                board[a][o].color = 'E';
                board[a][o].attacks = 0;
                board[a][o].position[0]=a;
                board[a][o].position[1]=o;
            }

        }

        for(int i = 0; i < w; i++)
        {
            int t = Randy.nextInt(n);
            int g = Randy.nextInt(m);

            if(board[t][g].color== 'E')
            {
                board[t][g].color = 'W'; //W will fill the empty space if there are no other W's or B's
                board[t][g].attacks = 0;
                board[t][g].position[0] = t;
                board[t][g].position[1] = g;

            } else {
                i--;

            }

        }
        for(int j = 0; j < b; j++)
        {
            int t = Randy.nextInt(n);
            int g = Randy.nextInt(m);

            if(board[t][g].color == 'E') { //B will fill the empty space if there are no other W's or B's
                board[t][g].color = 'B';
                board[t][g].attacks = 0;
                board[t][g].position[0] = t;
                board[t][g].position[1] = g;
            } else {
                j--;
            }
        }
        for(int d = 0; d < n; d++) //checking every spot on the board for queens
        {
            for(int p = 0; p < m; p++)
            {
                if(board[d][p].color != 0)
                {
                    board[d][p].attacks = numAttacks(board[d][p], board);
                }
            }
        }

        return board;
    }

    // Will count the number of attacks. This evaluates the attacks.

    public static int numAttacks(queen q, queen[][] chester) {
        int moves = 0;

        if(q.color == 'W') {
            for (int i = 0; i < chester.length; i++) {
                if (chester[i][q.position[1]].color == 'B') {
                    moves++; //keeping track of attacks on queen
                }
            }
            for (int j = 0; j < chester[0].length; j++)
            {
                if (chester[q.position[0]][j].color == 'B') // row
                {
                    moves++;
                }
            }

            int c = q.position[1]; // column


            //Checking the diagonal for Queens

            for (int h = q.position[0]; h < chester.length; h++)
            {
                if (chester[h][c].color != 0 && chester[h][c].color == 'B') {// check row for black queens top right
                    moves++;

                }
                c++;
            }
            for (int h = q.position[0]; h < chester.length; h++)
            {
                if (chester[h][c].color!= 0 && chester[h][c].color == 'B') {// check row for black queens bottom right
                    moves++;

                }
                c--;
            }
            for (int h = q.position[0]; h < chester.length; h--)
            {
                if (chester[h][c].color!= 0 && chester[h][c].color == 'B') {// check row for black queens top left
                    moves++;

                }
                c++;
            }
            for (int h = q.position[0]; h < chester.length; h--)
            {
                if (chester[h][c].color!= 0 && chester[h][c].color == 'B') {// check row for black queens bottom left
                    moves++;

                }
                c--;
            }
        }

        // Black queens check for white queens
        if(q.color == 'B') {
            for (int i = 0; i < chester.length; i++) {
                if (chester[i][q.position[1]].color == 'W') {
                    moves++; //keeping track of attacks on queen
                }
            }
            for (int j = 0; j < chester[0].length; j++)
            {
                if (chester[q.position[0]][j].color == 'W') // row
                {
                    moves++;
                }
            }

            int c = q.position[1]; // column


            for (int h = q.position[0]; h < chester.length; h++)
            {
                if (chester[h][c].color!= 0 && chester[h][c].color == 'W') {// check row for black queens top right
                    moves++;

                }
                c++;
            }
            for (int h = q.position[0]; h < chester.length; h++)
            {
                if (chester[h][c].color!= 0 && chester[h][c].color == 'W') {// check row for black queens bottom right
                    moves++;

                }
                c--;
            }
            for (int h = q.position[0]; h < chester.length; h--)
            {
                if (chester[h][c].color != 0 && chester[h][c].color == 'W') {// check row for black queens top left
                    moves++;

                }
                c++;
            }
            for (int h = q.position[0]; h < chester.length; h--)
            {
                if (chester[h][c].color != 0 && chester[h][c].color == 'W') {// check row for black queens bottom left
                    moves++;

                }
                c--;
            }
        }
        return moves;
    }
    // creating the chessboard

    public static void showChessBoard(queen[][] chessbo)
    {
        for (int i = 0; i < chessbo.length; i++)
        {
            System.out.println("");
            for (int j = 0; j <chessbo[0].length; j++)
            {
                if(chessbo[i][j].color != 0)
                {
                    System.out.print(chessbo[i][j].color + " YES"); //Print the chessboard with YES if it runs
                } else {
                    System.out.print("NO"); // Print NO if it doesn't run
                }
            }
        }
    }

    //main method to display the chessboard and the queens with the elements indicated by n,m,w,b.
    public static void main(String[] args) //main method
    {
        queen[][] boardy = chessboard(6, 6, 3,2);
        showChessBoard(boardy); // display the chessboard

    }

}
