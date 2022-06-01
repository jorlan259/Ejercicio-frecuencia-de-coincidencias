import src.accessData.IReadFile;
import src.accessData.ReadFileFromText;
import src.logic.AtendanceFromText;
import src.logic.IAtendance;
import src.resource.ConfigSystem;

public class Main {
    final static String rutaArchivoDatos = "./employeeAttendanceData.txt";

    public static void main(String[] args) throws Exception {
        System.out.println("\n\n***********************************************************\n\n");
        String rutaArchivo = rutaArchivoDatos;
        if(args.length>0){
            rutaArchivo = args[0];
        }

        ConfigSystem cs = new ConfigSystem();
        String extension = cs.isAllowedFile(rutaArchivo);
        if (!extension.isEmpty()) {
            IAtendance atendance = null;
            IReadFile readFile = null;
            switch (extension) {
                case "txt":
                    readFile = new ReadFileFromText();
                    atendance = new AtendanceFromText(cs.getMinimumDataOnFile());
                    break;
            }
            String data = readFile.readFileFromPath(rutaArchivo);
            atendance.getResult(data);
        }
        System.out.println("\n\n***********************************************************\n\n");
    }
}