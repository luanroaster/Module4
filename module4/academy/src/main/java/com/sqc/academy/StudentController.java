package com.sqc.academy;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(

            Arrays.asList(
                    new Student(1, "Lương", 2.0),
                    new Student(2, "Luân", 2.0),
                    new Student(3, "Thiên", 2.0)

            )
    );
    //Get list(search)
//    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping
    public  List<Student> getStudents(){
        return students;
    }
// Get by id
//    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id){
    for (Student student : students){
        if (student.getId() == id){
            return student;
        }
    }
    return null;
    }
    @PostMapping
    public  Student save (@RequestBody Student student){
        student.setId((int) (Math.random()*100000000));
        students.add(student);
        return student;
    }
}
