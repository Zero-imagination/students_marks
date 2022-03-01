import dao.*;
import models.Mark;
import models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import services.StudentServiceImpl;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try {

            factory = new Configuration().configure().buildSessionFactory();
            StudentDao studentDao = new StudentDaoImpl(factory);
            MarkDao markDao = new MarkDaoImpl(factory);

            // работает
            //update(studentDao);
            //create(studentDao);
            //delete(studentDao);
            getAllStudents(studentDao);
            //createMark(studentDao, markDao);

            // не работает
            //readMark(markDao);



        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
    private static void readStudent(StudentDao studentDao) {
        final Student result = studentDao.read(1);
        System.out.println("Read: " + result);
    }
    private static void readMark(MarkDao markDao){
        List<Mark> markList =markDao.read(1);
        //final Mark mark = markDao.read(1);
        for (Mark mark : markList)
        {
            System.out.println("Read: " + mark);
        }
        //System.out.println("Read: " + mark);
    }
    private static void create(StudentDao studentDao) {
        Student student = new Student();
        student.setName("Игорь");
        student.setSurname("Рябинин");
        student.setPatronymic("Сергееевич");

        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
            dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setDateStartLearning(dateStart);
        student.setDateEndLearning(dateEnd);
        studentDao.create(student);
        System.out.println("Created: " + studentDao.read(3));
    }
    private static void createMark(StudentDao studentDao, MarkDao markDao){
        Mark mark = new Mark();
        mark.setCurrentMark("3");
        Student student = studentDao.read(2);
        mark.setStudent(student);
        markDao.create(mark);
        System.out.println("Created: " + markDao.read(3));
    }
        private static void delete(StudentDao studentDao) {
        Student student =studentDao.read(3);
        studentDao.delete(3);
        System.out.println("Deleted: " + student);
        }
    private static void getAllStudents(StudentDao studentDao){
        List<Student> studentList = studentDao.listStudent();
        for (Student student: studentList){
            System.out.println(student);
        }
    }

}
