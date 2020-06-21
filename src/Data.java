public class Data {
    private String year;
    private int sum = 0;
    private int qq;

    public Data(String year, int sum, int qq) {
        this.year = year;
        this.sum = sum;
        this.qq = qq;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }
}
