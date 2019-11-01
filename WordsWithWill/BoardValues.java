import java.awt.*;
import java.util.HashMap;

public class BoardValues {
    private static final int ROWS = 15;
    private static final int COLS = 15;
    private static String[][] values = new String[ROWS][COLS];
    private static HashMap<String, Color> colorTable;

    public BoardValues(){

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++) {
                values[i][j] = "X";
            }
        }
        values[0][3] = "TW";
        values[0][6] = "TL";
        values[0][8] = "TL";
        values[0][11] = "TW";

        values[1][2] = "DL";
        values[1][5] = "DW";
        values[1][9] = "DW";
        values[1][12] = "DL";

        values[2][1] = "DL";
        values[2][4] = "DL";
        values[2][10] = "DL";
        values[2][13] = "DL";

        values[3][0] = "TW";
        values[3][3] = "TL";
        values[3][7] = "DW";
        values[3][11] = "TL";
        values[3][14] = "TW";

        values[4][2] = "DL";
        values[4][6] = "DL";
        values[4][8] = "DL";
        values[4][12] = "DL";

        values[5][1] = "DW";
        values[5][5] = "TL";
        values[5][9] = "TL";
        values[5][13] = "DW";

        values[6][0] = "TL";
        values[6][4] = "DL";
        values[6][10] = "DL";
        values[6][14] = "TL";

        values[7][3] = "DW";
        values[7][7] = "+";
        values[7][11] = "DW";

        values[8][0] = "TL";
        values[8][4] = "DL";
        values[8][10] = "DL";
        values[8][14] = "TL";

        values[9][1] = "DW";
        values[9][5] = "TL";
        values[9][9] = "TL";
        values[9][13] = "DW";

        values[10][2] = "DL";
        values[10][6] = "DL";
        values[10][8] = "DL";
        values[10][12] = "DL";

        values[11][0] = "TW";
        values[11][3] = "TL";
        values[11][7] = "DW";
        values[11][11] = "TL";
        values[11][14] = "TW";

        values[12][1] = "DL";
        values[12][4] = "DL";
        values[12][10] = "DL";
        values[12][13] = "DL";

        values[13][2] = "DL";
        values[13][5] = "DW";
        values[13][9] = "DW";
        values[13][12] = "DL";

        values[14][3] = "TW";
        values[14][6] = "TL";
        values[14][8] = "TL";
        values[14][11] = "TW";
    }

    public String getBoardValue(int row, int col){
        return values[row][col];
    }

    public static void populateColorTable(){

        colorTable = new HashMap<>();
        colorTable.put("TL", new Color(172,194,113));
        colorTable.put("TW", new Color(240,157,104));
        colorTable.put("DL", new Color(98,164,215));
        colorTable.put("DW", new Color(224,118,101));
        colorTable.put("+", new Color(114, 89, 150));
    }

    public static Color getColorValue(String str){ return colorTable.get(str); }
}
