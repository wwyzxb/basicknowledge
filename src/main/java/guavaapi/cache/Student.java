package guavaapi.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Vincent
 * @Date 2017/11/5 11:27
 */
public class Student {
    private int id;
    private String no;
    private String name;
    private String sex;
    private String mobilephone;
    private String mobilephonecity;

    public Student(int id, String no, String name, String sex, String mobilephone, String mobilephonecity) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.mobilephone = mobilephone;
        this.mobilephonecity = mobilephonecity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getMobilephonecity() {
        return mobilephonecity;
    }

    public void setMobilephonecity(String mobilephonecity) {
        this.mobilephonecity = mobilephonecity;
    }
}
