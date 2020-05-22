package ru.gb.jtwo.ltwo;

public class Main {
    private static final class RowException extends RuntimeException{
        RowException(String message){
            super("Row exception: " + message);
        }
    }
    private static final class ColumException extends RuntimeException{
        ColumException(String message){
            super("Column exception: " + message);
        }
    }
    private static final class NumberIsNotNumberException extends RuntimeException{
        NumberIsNotNumberException(int message){
            super("Number is not number: " + message);
        }
    }

    private static final int MAX_ROWS = 4;
    private static final int MAX_COLUMNS = 4;

    public static void main(String[] args) {
        String task = "10 3 5 2\n2 3 2 2\n5 4 4 1\n300 3 1 0";
        try {
            strToArray(task);
            strToInt(strToArray(task));
            printAnswer(strToInt(strToArray(task)));
        } catch (NumberIsNotNumberException e) {
            System.out.println("Что то пошло не так" + e.getMessage());
        } catch (RowException | ColumException e){
            System.out.println("Что то пошло не так опять" + e.getMessage());
        }
    }

    private static String[][] strToArray(String task) {
        String[] out = task.split("\n");
        if (out.length != MAX_ROWS) throw new RowException(out.length + ":\n" + task);

        String[][] outFinal = new String[MAX_ROWS][];
        for (int i = 0; i < outFinal.length; i++) {
            outFinal[i] = out[i].split(" ");
            if (outFinal[i].length != MAX_COLUMNS) throw new ColumException(outFinal.length + ":\n" + task);
        }
        return outFinal;
    }

    private static int[][]strToInt(String[][] in){
        int[][] out = new int[in.length][in.length];
        for (int i = 0; i < in.length ; i++) {
            for (int j = 0; j <in[i].length ; j++) {
                try {
                    out[i][j] = Integer.parseInt(in[i][j]);
                } catch (NumberFormatException e) {
                    throw new NumberIsNotNumberException(out[i][j]);
                }
            }
        }
        return out;
    }

    private static void printAnswer(int[][] in){
        int answer = 0;
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                answer += in[i][j];
            }
        }
        System.out.println(answer / 2);
    }
}
