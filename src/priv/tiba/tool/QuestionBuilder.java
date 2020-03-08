package priv.tiba.tool;

import org.springframework.util.ResourceUtils;
import priv.tiba.pojo.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionBuilder {
    public static List<Question> getQuestion(String type, String knowledgePoint, String difficulty, String amount){
        List<Question> fillQuestionList = new ArrayList<>();
        String rootPath = null;
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath()+"priv/tiba/questionModel";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String fileName = null;
        fileName = rootPath+"/knowledgePoint"+knowledgePoint+"_"+difficulty;
        File[] files = new File(fileName).listFiles();
        int count = 0;//当前知识点和难度下存在的模式数目
        for(File file : files){
            if(file.getName().startsWith("model")){
                count++;
            }
        }

        //获取名字
        File nameFile = new File(rootPath+"/name.txt");
        String[] names = ReadQuestionModel.readQuestionModel(nameFile).get(0).split(",");
        Random random = new Random();

        //每个模式该抽几个题目
        List<Integer> list = RandomBuilder.getRandoms(Integer.valueOf(amount), count);

        for(int i=1;i<=count;i++){
            //读取模板文件、填充文件、答案文件
            File modelFile = new File(fileName+"/model"+String.valueOf(i)+".txt");
            File wordFile = new File(fileName+"/words"+String.valueOf(i)+".txt");
            File answerFile = new File(fileName+"/answer"+String.valueOf(i)+".txt");
            List<String> modelList = ReadQuestionModel.readQuestionModel(modelFile);
            List<String> wordList = ReadQuestionModel.readQuestionModel(wordFile);
            List<String> answerList = ReadQuestionModel.readQuestionModel(answerFile);
            for(int j=0;j<list.get(i-1);j++){
                int index = random.nextInt(modelList.size());
                String model = modelList.get(index);
                String word = wordList.get(index);
                String answer = answerList.get(index);
                String[] wordContents = word.split(";");
                String[] content = wordContents[random.nextInt(wordContents.length)].replaceAll("\n|\r","").split(",");
                int cnt = 0;
                while(model.contains("{p}")){
                    model = model.replaceFirst("\\{p\\}", content[cnt++]);
                }
                if(model.contains("{name}")){
                    String name = names[random.nextInt(names.length)];
                    model = model.replaceAll("\\{name\\}", name);
                }
                int cnti = 0;
                int cntd = 0;
                int[] contentI = new int[20];
                double[] contentD = new double[20];
                Pattern pattern1 = Pattern.compile("\\{i\\(\\d+(_\\d+)?\\)\\}");
                Pattern pattern2 = Pattern.compile("\\{d\\(\\d+(_\\d+)?\\.\\d+\\)\\}");
                Pattern pattern3 = Pattern.compile("\\{i\\d\\}");
                Pattern pattern4 = Pattern.compile("\\{d\\d\\}");
                Matcher m1 = pattern1.matcher(model);
                while(m1.find()){
                    int n;
                    if(m1.group().contains("_")){
                        int down = Integer.parseInt(model.substring(m1.start()+3, m1.start()+4));
                        int top = Integer.parseInt(model.substring(m1.start()+5, m1.start()+6));
                        n = random.nextInt(top-down)+down;
                    }else{
                        n = Integer.parseInt(model.substring(m1.start()+3, m1.start()+4));
                    }
                    int intNum = QuestionBuilder.getIntNum(n);
                    contentI[cnti++]=intNum;
                    model = model.replaceFirst("\\{i\\(\\d+(_\\d+)?\\)\\}", String.valueOf(intNum));
                    m1 = pattern1.matcher(model);
                }
                System.out.println(model+":"+contentI[0]+","+contentI[1]);
                //植树问题凑数据
                if(knowledgePoint.equals("4")&&contentI[0]>contentI[1]&&contentI[0]%contentI[1]!=0){
                    model = model.replaceFirst(String.valueOf(contentI[0]), String.valueOf(contentI[0]/contentI[1]*contentI[1]));
                    contentI[0] = contentI[0]/contentI[1]*contentI[1];
                }

                Matcher m2 = pattern2.matcher(model);
                while(m2.find()){
                    int n;
                    if(m2.group().contains("_")){
                        int down = Integer.parseInt(model.substring(m2.start()+3, m2.start()+4));
                        int top = Integer.parseInt(model.substring(m2.start()+5, m2.start()+6));
                        n = random.nextInt(top-down)+down;
                    }else{
                        n = Integer.parseInt(model.substring(m2.start()+3, m2.start()+4));
                    }
                    int intNum = QuestionBuilder.getIntNum(n);
                    n = Integer.parseInt(model.substring(m2.end()-3, m2.end()-2));
                    double doubleNum = intNum + QuestionBuilder.getDoubleNum(n);
                    contentD[cntd++]=doubleNum;
                    model = model.replaceFirst("\\{d\\(\\d+(_\\d+)?\\.\\d+\\)\\}", parseDoubleNum(doubleNum, n));
                    m2 = pattern2.matcher(model);
                }
                model = model.replaceAll("\n|\r", "");
                int leave = -1;
                if(answer.contains(",")){
                    leave = Integer.parseInt(answer.substring(answer.length()-1, answer.length()));
                    answer = answer.substring(0, answer.indexOf(','));
                }
                Matcher m3 = pattern3.matcher(answer);
                int index2;
                while(m3.find()){
                    index2 = Integer.parseInt(answer.substring(m3.start()+2, m3.start()+3));
                    answer = answer.replaceFirst("\\{i\\d\\}", String.valueOf(contentI[index2-1]));
                    m3 = pattern3.matcher(answer);
                }
                Matcher m4 = pattern4.matcher(answer);
                while(m4.find()){
                    index2 = Integer.parseInt(answer.substring(m4.start()+2, m4.start()+3));
                    answer = answer.replaceFirst("\\{d\\d\\}", String.valueOf(contentD[index2-1]));
                    m4 = pattern4.matcher(answer);
                }
                answer = answer.replaceAll("\n|\r", "");
                Calculator calculator = new Calculator();
                double result = calculator.calculate(answer);
                Question question = new Question();
                question.setTitle(model);
                question.setQuestionKey(parseDoubleNum(result, leave));
                question.setType(type);
                question.setKnowledgePoint(knowledgePoint);
                if(type.equals("choose")){
                    List<String> disturbances = new ArrayList<>();
                    File disturbanceFile = new File(fileName+"/disturbance"+String.valueOf(i)+".txt");
                    List<String> disturbanceList = ReadQuestionModel.readQuestionModel(disturbanceFile);
                    String disturbanace = disturbanceList.get(index);
                    String[] disturbanceContents = disturbanace.split(";");
                    int num = (new Random()).nextInt(2)+2;
                    boolean[] hashTable = new boolean[disturbanceContents.length];
                    for(int k=0;k<num;k++){
                        int select = (new Random().nextInt(hashTable.length));
                        if(!hashTable[select]){
                            hashTable[select] = true;
                            String disContent = disturbanceContents[select];
                            int leave2 = -1;
                            if(disContent.contains(",")){
                                leave2 = Integer.valueOf(disContent.substring(disContent.length()-1, disContent.length()));
                                disContent = disContent.substring(0, disContent.indexOf(','));
                            }
                            disContent = disContent.replaceAll("\n|\r", "");
                            m3 = pattern3.matcher(disContent);
                            while(m3.find()){
                                index2 = Integer.parseInt(disContent.substring(m3.start()+2, m3.start()+3));
                                disContent = disContent.replaceFirst("\\{i\\d\\}", String.valueOf(contentI[index2-1]));
                                m3 = pattern3.matcher(disContent);
                            }
                            m4 = pattern4.matcher(disContent);
                            while(m4.find()){
                                index2 = Integer.parseInt(disContent.substring(m4.start()+2, m4.start()+3));
                                disContent = disContent.replaceFirst("\\{d\\d\\}", String.valueOf(contentD[index2-1]));
                                m4 = pattern4.matcher(disContent);
                            }
                            disContent = disContent.replaceAll("\r|\n", "");
                            double diskey = calculator.calculate(disContent);
                            disturbances.add(parseDoubleNum(diskey, leave2));
                        }
                    }
                    int rightItemIndex = (new Random()).nextInt(disturbances.size()+1);
                    List<String> itemList = new ArrayList<>();
                    for(int ll=0;ll<rightItemIndex;ll++){
                        itemList.add(disturbances.get(ll));
                    }
                    itemList.add(question.getQuestionKey());
                    switch (rightItemIndex){
                        case 0:question.setQuestionKey("A");break;
                        case 1:question.setQuestionKey("B");break;
                        case 2:question.setQuestionKey("C");break;
                        case 3:question.setQuestionKey("D");break;
                    }
                    for(int ll=rightItemIndex+1;ll<disturbances.size()+1;ll++){
                        itemList.add(disturbances.get(ll-1));
                    }
                    question.setItemList(itemList);
                }
                fillQuestionList.add(question);
            }
        }
        return fillQuestionList;
    }

    public static int getIntNum(int n){
        if(n == 0){
            return 0;
        }
        int result = 1;
        for(int i=1;i<n;i++){
            result *= 10;
        }
        return (new Random()).nextInt(result*9)+result;
    }
    public static double getDoubleNum(int n){
        double result = (new Random()).nextInt(10);
        for(int i=0;i<n;i++){
            result /= 10;
        }
        return result;
    }
    public static String parseDoubleNum(double doubleNum, int leave){
        String result;
        switch (leave){
            case 0:result = String.valueOf((int)doubleNum);break;
            case 1:result = String.format("%.1f", doubleNum);break;
            case 2:result = String.format("%.2f", doubleNum);break;
            case 3:result = String.format("%.3f", doubleNum);break;
            default:result = String.valueOf(doubleNum);
        }
        return result;
    }


    public static void main(String[] args){
        getQuestion("choose","11", "easy", "10");
    }

}
