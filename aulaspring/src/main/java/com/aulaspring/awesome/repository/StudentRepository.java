package com.aulaspring.awesome.repository;

import com.aulaspring.awesome.model.Student;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Joseph
 * @Email jsantos.te@gmail.com
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{
    
    List<Student> findByNameIgnoreCaseContaining(String name);
    
}
