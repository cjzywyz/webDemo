package Entity;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class Student {
    public int stu_id;
    public String stu_name;
    public String stu_userNum;
    public String stu_userPassword;
    public String stu_back01;
    public String stu_back02;
    public String stu_back03;

    public Student(){

    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_userNum() {
        return stu_userNum;
    }

    public void setStu_userNum(String stu_userNum) {
        this.stu_userNum = stu_userNum;
    }

    public String getStu_userPassword() {
        return stu_userPassword;
    }

    public void setStu_userPassword(String stu_userPassword) {
        this.stu_userPassword = stu_userPassword;
    }

    public String getStu_back01() {
        return stu_back01;
    }

    public void setStu_back01(String stu_back01) {
        this.stu_back01 = stu_back01;
    }

    public String getStu_back02() {
        return stu_back02;
    }

    public void setStu_back02(String stu_back02) {
        this.stu_back02 = stu_back02;
    }

    public String getStu_back03() {
        return stu_back03;
    }

    public void setStu_back03(String stu_back03) {
        this.stu_back03 = stu_back03;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_userNum='" + stu_userNum + '\'' +
                ", stu_userPassword='" + stu_userPassword + '\'' +
                ", stu_back01='" + stu_back01 + '\'' +
                ", stu_back02='" + stu_back02 + '\'' +
                ", stu_back03='" + stu_back03 + '\'' +
                '}';
    }

    public Student( String stu_name, String stu_userNum, String stu_userPassword, String stu_back01, String stu_back02, String stu_back03) {
        this.stu_name = stu_name;
        this.stu_userNum = stu_userNum;
        this.stu_userPassword = stu_userPassword;
        this.stu_back01 = stu_back01;
        this.stu_back02 = stu_back02;
        this.stu_back03 = stu_back03;
    }
}
