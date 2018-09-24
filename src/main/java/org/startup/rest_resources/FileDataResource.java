package org.startup.rest_resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.startup.model.FileData;
import org.startup.model.Teacher;
import org.startup.repositories.FileDataRepository;
import org.startup.repositories.TeacherRepository;

/**
 * Created by Abdullah Al Amin on 9/17/2018.
 */
@RestController
@RequestMapping("/file")
public class FileDataResource {

    // TODO: add insert update and delete methods based on owner(Teacher) 9/20/2018
    @Autowired
    private FileDataRepository fileRepository;

    private TeacherRepository teacherRepository;

    @PostMapping("/insert/{mail}")
    public void save(@PathVariable("mail") String teacherMail, @RequestBody FileData data){
       FileData dataSaved = fileRepository.save(data);
       Teacher teacher = teacherRepository.findByEmail(teacherMail);
       teacher.setFileData(dataSaved);
       teacherRepository.save(teacher);
    }

    @GetMapping("/fetch/{mail}")
    public FileData getByTeacherMail(String mail){
        return fileRepository.findByOwnerEmail(mail);
    }



}
