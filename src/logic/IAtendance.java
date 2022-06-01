package src.logic;

import java.util.List;

import src.models.AtendanceModel;

public interface IAtendance {

    public void getResult(String data);
    public List<AtendanceModel> getAttendanceList();
}
