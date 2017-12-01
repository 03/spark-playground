package au.com.sensis.bigdata.csv;

import com.opencsv.bean.CsvBindByName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Student {

    @CsvBindByName(required = true, column = "STUDENT ID")
    private String id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private int age;
    @CsvBindByName
    private String hobby;

    public Student() {
    }

    public Student(String id, String name, int age, String hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("age", age)
                .append("hobby", hobby)
                .toString();
    }
}
