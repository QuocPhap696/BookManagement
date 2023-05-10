package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class CSVUtils {
    public static <T> void write(String path, List<T>items){
        try {
            PrintWriter print = new PrintWriter(path);
            for (Object item : items){
                print.println(item.toString());
            }
            print.flush();
            print.close();

        }catch (FileNotFoundException e){
            throw new IllegalArgumentException(path + "invalid");
        }
    }

    public  static List<String> read(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        }catch (IOException e){
            throw  new IllegalArgumentException(path + "invalid");
        }
    }

    public static double parseDouble(int num){
        String price1 = String.valueOf(num);
        return Double.parseDouble(price1);
    }

    public static int parseInteger(double num){
        String price1 = String.valueOf(num);
        String priceNew = price1.replaceAll("\\D+\\d", "");
        return Integer.parseInt(priceNew);
    }
}
