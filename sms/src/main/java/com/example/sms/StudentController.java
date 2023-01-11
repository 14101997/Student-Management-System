package com.example.sms;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController //telling the java application-->this class will contain API endpoints
public class StudentController {
    //database
    HashMap<Integer,Student> studentDb=new HashMap<>();
    //add a student
    @PostMapping("/add_student")
    public String addStudent(@RequestBody() Student student)
    {
        //add it to our db
        int key=student.id;
        //add it to the studentdb
        studentDb.put(key,student);
        return "Student added successfully";
    }
    //get a student
    @GetMapping("/get_student_by_id")
    public Student getStudentById(@RequestParam("id")Integer id)
    {
        return studentDb.get(id);
    }
    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name")String searchName)
    {
        for(Student s:studentDb.values())
        {
            if(s.name.equals(searchName))return s;
        }
        return null;
    }
    //update a student
    @PutMapping("/update_student")
    public Student updateStudent(@RequestBody()Student student)
    {
        int key=student.id;
        studentDb.put(key,student);
        return student;
    }
    //delete a student
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id")Integer id)
    {
        studentDb.remove(id);
        return "the student has been successfully removed";
    }
}
