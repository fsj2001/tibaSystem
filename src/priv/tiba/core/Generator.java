package priv.tiba.core;

public class Generator {
    private double num1;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    private double num2;
    private double result;
    private boolean isSingle;
    private int rank;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    private String words;

    public Generator(double num1, double num2){
        this.setNum1(num1);
        this.setNum2(num2);
        this.setSingle(false);
    }

    public Generator(double num){
        this.setNum1(num);
        this.setResult(num);
        this.setSingle(true);
        this.setWords(Double.toString(num));
    }
}
