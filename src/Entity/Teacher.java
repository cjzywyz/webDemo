package Entity;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class Teacher {
    public int tea_id;
    public String tea_name;
    public String tea_userNum;
    public String tea_userpassword;
    public String tea_back01;
    public String tea_back02;
    public String tea_back03;

    public Teacher(){}

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getTea_userNum() {
        return tea_userNum;
    }

    public void setTea_userNum(String tea_userNum) {
        this.tea_userNum = tea_userNum;
    }

    public String getTea_userpassword() {
        return tea_userpassword;
    }

    public void setTea_userpassword(String tea_userpassword) {
        this.tea_userpassword = tea_userpassword;
    }

    public String getTea_back01() {
        return tea_back01;
    }

    public void setTea_back01(String tea_back01) {
        this.tea_back01 = tea_back01;
    }

    public String getTea_back02() {
        return tea_back02;
    }

    public void setTea_back02(String tea_back02) {
        this.tea_back02 = tea_back02;
    }

    public String getTea_back03() {
        return tea_back03;
    }

    public void setTea_back03(String tea_back03) {
        this.tea_back03 = tea_back03;
    }

    public Teacher( String tea_name, String tea_userNum, String tea_userpassword, String tea_back01, String tea_back02, String tea_back03) {

        this.tea_name = tea_name;
        this.tea_userNum = tea_userNum;
        this.tea_userpassword = tea_userpassword;
        this.tea_back01 = tea_back01;
        this.tea_back02 = tea_back02;
        this.tea_back03 = tea_back03;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tea_id=" + tea_id +
                ", tea_name='" + tea_name + '\'' +
                ", tea_userNum='" + tea_userNum + '\'' +
                ", tea_userpassword='" + tea_userpassword + '\'' +
                ", tea_back01='" + tea_back01 + '\'' +
                ", tea_back02='" + tea_back02 + '\'' +
                ", tea_back03='" + tea_back03 + '\'' +
                '}';
    }
}
