package lab.student.control;

import lab.student.entity.Student;
import lab.student.exception.OutOfGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try{
            Student std=new Student("20231122","김민수","컴퓨터공학",3);
            std.setGrade(5);
        }catch(OutOfGradeException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
