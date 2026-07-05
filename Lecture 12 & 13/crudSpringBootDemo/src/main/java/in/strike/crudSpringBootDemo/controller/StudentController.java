package in.strike.crudSpringBootDemo.controller;

import in.strike.crudSpringBootDemo.entity.Student;
import in.strike.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){

        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentResp);

//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(studentResp);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,
                                                 @RequestBody Student student){
        Student studentRes = studentService.updateStudent(id,student);

        if(studentRes==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String>  deleteStudent(@RequestParam Long id){
        Boolean isDeleted  = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        Boolean isDeleted  = studentService.deleteStudentSoftly(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }


}
