
import java.awt.*;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class TwentyFortyEight {

    private static int probabilityOf4 = 10;
    private boolean validMove;
    private int NUM_ROWS = 4;
    private int NUM_COLS = 4;
    private static String[][] gameInfo; //the value, followed by a boolean as to whether it is a combineable tile
    private static boolean[][] combinable; //maps to each tile, indicates whether a tile can be combined with a neighboring tile
    private static ArrayList<Integer> rows;
    private static ArrayList<Integer> cols;
    private static int score;
    private static String blank = "X";
    private static int secondsPassed;
    private static boolean runClock;
    private boolean lose = false;
    private static HashMap<String, Color> colorTable;
    private static boolean resumeGame = false;


    public TwentyFortyEight(){

        score = 0;
        secondsPassed = 0;
        runClock = false;
        gameInfo = new String[NUM_ROWS][NUM_COLS];
        combinable = new boolean[NUM_ROWS][NUM_COLS];
        rows = new ArrayList<Integer>();
        cols = new ArrayList<Integer>();

        populateArray(gameInfo);
        resetCombinable();

        populateArrayList(rows);
        populateArrayList(cols);


        placeNewTile();
        placeNewTile();


    }

    public void moveTilesRight(){
        validMove = false;
        int counter;
        int newNum;
        //go through each row
        for(int i = 0; i < gameInfo.length; i++){
            //but only go to length - 1 of the columns
            for(int j = gameInfo[0].length - 2; j >= 0 ; j--){

                //if we find a piece
                if(!gameInfo[i][j].equals(blank)){
                    //and the piece to the right of that piece is free
                    counter = j + 1;
                    while(counter < 4) {
                        if(gameInfo[i][counter].equals(blank)) {

                            gameInfo[i][counter] = gameInfo[i][counter - 1];
                            gameInfo[i][counter - 1] = blank;
                            validMove = true;

                        }
                        //or it is the same as the piece being moved
                        else if(gameInfo[i][counter].equals(gameInfo[i][counter - 1]) && combinable[i][counter] && combinable[i][counter - 1]){

                            newNum = Integer.parseInt(gameInfo[i][counter]) + Integer.parseInt(gameInfo[i][counter - 1]);

                            gameInfo[i][counter] = Integer.toString(newNum);
                            gameInfo[i][counter - 1] = blank;
                            validMove = true;

                            setScore(newNum);
                            combinable[i][counter] = false;
                            counter = 4;

                        }
                        counter++;
                    }
                }

            }
        }
    }

    public boolean moveTilesRight(String arr[][]){
        boolean tempValidMove = false;
        int counter;
        int newNum;
        //go through each row
        for(int i = 0; i < arr.length; i++){
            //but only go to length - 1 of the columns
            for(int j = arr[0].length - 2; j >= 0 ; j--){

                //if we find a piece
                if(!arr[i][j].equals(blank)){
                    //and the piece to the right of that piece is free
                    counter = j + 1;
                    while(counter < 4) {
                        if(arr[i][counter].equals(blank)) {

                            arr[i][counter] = arr[i][counter - 1];
                            arr[i][counter - 1] = blank;
                            tempValidMove = true;

                        }
                        //or it is the same as the piece being moved
                        else if(arr[i][counter].equals(arr[i][counter - 1])){

                            newNum = Integer.parseInt(arr[i][counter]) + Integer.parseInt(arr[i][counter - 1]);

                            arr[i][counter] = Integer.toString(newNum);
                            arr[i][counter - 1] = blank;
                            tempValidMove = true;
                            counter = 4;
                        }
                        counter++;
                    }
                }
            }
        }

        return tempValidMove;
    }

    public void moveTilesDown(){
        validMove = false;
        int counter;
        int newNum;
        //start one row from the bottom
        for(int i = gameInfo.length - 2; i >= 0; i--){
           //loop through each column
            for(int j = 0; j < gameInfo[0].length; j++){
                //if we find a piece
                if(!gameInfo[i][j].equals(blank)){
                    //and the piece to the below that piece is free
                    counter = i + 1;
                    while(counter < 4) {
                        if (gameInfo[counter][j].equals(blank)) {

                            gameInfo[counter][j] = gameInfo[counter - 1][j];
                            gameInfo[counter - 1][j] = blank;

                            validMove = true;

                        }
                        else if(gameInfo[counter][j].equals(gameInfo[counter - 1][j]) && combinable[counter][j] && combinable[counter-1][j]){

                            newNum = Integer.parseInt(gameInfo[counter][j]) + Integer.parseInt(gameInfo[counter - 1][j]);
                            gameInfo[counter][j] = Integer.toString(newNum);
                            gameInfo[counter - 1][j] = blank;

                            validMove = true;
                            setScore(newNum);
                            combinable[counter][j] = false;
                            counter = 4;
                        }
                        counter++;
                    }
                }
            }
        }
    }

    public boolean moveTilesDown(String arr[][]){
        boolean tempValidMove = false;
        int counter;
        int newNum;
        //start one row from the bottom
        for(int i = arr.length - 2; i >= 0; i--){
            //loop through each column
            for(int j = 0; j < arr[0].length; j++){
                //if we find a piece
                if(!arr[i][j].equals(blank)){
                    //and the piece to the below that piece is free
                    counter = i + 1;
                    while(counter < 4) {
                        if (arr[counter][j].equals(blank)) {

                            arr[counter][j] = arr[counter - 1][j];
                            arr[counter - 1][j] = blank;

                            tempValidMove = true;

                        }
                        else if(arr[counter][j].equals(arr[counter - 1][j])){

                            newNum = Integer.parseInt(arr[counter][j]) + Integer.parseInt(arr[counter - 1][j]);
                            arr[counter][j] = Integer.toString(newNum);
                            arr[counter - 1][j] = blank;

                            tempValidMove = true;

                            counter = 4;
                        }
                        counter++;
                    }
                }
            }
        }
        return tempValidMove;
    }


    public void moveTilesLeft(){

        validMove = false;
        int counter;
        int newNum;

        for(int i = 0; i < gameInfo.length; i++){

            for(int j = 1; j < gameInfo[0].length; j++){

                if(!gameInfo[i][j].equals(blank)){

                    counter = j - 1;

                    while(counter >= 0){

                        if(gameInfo[i][counter].equals(blank)){

                            gameInfo[i][counter] = gameInfo[i][counter + 1];
                            gameInfo[i][counter + 1] = blank;
                            validMove = true;
                        }
                        else if(gameInfo[i][counter].equals(gameInfo[i][counter + 1]) && combinable[i][counter] && combinable[i][counter + 1]){

                            newNum = Integer.parseInt(gameInfo[i][counter]) + Integer.parseInt(gameInfo[i][counter + 1]);

                            gameInfo[i][counter] = Integer.toString(newNum);
                            gameInfo[i][counter + 1] = blank;
                            validMove = true;
                            setScore(newNum);
                            combinable[i][counter] = false;
                            counter = -1;
                        }
                        counter--;
                    }
                }
            }
        }
    }

    public boolean moveTilesLeft(String arr[][]){

        boolean tempValidMove = false;
        int counter;
        int newNum;

        for(int i = 0; i < arr.length; i++){

            for(int j = 1; j < arr[0].length; j++){

                if(!arr[i][j].equals(blank)){

                    counter = j - 1;

                    while(counter >= 0){

                        if(arr[i][counter].equals(blank)){

                            arr[i][counter] = arr[i][counter + 1];
                            arr[i][counter + 1] = blank;
                            tempValidMove = true;
                        }
                        else if(arr[i][counter].equals(arr[i][counter + 1])){

                            newNum = Integer.parseInt(arr[i][counter]) + Integer.parseInt(arr[i][counter + 1]);

                            arr[i][counter] = Integer.toString(newNum);
                            arr[i][counter + 1] = blank;
                            tempValidMove = true;
                            counter = -1;
                        }
                        counter--;
                    }
                }
            }
        }
        return tempValidMove;
    }

    public void moveTilesUp(){

        validMove = false;
        int counter;
        int newNum;

        for(int i = 1; i < gameInfo.length; i++){

            for(int j = 0; j < gameInfo[0].length; j++){

                if(!gameInfo[i][j].equals(blank)){

                    counter = i - 1;
                    while(counter >= 0){

                        if(gameInfo[counter][j].equals(blank)){

                            gameInfo[counter][j] = gameInfo[counter + 1][j];
                            gameInfo[counter + 1][j] = blank;
                            validMove = true;
                        }
                        else if(gameInfo[counter][j].equals(gameInfo[counter + 1][j]) && combinable[counter][j] && combinable[counter + 1][j]){

                            newNum = Integer.parseInt(gameInfo[counter][j]) + Integer.parseInt(gameInfo[counter + 1][j]);

                            gameInfo[counter][j] = Integer.toString(newNum);
                            gameInfo[counter + 1][j] = blank;

                            validMove = true;
                            setScore(newNum);
                            combinable[counter][j] = false;
                            counter = -1;
                        }
                        counter--;
                    }
                }
            }
        }
    }

    public boolean moveTilesUp(String arr[][]){

        boolean tempValidMove = false;
        int counter;
        int newNum;

        for(int i = 1; i < arr.length; i++){

            for(int j = 0; j < arr[0].length; j++){

                if(!arr[i][j].equals(blank)){

                    counter = i - 1;
                    while(counter >= 0){

                        if(arr[counter][j].equals(blank)){

                            arr[counter][j] = arr[counter + 1][j];
                            arr[counter + 1][j] = blank;
                            tempValidMove = true;
                        }
                        else if(arr[counter][j].equals(arr[counter + 1][j])){

                            newNum = Integer.parseInt(arr[counter][j]) + Integer.parseInt(arr[counter + 1][j]);

                            arr[counter][j] = Integer.toString(newNum);
                            arr[counter + 1][j] = blank;

                            tempValidMove = true;

                            counter = -1;
                        }
                        counter--;
                    }
                }
            }
        }
        return tempValidMove;
    }


    public static void placeNewTile(){

        int row = getRandomRow();
        int col = getRandomCol();

        while(!checkLocation(col, row)){

            col = getRandomCol();
            row = getRandomRow();
        }

        gameInfo[row][col] = Integer.toString(getNewTile());
    }

    public void placeNewTile(String value){

        int row = getRandomRow();
        int col = getRandomCol();

        while(!checkLocation(col, row)){

            col = getRandomCol();
            row = getRandomRow();
        }

        gameInfo[row][col] = value;
    }





    private static boolean checkLocation(int col, int row){

        if (gameInfo[row][col] == blank) {
            return true;
        }
        else
            return false;
    }

    private static  int getRandomNum(int max){

        Random rand = new Random();
        int randNum = rand.nextInt(max);

        return randNum;
    }

    public static int getRandomRow(){

        return rows.get(getRandomNum(rows.size()));


    }

    public static int getRandomCol(){

        return cols.get(getRandomNum(cols.size()));
    }



    public static int getNewTile(){

        int tile;
        int randNum = getRandomNum(probabilityOf4);

        if(randNum == 0){
            tile = 4;
        }
        else{

            tile = 2;
        }

        return tile;
    }

    private void populateArrayList(ArrayList<Integer> list){

        for(int i = 0; i < NUM_ROWS; i++) {

            list.add(i);

        }

    }

    private void populateArray(String arr[][]){

        for(int i = 0; i < NUM_ROWS; i++) {

            for (int j = 0; j < NUM_COLS; j++) {

                arr[i][j] = blank;

            }
        }
    }

    public void resetCombinable(){

        for(int i = 0; i < NUM_ROWS; i++) {

            for (int j = 0; j < NUM_COLS; j++) {


                combinable[i][j] = true;
            }
        }

    }
    public void printArray(){

        for(int i = 0; i < NUM_ROWS; i++) {

            for (int j = 0; j < NUM_COLS; j++) {

                System.out.print(gameInfo[i][j] + " ");
            }

            System.out.println();
        }

    }

    public int getNumRows(){
        return NUM_ROWS;
    }

    public int getNumCols(){

        return NUM_COLS;
    }

    public String getValue(int row, int col){

        return gameInfo[row][col];
    }

    public boolean getValidMove(){
        return validMove;
    }

    public int getNumDigits(int row, int col){

        return gameInfo[row][col].length();
    }
    public static int getScore(){
        return score;
    }
    public void setScore(int addOn){
        score += addOn;

    }
    public int getSecondsPassed(){
        return secondsPassed;
    }

    public void incrementSecondsPassed(){
        secondsPassed++;
    }

    public void setRunClock(boolean b){
        runClock = b;
    }
    public boolean getRunClock(){
        return runClock;
    }

    //loop through each tile and check to see if it = 2048
    //we only want to check for this value until they get the value then we want
    //to check for the higher values 4096... ect.
    public boolean checkWin(){
        return false;
    }

    //this method is important... if it doesn't work we will get a bad array related error
    //fire each move method, and if all 4 return false then this method returns true5
    public boolean checkLoss(){

        String tempArray[][] = new String[NUM_ROWS][NUM_COLS];

        for(int i = 0; i < NUM_ROWS; i++){
            for(int j = 0; j < NUM_COLS; j++){

               tempArray[i][j] = gameInfo[i][j];

            }
        }

        if(!moveTilesRight(tempArray) && !moveTilesDown(tempArray) && !moveTilesUp(tempArray) && !moveTilesLeft(tempArray)){

            lose = true;

        }
        else{
            lose = false;
        }

        return lose;
    }

    public static void NewGame(){


        runClock = true;

        for(int i = 0; i < gameInfo.length; i++){
            for(int j = 0; j < gameInfo[0].length; j++){
                gameInfo[i][j] = blank;


            }
        }
        score = 0;
        secondsPassed = 0;
        placeNewTile();
        placeNewTile();
    }

    public void Pause(){
        if(runClock) {
            setRunClock(false);
        }
        else{
            setRunClock(true);
        }

    }

    public static void populateColorTable(){

        colorTable = new HashMap<>();
        colorTable.put("2", new Color(220,220,175));
        colorTable.put("4", new Color(220,200,175));
        colorTable.put("8", new Color(220,175,175));
        colorTable.put("16", new Color(240,150,150));
        colorTable.put("32", new Color(250,100,100));
        colorTable.put("64", new Color(250,100,150));
        colorTable.put("128", new Color(175,100,200));
        colorTable.put("256", new Color(100,50,250));
        colorTable.put("512", new Color(50,75,250));
        colorTable.put("1024", new Color(50,150,250));
        colorTable.put("2048", new Color(75,225,250));
        colorTable.put("4096", new Color(75,250,100));
        colorTable.put("8192", new Color(150,250,100));
        colorTable.put("16384", new Color(0,0,0));

    }

    public static Color getColorValue(String str){

        return colorTable.get(str);

    }

    public static boolean getResumeGame(){
        return resumeGame;
    }
    public static void setResumeGame(boolean bool){

        resumeGame = bool;
    }

}
