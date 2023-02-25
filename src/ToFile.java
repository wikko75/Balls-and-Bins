import java.io.*;

public class ToFile {

    private final String dataName;
    private final int[][] result;
    private final int rows;
    private final int columns;


    ToFile(String dataName, int[][] data, int n, int k) {
        this.dataName = dataName;
        rows = n/1000;
        columns = k;
        result = data;
    }

    public void saveData(){
        File file = new File(dataName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int n = 0; n < rows; n++) {
                int sum = 0;
                for (int k = 0; k < columns; k++) {
                    sum += result[n][k];
                    fileWriter.write(result[n][k] + " ");
                }
                int avg = sum/columns;
                fileWriter.write(avg + " ");
                fileWriter.write(System.lineSeparator());
            }
            System.out.println(dataName + " saved!" + "   ✅");
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Can't read file! ❌");
        }
    }
}
