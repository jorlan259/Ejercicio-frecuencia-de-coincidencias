package src.models;

import java.util.List;

public class EmployeeModel {
    private String nameEmployee;
    private List<AtendanceModel> attendanceList;

    public EmployeeModel(String nameEmployee, List<AtendanceModel> attendanceList) {
        this.nameEmployee = nameEmployee;
        this.attendanceList = attendanceList;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setAttendanceList(List<AtendanceModel> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public List<AtendanceModel> getAttendanceList() {
        return attendanceList;
    }
}
