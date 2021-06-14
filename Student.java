public class Student {
    private String name;
    private char gender;
    private int age;
    private double performance;

    public Student() {
    }

    public Student(String name, char gender, int age, double performance) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.performance = performance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }
    public String getDetails() {
        return name + "\t" + gender + "\t" + age + "\t\t" + performance ;
    }



}
