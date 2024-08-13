import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String [][] arr = new String[][]{{"1","2","3","4"},
                                        {"1","2","3","4"},
                                        {"1","2","3","4"},
                                        {"1","2","3","4"}};
        try {
            System.out.println("Summ of array is: " + processArray(arr));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
    public static int processArray(String[][] array)
            throws MyArrayDataException, MyArraySizeException {
        int result = 0;
        if (array.length != 4)
            throw new MyArraySizeException("Incorrect array size");
        for(int i = 0; i < 4; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException("Incorrect array size");
        }
        int i = 0;
        int j = 0;
        try {
            for (i = 0 ; i < array.length; i++) {
                for (j = 0; j < array[0].length; j++) {
                    result = result + Integer.parseInt(array[i][j].trim());
                }
            }
        }
        catch (NumberFormatException e) {
            throw new MyArrayDataException("Incorrect data in array on cell [" + i +"," + j + "]");
        }
        return result;
    }
}

