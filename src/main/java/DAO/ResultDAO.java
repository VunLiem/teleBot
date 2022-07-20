package DAO;

public class ResultDAO {
    private double sum;
    private String date;

    public ResultDAO(Double sum, String date) {
        this.sum = sum;
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public String getDate() {
        return date;
    }
}
