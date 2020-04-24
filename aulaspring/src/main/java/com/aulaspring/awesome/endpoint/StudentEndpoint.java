package com.aulaspring.awesome.endpoint;

import com.aulaspring.awesome.error.ResourceNotFoundException;
import com.aulaspring.awesome.model.Student;
import com.aulaspring.awesome.repository.StudentRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joseph
 * @Email jsantos.te@gmail.com
 */
@RestController
@RequestMapping("students")
public class StudentEndpoint {
    
    private final StudentRepository studentDao;

    @Autowired
    public StudentEndpoint(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }
    
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(studentDao.findAll(),HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        verifyStudentExists(id);
        Optional<Student> student=studentDao.findById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable("name") String name){
        return new ResponseEntity<>(studentDao.findByNameIgnoreCaseContaining(name),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Student student){
        return new ResponseEntity<>(studentDao.save(student),HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        verifyStudentExists(id);
        studentDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student){
        verifyStudentExists(student.getId());
        studentDao.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    private void verifyStudentExists(Long id){
        if(studentDao.existsById(id)==false)
            throw new ResourceNotFoundException("Estudante com o id: "+id+" não encontrado");
    }
}
