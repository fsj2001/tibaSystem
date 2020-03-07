package priv.tiba.core;

public class DivideGenerator extends Generator{
    public DivideGenerator(Generator generator1, Generator generator2){
        super(generator1.getResult(), generator2.getResult());
        this.setRank(1);
        this.setResult(generator1.getResult()/generator2.getResult());
        this.setWords(generator1.getWords()+"÷"+generator2.getWords());
    }

    public DivideGenerator(Generator generator){
        super(generator.getResult());
        this.setRank(1);
        this.setWords(Double.toString(generator.getResult()));
    }
}
