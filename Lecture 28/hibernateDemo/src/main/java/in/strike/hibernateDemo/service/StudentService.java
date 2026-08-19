package in.strike.hibernateDemo.service;

import in.strike.hibernateDemo.model.Student;
import in.strike.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student studentReq, Long id) {
        Student student = studentRepository.findById(id);

        if(student==null){
            throw new RuntimeException("Student Not Found");
        }

        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());


    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);
        if(student==null){
            throw new RuntimeException("Student Not Found");
        }

        studentRepository.remove(student);
    }
}
