package priv.tiba.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Equation {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    private String holder;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    private String words;
    private int left1;

    public int getLeft1() {
        return left1;
    }

    public void setLeft1(int left1) {
        this.left1 = left1;
    }

    public int getLeft2() {
        return left2;
    }

    public void setLeft2(int left2) {
        this.left2 = left2;
    }

    public int getRight1() {
        return right1;
    }

    public void setRight1(int right1) {
        this.right1 = right1;
    }

    public int getRight2() {
        return right2;
    }

    public void setRight2(int right2) {
        this.right2 = right2;
    }

    private int left2;
    private int right1;
    private int right2;

    public Equation(){
        Random random = new Random();
        String[] holders = new String[]{"x", "y", "a", "b"};
        this.holder = holders[random.nextInt(3)];
        this.value = random.nextInt(13);
        this.left1 = 1;
        this.left2 = this.right1 = 0;
        this.right2 = this.value;
        this.confusion();
        this.words = initWords();
    }

    private void confusion(){
        Random random = new Random();
        int mul = random.nextInt(15) + 1;
        this.left1 *= mul;
        this.right2 *= mul;
        int tag = random.nextInt(3);
        int change = random.nextInt(13);
        switch (tag){
            case 1:this.left1+=change;this.right1+=change;break;
            case 2:this.left1-=change;this.right1-=change;break;
        }
        tag = random.nextInt(3);
        change = random.nextInt(25);
        switch (tag){
            case 1:this.left2+=change;this.right2+=change;break;
            case 2:this.left2-=change;this.right2-=change;break;
        }
    }

    private String initWords(){
        String left;
        String right;
        String holder1, holder2;
        if(this.left1 == 1){
            holder1 = this.holder;
        }else if(this.left1 == -1){
            holder1 = "-" + this.holder;
        }else{
            holder1 = this.left1 + this.holder;
        }
        if(this.right1 == 1){
            holder2 = this.holder;
        }else if(this.right1 == -1){
            holder2 = "-" + this.holder;
        }else{
            holder2 = this.right1 + this.holder;
        }
        Random random = new Random();
        if(this.left1 == 0){
            left = String.valueOf(this.left2);
        }else{
            if(this.left2 == 0){
                left = holder1;
            }else if(this.left2 > 0){
                int tag = random.nextInt(2);
                if(tag == 0){
                    left = holder1 + " + " + this.left2;
                }else{
                    if(this.left1 > 0){
                        left = this.left2 + " + " + holder1;
                    }else{
                        if(this.left1 == -1){
                            left = this.left2 + " - " + this.holder;
                        }else{
                            left = this.left2 + " - " + Math.abs(this.left1) + this.holder;
                        }
                    }
                }
            }else{
                left = holder1 + " - " + Math.abs(this.left2);
            }
        }
        if(this.right1 == 0){
            right = String.valueOf(this.right2);
        }else{
            if(this.right2 == 0){
                right = holder2;
            }else if(this.right2 > 0){
                int tag = random.nextInt(2);
                if(tag == 0){
                    right = holder2 + " + " + this.right2;
                }else{
                    if(this.right1 > 0){
                        right = this.right2 + " + " + holder2;
                    }else{
                        if(this.right1 == -1){
                            right = this.right2 + " - " + this.holder;
                        }else{
                            right = this.right2 + " - " + Math.abs(this.right1) + this.holder;
                        }
                    }
                }
            }else{
                right = holder2 + " - " + Math.abs(this.right2);
            }
        }
        return left + " = " + right;
    }

    public static void main(String[] args){
        Equation[] equations = new Equation[20];
        for(Equation equation : equations){
            equation = new Equation();
            System.out.println(equation.getWords());
        }
    }
}
