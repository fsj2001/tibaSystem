package priv.tiba.core;

import java.util.Stack;

public class MultiplyGenerator extends Generator{
    public MultiplyGenerator(Generator generator1, Generator generator2){
        super(generator1.getResult(), generator2.getResult());
        this.setRank(1);
        this.setResult(generator1.getResult()*generator2.getResult());
        this.setWords(generator1.getWords()+"X"+generator2.getWords());
    }

    public MultiplyGenerator(Generator generator){
        super(generator.getResult());
        this.setRank(1);
        this.setWords(Double.toString(generator.getResult()));
    }
}
