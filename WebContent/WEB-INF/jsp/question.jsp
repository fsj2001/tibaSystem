<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/1/17
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>题霸系统</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/iconfont.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/test.css" rel="stylesheet" type="text/css" />

    <style>
        .hasBeenAnswer {
            background: #5d9cec;
            color:#fff;
        }

    </style>
</head>

<body>
<div class="main">
    <!--nr start-->
    <div class="test_main">
        <div class="nr_left">
            <div class="test">
                <form action="" method="post" id="mainForm">
                    <div class="test_title" id="submit-answer">
                        <p class="test_time" id="timeRecord">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1"></b>
                        </p>
                        <font><input name="test_jiaojuan" id="submitAnswer" value="交卷" type="button"></font>
                    </div>
                    <div class="test_content" id="chooseContent">
                        <div class="test_content_title">
                            <h2>单选题</h2>
                            <p>
                                <span>共</span><i class="content_lit" id="chooseNum"></i><span>题，</span><span>合计</span><i class="content_fs" id="choosePoint"></i><span>分</span>
                            </p>
                        </div>
                    </div>
                    <div class="test_content_nr" id="choose_questions_div">
                        <ul id="choose_questions_ul"></ul>
                    </div>

                    <div class="test_content" id="fillContent">
                        <div class="test_content_title">
                            <h2>填空题</h2>
                            <p>
                                <span>共</span><i class="content_lit" id="fillNum"></i><span>题，</span><span>合计</span><i class="content_fs" id="fillPoint"></i><span>分</span>
                            </p>
                        </div>
                    </div>
                    <div class="test_content_nr" id="fill_question_div">
                        <ul id="fill_question_ul">
                            <li id="qu_1_0">
                                <div class="test_content_nr_tt">
                                    <i>1</i><span>(1分)</span><font>0.73 × 6 = </font><input></input><b class="icon iconfont">&#xe881;</b>
                                </div>
                            </li>
                        </ul>
                        <div id="div_1_answer_1"></div>
                    </div>
                    <div style="height:50px"></div>
                </form>
            </div>
        </div>
        <div class="nr_right">
            <div class="nr_rt_main">
                <div class="rt_nr1">
                    <div class="rt_nr1_title">
                        <h1>
                            <i class="icon iconfont">&#xe692;</i>答题卡
                        </h1>
                        <p class="test_time" id="time2">
                            <i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:00</b>
                        </p>
                    </div>

                    <div class="rt_content" id="chooseRecord">
                        <div class="rt_content_tt">
                            <h2>单选题</h2>
                            <p>
                                <span>共</span><i class="content_lit" id="chooseNum2"></i><span>题</span>
                            </p>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="choose_record_ul"></ul>
                        </div>
                    </div>

                    <div class="rt_content" id="fillRecord">
                        <div class="rt_content_tt">
                            <h2>填空题</h2>
                            <p>
                                <span>共</span><i class="content_lit" id="fillNum2"></i><span>题</span>
                            </p>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="fill_record_ul"></ul>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
    <!--nr end-->
    <div class="foot"></div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<!--时间js-->
