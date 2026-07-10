package in.strike.controller;

import in.strike.entity.Student;
import in.strike.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
//    @ResponseBody
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResp = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping("/{id}")
//    @ResponseBody
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        Student studentResp = studentService.getStudent(id);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping
//    @ResponseBody
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = studentService.getAll();

        return  ResponseEntity.ok(students);
    }
}
