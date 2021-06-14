public class Studentview {
    private int total = 0;
    private StudentList students = new StudentList(100);

    public void enterMainMenu() {
        boolean loopFlag = true;
        do {
            System.out
                    .println("\n-----------------学生管理系统-----------------\n");
            System.out.println("                   1 添 加 学 生");
            System.out.println("                   2 修 改 学 生");
            System.out.println("                   3 删 除 学 生");
            System.out.println("                   4 学 生 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");
            char key = CMUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewStudent();
                    break;
                case '2':
                    modifyStudent();
                    break;
                case '3':
                    deleteStudent();
                    break;
                case '4':
                    listAllStudent();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        } while (loopFlag);


    }

    private void addNewStudent() {
        System.out.println("---------------------添加学生---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("成绩：");
        double performance = CMUtility.readdouble();
        Student stu = new Student(name, gender, age, performance);
        boolean flag = students.addStudent(stu);
    }

    private void modifyStudent() {
        System.out.println("---------------------修改学生---------------------");

        int index = 0;
        Student stu = null;
        for (; ; ) {
            System.out.print("请选择待修改学生编号(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }
            stu = students.getStudent(index - 1);
            if (stu == null) {
                System.out.println("无法找到学生！");
            } else
                break;
        }
        System.out.print("姓名(" + stu.getName() + ")：");
        String name = CMUtility.readString(4, stu.getName());

        System.out.print("性别(" + stu.getGender() + ")：");
        char gender = CMUtility.readChar(stu.getGender());

        System.out.print("年龄(" + stu.getAge() + ")：");
        int age = CMUtility.readInt(stu.getAge());
        System.out.print("成绩：");
        double performance = CMUtility.readdouble();
        stu = new Student(name, gender, age, performance);
        boolean flag = students.replaceStudent(index - 1, stu);
        if (flag) {
            System.out
                    .println("---------------------修改完成---------------------");
        } else {
            System.out.println("----------无法找到指定学生,修改失败--------------");
        }
    }

    private void deleteStudent() {
        System.out.println("---------------------删除学生---------------------");

        int index = 0;
        Student stu = null;
        for (; ; ) {
            System.out.print("请选择待删除学生编号(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }

            stu = students.getStudent(index - 1);
            if (stu == null) {
                System.out.println("无法找到指定学生！");
            } else
                break;
        }

        System.out.print("确认是否删除(Y/N)：");
        char yn = CMUtility.readConfirmSelection();
        if (yn == 'N')
            return;

        boolean flag = students.deleteStudent(index - 1);
        if (flag) {
            System.out
                    .println("---------------------删除完成---------------------");
        } else {
            System.out.println("----------无法找到指定学生,删除失败--------------");
        }
    }

    private void listAllStudent() {
        System.out.println("---------------------------学生列表---------------------------");
        Student[] stu = students.getAllStudents();
        if (stu.length == 0) {
            System.out.println("没有学生记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t成绩\t");
            for (int i = 0; i < stu.length; i++) {
                System.out.println((i + 1) + "\t" + stu[i].getDetails());
            }
        }

        System.out.println("-------------------------学生列表完成-------------------------");
    }
    public static void main(String[] args) {
        Studentview sView = new Studentview();
        sView.enterMainMenu();
    }
}
