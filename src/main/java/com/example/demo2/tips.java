package com.example.demo2;

public class tips {

    public static String tip = "" ;

    public tips(String tip) {
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public static String ChangeTip() {
        int number = 0;
        number = (int)Math.floor(Math.random()*(2-1+1)+1);
        if(number==1) {
            number = (int)Math.floor(Math.random()*(4-0+1)+0);
            switch(number) {
                case 0:
                    tip="Study with friends can increase your grades by 20%";
                    break;
                case 1:
                    tip="Take breaks during your study sessions";
                    break;
                case 2:
                    tip="Study with friends can increase your grades by 20%";
                    break;
                case 3:
                    tip="Study with friends can increase your grades by 20%";
                    break;
                case 4:
                    tip="Study with friends can increase your grades by 20%";
                    break;
            }
        }
        else {
            number = (int)Math.floor(Math.random()*(4-0+1)+0);
            switch(number) {
                case 0:
                    tip="Write everything down or put it on an agenda";
                    break;
                case 1:
                    tip="Make deadlines for every task";
                    break;
                case 2:
                    tip="Create tasklists or checklists";
                    break;
                case 3:
                    tip="Try to always follow the same routine";
                    break;
                case 4:
                    tip="Use your time efficiently";
                    break;
            }
        }

        return tip;
    }



}