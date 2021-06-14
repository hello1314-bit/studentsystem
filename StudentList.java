public class StudentList {
    private Student[] students;
    private int total = 0;

    public StudentList(int totalStudent) {
        students = new Student[totalStudent];
    }

    public boolean addStudent(Student student) {
        if (total >= students.length)
            return false;

        students[total++] = student;
        return true;
    }

    public boolean replaceStudent(int index, Student stu) {
        if (index < 0 || index >= total)
            return false;

        students[index] = stu;
        return true;
    }

    public boolean deleteStudent(int index) {
        if (index < 0 || index >= total)
            return false;

        for (int i = index; i < total-1; i++) {
            students[i]=students[i+1];
        }
        students[--total]=null;

        return true;
    }
    public Student[] getAllStudents(){
        Student[] stus=new Student[total];
        for (int i = 0; i < total; i++) {
            stus[i]=students[i];
        }
        return stus;
    }
    public int getTotal() {
        return total;
    }

    public Student getStudent(int index) {
        if (index < 0 || index >= total)
            return null;

        return students[index];
    }


}