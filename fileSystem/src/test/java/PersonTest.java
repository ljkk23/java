import java.util.Date;

class Person {

    //存储姓名
private String Name;
//电话号码
private String Tel;
//住址
private String Add;



    //电子邮件地址
private String EmailAdd;

    public Person(String name, String tel, String add, String emailAdd) {
        Name = name;
        Tel = tel;
        Add = add;
        EmailAdd = emailAdd;
    }

    public String getEmailAdd() {
            return EmailAdd;
        }

        public void setEmailAdd(String emailAdd) {
            EmailAdd = emailAdd;
        }

        public String getName(){

        return Name;

        }

        public String getTel(){

        return Tel;

        }

        public String getAdd(){

        return Tel;

        }

        public String toString() {

                return "姓名：" + Name + "，地址：" + Add + "，电话：" +Tel+",class:Person"+"电子邮件地址"+EmailAdd;

                }

}
class Student extends Person{

private int student_Grade;

public Student(String Name, String Tel,String Add,String EmailAdd,int student_Grade){

        super(Name,Tel,Add,EmailAdd);

        this.student_Grade=student_Grade;

        }

        public int getStudent_Grade() {

                return student_Grade;

                }

        public String toString() {

                return super.toString()+",年级："+student_Grade+",class:Student";

                }

        }

class Employee extends Person{
    //办公地点
    private String Office;
    //工资
    private double Salary;
    //受聘时间
    private Date workDate;

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Employee(String name, String tel, String add, String emailAdd, String office, double salary, Date workDate) {
        super(name, tel, add, emailAdd);
        Office = office;
        Salary = salary;
        this.workDate = workDate;
    }

    public String getOffice(){

        return Office;

    }

    public double getSalary(){

        return Salary;

    }

    public String toString() {

        return super.toString()+",办公室："+Office+"，工资:"+Salary+"受聘时间"+workDate+",class:Employee";

    }

}

class Faculty extends Employee
{
    //存储级别
    private String Level;
    //办公时间
    private String workTime;

    public Faculty(String name, String tel, String add, String emailAdd, String office, double salary, Date workDate, String level, String workTime) {
        super(name, tel, add, emailAdd, office, salary, workDate);
        Level = level;
        this.workTime = workTime;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getLevel(){

        return Level;

        }

    public String toString() {

            return super.toString()+",教员级别："+Level+"工作时间"+workTime+",class:Faculty";

            }

}
class Staff extends Employee{

private String Post;

    public Staff(String name, String tel, String add, String emailAdd, String office, double salary, Date workDate, String post) {
        super(name, tel, add, emailAdd, office, salary, workDate);
        Post = post;
    }

    public String getPost(){

        return Post;

        }

    public String toString() {

            return super.toString()+",职务称号："+Post+",class:Staff";

            }

}

//        测试类





public class PersonTest {
    public static void main(String[] args) {

        Person zhangsan=new Person("张三","110","公安局","张三@qq.com");

        Person lisi=new Student("李四","11111111","城建","李四@qq.com",1);

        Person wangwu =new Employee("王五","1689756666","城建","王五@qq.com","计算机系 302",2500.00,new Date());

        Employee zhaoliu=new Faculty("赵六","10086","城建","赵六@qq.com","计算机系203",2700.00,new Date(),"副教授","8年工作经验");

        Employee liuqi=new Staff("刘七","10010","城建","刘七@qq.com","计算机系505",4500.00,new Date(),"副书记");
        System.out.println(zhangsan.toString());

        System.out.println(lisi.toString());

        System.out.println(wangwu.toString());

        System.out.println(zhaoliu.toString());

        System.out.println(liuqi.toString());

        }

}
