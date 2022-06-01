package src.accessData;

import java.util.Scanner;

import src.utils.CommonUtils;

public class ReadFileFromText implements IReadFile {

    @Override
    public String readFileFromPath(String filePath) {
        System.out.println("READING FILE:" + filePath);
        StringBuilder dataString = new StringBuilder();
        try {
            Scanner obj = CommonUtils.readFile(filePath);
            while (obj.hasNextLine()) {
                dataString.append(obj.nextLine().trim() + "#");
            }
            System.out.println("END FILE READING");
        } catch (Exception e) {
            System.out.println("FILE COULD NOT BE READ");
            dataString = new StringBuilder();
            dataString.append("");
        }
        String response = dataString.toString();
        return response;
    }

}
