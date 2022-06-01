package src.utils;

import java.io.File;
import java.util.Scanner;

public class CommonUtils {
    
    public static Scanner readFile(String filePath) throws Exception{
        File doc = new File(filePath);
        return new Scanner(doc);
    }
}
