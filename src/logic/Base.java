package src.logic;

import java.util.ArrayList;
import java.util.List;

import src.models.AtendanceModel;
import src.models.EmployeeModel;
import src.models.ResultModel;

public class Base {

    public int getMatchTimes(List<AtendanceModel> atendanceMainEmployee, List<AtendanceModel>atendanceSecondEmployee){
        int matches = 0;
        for (AtendanceModel atendanceMain : atendanceMainEmployee) {
            for (AtendanceModel atendanceSecond : atendanceSecondEmployee) {
                if(atendanceMain.getDay().equals(atendanceSecond.getDay())){
                    boolean isMatched = isTheTimeMatched(atendanceMain, atendanceSecond);
                    if(isMatched){
                        matches+=1;
                    }
                }
            }
        }
        return matches;
    }

    public boolean isTheTimeMatched(AtendanceModel firstEmployee, AtendanceModel secondEmployee ){
        boolean isCoincident = false;
        if(firstEmployee.equals(secondEmployee)){
            isCoincident = true;
        }else{
            if(firstEmployee.getStartTime()>=secondEmployee.getStartTime() && firstEmployee.getStartTime() <= secondEmployee.getEndTime()){
                isCoincident = true;
            }else if(firstEmployee.getEndTime()>=secondEmployee.getStartTime() && firstEmployee.getEndTime() <= secondEmployee.getEndTime()){
                isCoincident = true;
            }else if(secondEmployee.getStartTime()>=firstEmployee.getStartTime() && secondEmployee.getStartTime() <= firstEmployee.getEndTime()){
                isCoincident = true;
            }else if(secondEmployee.getEndTime()>=firstEmployee.getStartTime() && secondEmployee.getEndTime() <= firstEmployee.getEndTime()){
                isCoincident = true;
            }
        }
        return isCoincident;
    }

    public boolean doTheNameExistInTheList(List<ResultModel> listResult, String fisrtEmployee, String secondEmployee){
        boolean nameExist = false;
       for (ResultModel resultModel : listResult) {
           if(
              ( resultModel.getFirsEmployee().equals(fisrtEmployee) || resultModel.getFirsEmployee().equals(secondEmployee)) &&
              (resultModel.getSecondEmployee().equals(fisrtEmployee) || resultModel.getSecondEmployee().equals(secondEmployee))
            ){
                nameExist = true;
                break;
            }
       }
        return nameExist;
    }

    public void searchMatched(List<EmployeeModel> objectStaff){
        List<ResultModel> listResult = new ArrayList<>();
        for (EmployeeModel  mainEmployee: objectStaff) {
            for (EmployeeModel secondEmployee : objectStaff) {
                if(!secondEmployee.getNameEmployee().equals(mainEmployee.getNameEmployee())){
                    int matches = getMatchTimes(mainEmployee.getAttendanceList(), secondEmployee.getAttendanceList());
                    if(matches>0){
                        if(!doTheNameExistInTheList(listResult,mainEmployee.getNameEmployee(),secondEmployee.getNameEmployee())){
                            System.out.println(mainEmployee.getNameEmployee()+" -- "+secondEmployee.getNameEmployee()+": "+matches);
                            listResult.add(new ResultModel(mainEmployee.getNameEmployee(), secondEmployee.getNameEmployee(), matches));
                        }
                    }
                }
            }
        }
    }
    
}
