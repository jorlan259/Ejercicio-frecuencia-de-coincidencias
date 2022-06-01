package src.models;

public class ResultModel {
    private String firsEmployee;
    private String secondEmployee;
    private int matches;

    public ResultModel(String firstEmployee, String secondEmployee, int matches) {
        this.firsEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
        this.matches = matches;
    }

    public void setFirsEmployee(String firsEmployee) {
        this.firsEmployee = firsEmployee;
    }

    public String getFirsEmployee() {
        return firsEmployee;
    }

    public void setSecondEmployee(String secondEmployee) {
        this.secondEmployee = secondEmployee;
    }

    public String getSecondEmployee() {
        return secondEmployee;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getMatches() {
        return matches;
    }
}
