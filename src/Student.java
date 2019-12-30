import java.io.InputStream;
import java.sql.Date;

public class Student {
    private long id;
    private String rollNo;
    private String studentName;
    private String branch;
    private String emailId;
    private String password;
    private String category;
    private float feeAmount;
    private Date feeDueDate;
    private InputStream studentPhoto;

    public long getId(long id) {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(float feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Date getFeeDueDate() {
        return feeDueDate;
    }

    public void setFeeDueDate(Date feeDueDate) {
        this.feeDueDate = feeDueDate;
    }

    public InputStream getStudentPhoto() {
        return studentPhoto;
    }

    public void setStudentPhoto(InputStream studentPhoto) {
        this.studentPhoto = studentPhoto;
    }
}
