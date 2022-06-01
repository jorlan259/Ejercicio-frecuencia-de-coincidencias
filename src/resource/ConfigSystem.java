package src.resource;

import java.io.File;
import java.util.Scanner;

import src.utils.CommonUtils;

public class ConfigSystem {
    final String pathFileConfig = "./src/resource/configSystem.txt";

    private String[] dataFile;

    public ConfigSystem(){
        readFileConfig();
    }

    private void readFileConfig(){
        System.out.println("READING THE CONFIGURATION FILE");
        StringBuilder dataString = new StringBuilder();

        try {
            Scanner obj = CommonUtils.readFile(pathFileConfig);
            while (obj.hasNextLine()) {
                dataString.append(obj.nextLine().trim() + "-##-");
            }            
            System.out.println("FINISHING READING THE CONFIGURATION FILE");
        } catch (Exception e) {
            System.out.println("FILE "+pathFileConfig+" COULD NOT BE READ");
            dataString = new StringBuilder();
            dataString.append("");
        }
        
        String configs = dataString.toString();
        if(!configs.isEmpty()){
            dataFile = configs.split("-##-");
        }
    }


    private String getAllFilesAllowed(){
        return getConfigByName("allowedFiles");
    }

    private String getConfigByName(String configName){
        String result = "";
        for (String item : dataFile) {
            if(item.contains(configName)){
                final String[] subStrings = item.split("=");
                result = subStrings[1].trim();
                break;
            }
        }
        return result;
    }

    public String isAllowedFile(String filePath) {
        String extension = "";
        File file = new File(filePath);
        String fileName = file.toString();
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            String allFilesAllowed = getAllFilesAllowed();
            if(!allFilesAllowed.isEmpty()){
                extension = fileName.substring(index + 1);
                if (allFilesAllowed.contains(extension)) {
                    System.out.println("VALID FILE EXTENSION");
                }else{
                    extension = "";
                    System.out.println("INVALID FILE EXTENSION");
                }
            }
        }else{
            System.out.println("INVALID FILE PATH, PATH: "+filePath+" DOES NOT PROVIDE A FILE");
        }
        return extension;
    }

    public String getAllowedFiles(){
       return getConfigByName("allowedFiles");
    }

    public int getMinimumDataOnFile(){
        int minimun = 2;
        String response = getConfigByName("minimumDataOnFile");
        if(!response.isEmpty()){
            minimun = Integer.parseInt(response);
        }else{
            System.out.println("THERE IS NO VARIABLE CONTAINING A MINIMUM OF DATA IN THE CONFIG FILE, SETTING MINIMUM BY DEFAULT: "+minimun);
        }
        return minimun;
    }
}
