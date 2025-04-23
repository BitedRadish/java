package lab.student.exception;

public class OutOfGradeException extends Exception{
    public OutOfGradeException(String message) {
//        부모 클래스 (Exception)의 생성자를 호출해서 field 변수에 에러 메시지 저장
//        getter로 저장된 에러 메시지를 받아올 수 있음.
        super(message);
    }
}
