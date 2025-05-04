package lab.student.entity;

import lab.student.exception.OutOfGradeException;

public class Student {
    private String studentId;
    private String name;
    private String major;
    private int grade;

    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        try{
            this.setGrade(grade);
        }catch(OutOfGradeException e){
            e.printStackTrace();
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }


    public String getMajor() {
        return major;
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws OutOfGradeException {
        if(grade<1 || grade>4){
            String errMsg=String.format("학년은 1~4학년까지만 존재합니다.");
            throw new OutOfGradeException(errMsg);
        }else{
            this.grade=grade;
        }
    }
}
