package org.startup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.startup.repositories.TeacherRepository;

import java.util.List;

/**
 * Created by Abdullah Al Amin on 9/16/2018.
 */
@Service
public class HelperService {
    @Autowired
    TeacherRepository repository;


    public List<String> getUniversityList(){
        return repository.findDeptList();
    }
}
