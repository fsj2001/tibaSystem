package priv.tiba.core;


import java.util.List;

public class AddGenerator extends Generator{
    public AddGenerator(Generator generator1, Generator generator2){
        super(generator1.getResult(), generator2.getResult());
        this.setRank(2);
        this.setResult(generator1.getResult()+generator2.getResult());
        this.setWords(generator1.getWords()+"+"+generator2.getWords());
    }

    public AddGenerator(Generator generator){
        super(generator.getResult());
        this.setRank(2);
        this.setWords(Double.toString(generator.getResult()));
    }

    public static void main(String[] args){

    }
}
