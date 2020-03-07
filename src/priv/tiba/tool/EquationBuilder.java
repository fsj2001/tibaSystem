package priv.tiba.tool;

import priv.tiba.pojo.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EquationBuilder {
    public static List<Question> getEquationList(String type, String amount){
        List<Question> questionList = new ArrayList<>();
        int num = Integer.parseInt(amount);
        Random random = new Random();
        for(int i=0;i<num;i++){
            Equation equation = new Equation();
            Question question = new Question();
            question.setType(type);
            question.setTitle("解方程："+equation.getWords()+" ,"+equation.getHolder()+"=?");
            if(type.equals("fill")){
                question.setKnowledgePoint("2");
                question.setQuestionKey(String.valueOf(equation.getValue()));
            }else{
                int[] wrongAnswers = new int[5];
                wrongAnswers[0] = equation.getValue() + 1;
                wrongAnswers[1] = equation.getValue() + 2;
                wrongAnswers[2] = equation.getValue() + 3;
                wrongAnswers[3] = equation.getValue() - 1;
                wrongAnswers[4] = equation.getValue() - 2;
                int itemNum = random.nextInt(3) + 2;
                int rightIndex = random.nextInt(itemNum);
                List<String> itemList = new ArrayList<>();
                boolean[] hashTable = new boolean[itemNum];
                for(int j=0;j<rightIndex;j++){
                    int wrongIndex = random.nextInt(itemNum);
                    if(!hashTable[wrongIndex]){
                        hashTable[wrongIndex] = true;
                        itemList.add(String.valueOf(wrongAnswers[wrongIndex]));
                    }
                }
                itemList.add(String.valueOf(equation.getValue()));
                for(int j=rightIndex+1;j<itemNum;j++){
                    int wrongIndex = random.nextInt(itemNum);
                    if(!hashTable[wrongIndex]){
                        hashTable[wrongIndex] = true;
                        itemList.add(String.valueOf(wrongAnswers[wrongIndex]));
                    }
                }
                question.setItemList(itemList);
                question.setKnowledgePoint("2");
                switch (rightIndex){
                    case 0:question.setQuestionKey("A");break;
                    case 1:question.setQuestionKey("B");break;
                    case 2:question.setQuestionKey("C");break;
                    case 3:question.setQuestionKey("D");break;
                }
            }
            questionList.add(question);
        }
        return questionList;
    }
}
