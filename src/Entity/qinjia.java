package Entity;

/**
 * @author kj
 * @date 2022/5/11
 * @apiNote
 */
public class qinjia {
    public String college;
    public String professional;
    public String classes;
    public String cause;
    public String teachername;
    public String backDays;
    public String severalDays;
    public String days;
    public String phoneNum;
    public String parentsPhoneNum;
    public String name;
    public String userNum;
    public String qinjia_comment;
    public boolean isconsent;
    public boolean isconsent2;
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public qinjia() {
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getBackDays() {
        return backDays;
    }

    public void setBackDays(String backDays) {
        this.backDays = backDays;
    }

    public String getSeveralDays() {
        return severalDays;
    }

    public void setSeveralDays(String severalDays) {
        this.severalDays = severalDays;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getParentsPhoneNum() {
        return parentsPhoneNum;
    }

    public void setParentsPhoneNum(String parentsPhoneNum) {
        this.parentsPhoneNum = parentsPhoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getQinjia_comment() {
        return qinjia_comment;
    }

    public void setQinjia_comment(String qinjia_comment) {
        this.qinjia_comment = qinjia_comment;
    }

    public boolean isIsconsent() {
        return isconsent;
    }

    public boolean isIsconsent2() {
        return isconsent2;
    }

    public void setIsconsent2(boolean isconsent2) {
        this.isconsent2 = isconsent2;
    }

    public void setIsconsent(boolean isconsent) {
        this.isconsent = isconsent;
    }

    @Override
    public String toString() {
        return "qinjia{" +
                "college='" + college + '\'' +
                ", professional='" + professional + '\'' +
                ", classes='" + classes + '\'' +
                ", cause='" + cause + '\'' +
                ", teachername='" + teachername + '\'' +
                ", backDays='" + backDays + '\'' +
                ", severalDays='" + severalDays + '\'' +
                ", days='" + days + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", parentsPhoneNum='" + parentsPhoneNum + '\'' +
                ", name='" + name + '\'' +
                ", userNum='" + userNum + '\'' +
                ", qinjia_comment='" + qinjia_comment + '\'' +
                ", isconsent=" + isconsent +
                ", isconsent2=" + isconsent2 +
                ", id=" + id +
                '}';
    }

    public qinjia(String college, String professional, String classes, String cause, String teachername, String backDays, String severalDays, String days, String phoneNum, String parentsPhoneNum, String name, String userNum, String qinjia_comment, boolean isconsent, boolean isconsent2) {
        this.college = college;
        this.professional = professional;
        this.classes = classes;
        this.cause = cause;
        this.teachername = teachername;
        this.backDays = backDays;
        this.severalDays = severalDays;
        this.days = days;
        this.phoneNum = phoneNum;
        this.parentsPhoneNum = parentsPhoneNum;
        this.name = name;
        this.userNum = userNum;
        this.qinjia_comment = qinjia_comment;
        this.isconsent = isconsent;
        this.isconsent2 = isconsent2;
    }
}
