package com.example.scaffold.repository.testDB;

import com.example.scaffold.model.jpa.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jinglun on 2020-06-01
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.age = ?1")
    List<Student> findStuByAge(Integer age);
}
