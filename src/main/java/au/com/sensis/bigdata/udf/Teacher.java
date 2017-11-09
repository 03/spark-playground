package au.com.sensis.bigdata.udf;

import java.io.Serializable;
import java.util.List;

/**
 * Created by orp on 09/11/17.
 */
public class Teacher implements Serializable {

    private String id;
    private String name;
    private Integer age;
    private String[] studentArray;
    private List<String> studentList;

    public Teacher() {
    }

    public Teacher(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Teacher(String id, String name, Integer age, String[] studentArray, List<String> studentList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.studentArray = studentArray;
        this.studentList = studentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getStudentArray() {
        return studentArray;
    }

    public void setStudentArray(String[] studentArray) {
        this.studentArray = studentArray;
    }

    public List<String> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<String> studentList) {
        this.studentList = studentList;
    }
}
