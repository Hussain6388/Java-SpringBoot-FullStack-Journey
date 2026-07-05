package in.strike.crudSpringBootDemo.service;

import in.strike.crudSpringBootDemo.entity.Student;
import in.strike.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);

        return studentResp;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentsList = studentRepository.findByDeletedIsFalse();
        return studentsList;
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave  = existingStudent.get();

        studentToSave.setName(student.getName());
        studentToSave.setAge(student.getAge());
        studentToSave.setEmail(student.getEmail());
        studentToSave.setSubject(student.getSubject());
        studentToSave.setRollNo(student.getRollNo());
        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);


    }

    public Boolean deleteStudent(Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isEmpty()) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) {
            return false;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }
}
