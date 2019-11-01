/**
 *
 * The following class models the LeaderBoardInfo object which reads in the information
 * associated with the games leader board including the player's name, and the player's score from an excel spreadsheet.
 * These two fields are represented by a String and an Integer respectively
 *
 * Additionally the class allows the object to output data to the same excel spreadsheet. The output contains two
 * additional fields from the input, the amount of time the user played the game for, and the Date the user played
 * the game on. These are represented as and Integer and String respectively.
 *
 * Another important note to be made about this class is its use of three external libraries, all of which I downloaded
 * from Maven.
 *
 *              Apache Poi
 *              Apache Poi-OOXML
 *              JavaTuples
 *
 * While I am not an expert in the details of how libraries work, I researched how the above 3 work.
 * The first two listed above allow communication between the excel spreadsheet and the program. I could have just used these
 * two, however the Apache Poi API does not have a straightforward way to order a spreadsheet by a column. The
 * JavaTuples library allowed me to combine up to 10 different data types or objects and package them into one
 * simple to use object, much like a Python Tuple. I thus used a Quartet (a structure that holds 4 data types) to
 * store the player's: score, name, game duration and date of play. What I found, and this was the important
 * discovery, is if you create an ArrayList of these Quartets and sort them, it will sort each Quartet by the first
 * element in the Quartet. Thus, I put the score as the first element in the Quartet, created an array list of
 * Quartets for each data entry (row) in the spreadsheet, sorted the list, and reversed the list, so the
 * largest score is the first element in the list and it continues in descending order.
 *
 * January 19, 2019
 * @author William Estony
 * @version 1.0
 *
 */

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.javatuples.Quartet;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardInfo {

    //The location where the excel file we are reading/writing to exists
    private final String filePath = "/Users/williamestony/IdeaProjects/SliderGame/src/Leaderboard.xlsx";

    //Defining the list of Quartets, each element represents data in each row of the spreadsheet
    private ArrayList<Quartet<Integer,Integer,String,String>> dataList;

    private Workbook workbook;
    private Sheet sheet;
    private Row row;

    //The sheet index for the sheet containing the data (there is only one sheet in this spreadsheet)
    private final int LEADER_BOARD_SHEET_INDEX = 0;

    //The row indexes for each piece of data in the spreadsheet
    private final int NAMES_INDEX = 0;
    private final int SCORE_INDEX = 1;
    private final int TIME_INDEX = 2;
    private final int DATE_INDEX = 3;

    /**
     * The constructor for the LeaderBoardInfo object. It defines and initializes the four pieces of data we are
     * extracting from the spreadsheet. It also uses a try/catch statement to open an input stream. Then we loop through
     * each sheet in the excel file, loop through each row in the sheet,
     */
    public LeaderboardInfo(){

        int score;
        int time;
        String name;
        String date;

        Quartet<Integer,Integer, String, String> data;

        dataList = new ArrayList<Quartet<Integer, Integer, String, String>>();


        try{

            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);

            //loop through each sheet
            for(int i = 0; i < workbook.getNumberOfSheets(); i++){

                Sheet sheet = workbook.getSheetAt(i);

                //loop through each row
                for(int j = 0; j < sheet.getPhysicalNumberOfRows(); j++){

                    row = sheet.getRow(j);

                    //initialize each data field, at a given row
                    score = (int)Double.parseDouble(row.getCell(SCORE_INDEX).toString());
                    name = row.getCell(NAMES_INDEX).toString();
                    time = (int)Double.parseDouble(row.getCell(TIME_INDEX).toString());
                    date = row.getCell(DATE_INDEX).toString();

                    //initialize the Quartet for each row, and add it to the list
                    data = Quartet.with(score, time, name, date);
                    dataList.add(data);
                }

                //sort and reverse the list so it's in descending order
                Collections.sort(dataList);
                Collections.reverse(dataList);

            }

       }catch(Exception ioe){

        }
    }

    /**
     * The following method takes four parameters and outputs them to the next available row in the Excel
     * spreadsheet that contains our leader board data.
     *
     * @param name
     * @param score
     * @param time
     * @param date
     *
     */
    public void updateLeaderBoardInfo(String name, int score, int time, String date) {

        //focus in on the first sheet and the first blank row in the spreadsheet and create the row
        sheet = workbook.getSheetAt(LEADER_BOARD_SHEET_INDEX);
        row = sheet.createRow(sheet.getPhysicalNumberOfRows());

        //set up the first four cells in the row and assign them the corresponding data
        row.createCell(NAMES_INDEX).setCellValue(name);
        row.createCell(SCORE_INDEX).setCellValue(score);
        row.createCell(TIME_INDEX).setCellValue(time);
        row.createCell(DATE_INDEX).setCellValue(date);


        try {

            //attempt to open the file
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            try {
                //attempt to write to the file
                workbook.write(fileOutputStream);
                fileOutputStream.close();

            } catch (IOException e) {

            }

        } catch (FileNotFoundException e) {


        }
    }

    /**
     *
     * @return the array list of quartets (dataList)
     */
    public ArrayList<Quartet<Integer,Integer,String,String>> getData(){

        return dataList;
    }


}
