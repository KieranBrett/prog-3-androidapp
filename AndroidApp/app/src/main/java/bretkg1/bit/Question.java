package bretkg1.bit;

import java.util.Random;

public class Question {
    private int img1;
    private int img2;
    private int img3;
    private int img4;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String answer;
    private boolean answered;

    public Question(int img1, int img2, int img3, int img4, String str1, String str2, String str3, String str4, String answer){
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
        // Answer string makes it easy to check if they have won
        this.answer = answer;
        this.answered = false;
    }

    public void CheckAnswer(String str){
        if (str.equals(answer)){
            answered = true;
        }
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public int getImg3() {
        return img3;
    }

    public void setImg3(int img3) {
        this.img3 = img3;
    }

    public int getImg4() {
        return img4;
    }

    public void setImg4(int img4) {
        this.img4 = img4;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public String getStr4() {
        return str4;
    }

    public void setStr4(String str4) {
        this.str4 = str4;
    }
}
