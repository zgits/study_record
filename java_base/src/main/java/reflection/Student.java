package reflection;


/**
 * 反射study
 */
public class Student {


    private String studentName;
    public int age;

    public Student() {
    }

    private Student(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    private String show(String message) {
        System.out.println(message);
        return "show message";
    }
}
