package src.logic;

import java.util.ArrayList;
import java.util.List;

import src.models.AtendanceModel;
import src.models.EmployeeModel;

public class AtendanceFromText extends Base implements IAtendance {

    private List<AtendanceModel> attendanceList;
    private int minimumDataOnFile;

    public AtendanceFromText(int minimumDataOnFile) {
        this.minimumDataOnFile = minimumDataOnFile;
    }

    @Override
    public void getResult(String data) {
        String[] listStaffInformacion = data.split("#");

        List<EmployeeModel> objectStaff = new ArrayList<>();
        for (String item : listStaffInformacion) {
            final String employeeName = item.split("=")[0];
            final String hoursWorkedString = item.split("=")[1];
            objectStaff.add(new EmployeeModel(employeeName, getEmployeeHours(hoursWorkedString)));
        }
        if (objectStaff.size() >= minimumDataOnFile) {
            System.out.println("\n\n");
            System.out.println("RESULTS: \n");
            searchMatched(objectStaff);
        }else{
            System.out.println("THE FILE DOES NOT CONTAIN THE MINIMUM AMOUNT OF DATA TO CONTINUE.\nPLEASE ENTER MORE DATA INTO YOUR FILE");
        }
    }

    private List<AtendanceModel> getEmployeeHours(String hoursWorkedString) {
        final String[] attendanceEmployee = hoursWorkedString.split(",");
        attendanceList = new ArrayList<>();
        for (String attendance : attendanceEmployee) {
            final String day = attendance.substring(0, 2);
            final String hoursAttended = attendance.substring(2);
            final int startTime = Integer.parseInt(hoursAttended.split("-")[0].replace(":", "").trim());
            final int endTime = Integer.parseInt(hoursAttended.split("-")[1].replace(":", "").trim());

            attendanceList.add(new AtendanceModel(day, startTime, endTime));
        }
        return attendanceList;
    }

    @Override
    public List<AtendanceModel> getAttendanceList() {
        return this.attendanceList;
    }

}