<script src="${pageContext.request.contextPath}/js/jquery.countdown.js"></script>
<script charset="utf-8">
    window.jQuery(function($) {
        "use strict";

        $('time').countDown({
            with_separators : false
        });
        $('.alt-1').countDown({
            css_class : 'countdown-alt-1'
        });
        $('.alt-2').countDown({
            css_class : 'countdown-alt-2'
        });

    });

    var Q = {};


    $(function() {
        var D = {};
        var disc=["A", "B", "C", "D"];
        var chooseN=0;
        var fillN=0;
        var cnt=0;
        var questionList = ${questionList};
        <%--alert('${questionList.get(0).title}');--%>
        for(var i=0;i<${questionList.size()};i++){
            if(questionList[i].type=='choose'){
                chooseN++;
            }else if(questionList[i].type=='fill'){
                fillN++;
            }
        }
        if('${time}'=='any'){
            $('#timeRecord').hide();
            $('#time2').hide();
        }else{
            //设置时间的情况
        }
        $('#chooseNum').text(chooseN);
        $('#choosePoint').text(chooseN);
        $('#chooseNum2').text(chooseN);
        $('#fillNum').text(fillN);
        $('#fillPoint').text(fillN);
        $('#fillNum2').text(fillN);
        if(chooseN==0){
            $('#chooseContent').hide();
            $('#choose_questions_div').hide();
            $('#chooseRecord').hide();
        }else{
            var completeContent="";
            var recordContent="";
            for(var i=0;i<questionList.length;i++){
                if(questionList[i].type!="choose")
                    continue;
                cnt++;
                var liId="qu_0_"+(cnt-1);
                Q[liId] = questionList[i];
                var chooseQuestionContent;
                chooseQuestionContent = "<li id=\""+liId+"\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<div class=\"test_content_nr_tt\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<i>"+(i+1)+"</i><span>(1 point)</span><font>"+questionList[i].title+"</font><b class=\"icon iconfont\">&#xe881;</b>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<div class=\"test_content_nr_main\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<ul>";
                for(var j=0;j<questionList[i].itemList.length;j++){
                    var chooseQuestionItemContent;
                    chooseQuestionItemContent = "<li class=\"option\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" class=\"radioOrCheck\" name=\"answer"+(cnt)+"\" id=\"0_answer_"+(cnt)+"_option_"+(j+1)+"\"\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t/>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"0_answer_"+cnt+"_option_"+(j+1)+"\">\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+disc[j]+".\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p class=\"ue\" style=\"display: inline;\">"+questionList[i].itemList[j]+"</p>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</li>";
                    chooseQuestionContent = chooseQuestionContent + chooseQuestionItemContent;
                }
                chooseQuestionContent = chooseQuestionContent+"</ul>\n" +
                    "<div id=\"div_0_answer_"+(cnt)+"\"></div>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t\t\t</li>";
                completeContent = completeContent + chooseQuestionContent;
                recordContent += "<li><a href=\"#qu_0_"+i+"\">"+cnt+"</a></li>";
            }
            $("#choose_questions_ul").html(completeContent);
            $('#choose_record_ul').html(recordContent);
        }
        if(fillN==0){
            $('#fillContent').hide();
            $('#fill_question_div').hide();
            $('#fillRecord').hide();
        }else{
            var completeContent="";
            var recordContent="";
            for(var i=0;i<questionList.length;i++){
                if(questionList[i].type!="fill")
                    continue;
                cnt++;
                var liId="qu_1_"+i;
                Q[liId] = questionList[i];
                var fillQuestionContent="<li id=\""+liId+"\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<div class=\"test_content_nr_tt\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<i>"+(i+1)+"</i><span>(1 point)</span><font>"+questionList[i].title+"</font><input id=\"1_answer_"+cnt+"\" name=\"answer"+cnt+"\"></input><b class=\"icon iconfont\">&#xe881;</b>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "<div id=\"div_1_answer_"+cnt+"\"></div>" +
                    "\t\t\t\t\t\t\t\t\t\t</li>";
                completeContent = completeContent + fillQuestionContent;
                recordContent += "<li><a href=\"#qu_1_"+i+"\">"+cnt+"</a></li>"
            }
            $("#fill_question_ul").html(completeContent);
            $('#fill_record_ul').html(recordContent);
        }



        $('li.option label').click(function() {
            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
            $('#'+examId).find("input").val("no");
            $(this).val("yes");
            var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
            // 设置已答题
            if(!cardLi.hasClass('hasBeenAnswer')){
                cardLi.addClass('hasBeenAnswer');
            }

        });

        $('li.option input').click(function(){
            var examId = $(this).closest('li').attr('id'); // 得到题目ID
            $('#'+examId).find("input").val("no");
            $(this).val("yes");
            var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
        // 设置已答题
            if(!cardLi.hasClass('hasBeenAnswer')){
                cardLi.addClass('hasBeenAnswer');
            }
        });

        $('div.test_content_nr_tt input').click(function () {
            var examId = $(this).closest('li').attr('id'); // 得到题目ID
            var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
            // 设置已答题
            if(!cardLi.hasClass('hasBeenAnswer')){
                cardLi.addClass('hasBeenAnswer');
            }
        });


        $('#submitAnswer').click(function () {
            var tag=1;
            for(var k=0;k<questionList.length;k++){
                var cardLi1=$('a[href=#qu_0_' + k + ']');
                var cardLi2=$('a[href=#qu_1_' + k + ']');
                if(cardLi1.length>0&&!cardLi1.hasClass('hasBeenAnswer')){
                    tag=0;
                }
                if(cardLi2.length>0&&!cardLi2.hasClass('hasBeenAnswer')){
                    tag=0;
                }
            }
            if(tag==1){
                if(confirm("确认提交？")){
                    getAnswer();
                }
            }else{
                if(confirm("您还有未答的题，确认提交？")){
                    getAnswer();
                }
            }
        });

        $('body').on('click', '.status1', function () {
            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id');
            if(typeof(examId) == "undefined"){
                examId = $(this).parent().parent().attr('id');
            }
            var that = $(this);
            var postData={
                title:Q[examId].title,
                key:Q[examId].questionKey,
                type:Q[examId].type,
                itemList:Q[examId].itemList,
                knowledgePoint:Q[examId].knowledgePoint,
                answer:D[examId]
            };

            $.ajax({
                type: 'POST',
                url:'${pageContext.request.contextPath}/setMistakeQuestion.action',
                data:JSON.stringify(postData),
                dataType:'text',
                contentType: 'application/json;charset=UTF-8',
                success:function (data) {
                    that.attr('class', 'status2');
                    that.text('已放入错题集');
                }
            })


        })

        function getAnswer() {
            var rightAmount = 0;
            for(var i=0;i<questionList.length;i++){
                var answer="(空)";
                if(questionList[i].type=="choose"){
                    for(var j=0;j<questionList[i].itemList.length;j++){
                        if($('#0_answer_'+(i+1)+'_option_'+(j+1)).val()=="yes"){
                            switch (j) {
                                case 0:answer="A";break;
                                case 1:answer="B";break;
                                case 2:answer="C";break;
                                case 3:answer="D";break;
                            }
                            $('#0_answer_'+(i+1)+'_option_'+(j+1)).attr("checked", "checked");
                        }
                        $('#0_answer_'+(i+1)+'_option_'+(j+1)).attr("disabled", "disabled");
                    }
                    $('#div_0_answer_'+(i+1)).text('所选答案：'+answer+" 正确答案："+questionList[i].questionKey);
                    if(answer==questionList[i].questionKey){
                        rightAmount ++;
                        $('#div_0_answer_'+(i+1)).addClass("green");
                    }else{
                        $('#div_0_answer_'+(i+1)).addClass("red");
                    }
                    $('#div_0_answer_'+(i+1)).append('<a class="status1">放入错题集</a>');
                    D['qu_0_'+i] = answer;
                }else{
                    if($('#1_answer_'+(i+1)).val().length > 0)
                        answer=$('#1_answer_'+(i+1)).val();
                    $('#div_1_answer_'+(i+1)).text('所填答案：'+answer+" 正确答案："+questionList[i].questionKey);
                    if(answer==questionList[i].questionKey){
                        rightAmount ++;
                        $('#div_1_answer_'+(i+1)).addClass("green");
                    }else{
                        $('#div_1_answer_'+(i+1)).addClass("red");
                    }
                    $('#div_1_answer_'+(i+1)).append('<a class="status1">放入错题集</a>');
                    D['qu_1_'+i] = answer;
                }
            }

            var postData = {
                questionAmount:questionList.length,
                rightAmount:rightAmount
            };

            $.ajax({
                type:'POST',
                url:'${pageContext.request.contextPath}/createNewRecord.action',
                data:JSON.stringify(postData),
                dataType:'text',
                contentType: 'application/json;charset=UTF-8',
                succeed:function (data) {
                    alert(data);
                },
                error:function () {
                    alert('wuwuwu');
                }
            })

        };

    });

</script>
<style type="text/css">
    .green{
        color:green;
    }

    .red{
        color:red;
    }

    [class ^= 'status']{
        font-weight: 200;
        font-size: 16px;
        font-family: "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;
        text-decoration: none;
        text-align: center;
        line-height: 40px;
        height: 40px;
        padding: 0 40px;
        display: inline-block;
        cursor: pointer;
        border: none;
        box-sizing: border-box;
        transition-property: all;
        transition-duration: .3s;
        color: #fff;
        background: #EF4DB6;
        transition: .8s;
        border-radius: 200px;
        margin-left:70%;
    }
    .status1:hover{
        transform: scale(1.2, 1.2)
    }
    .status2{
        cursor: not-allowed;
        opacity:60%;
    }
</style>
</body>

</html>