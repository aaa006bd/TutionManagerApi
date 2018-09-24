package org.startup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.startup.model.FileData;
import org.startup.model.Teacher;

/**
 * Created by Abdullah Al Amin on 9/17/2018.
 */
public interface FileDataRepository extends JpaRepository<FileData, Long> {

    // TODO: 9/20/2018 insert various fetch based on owner for further manupilation

    @RestResource(path="filesbyemail")
    public FileData findByOwnerEmail(@Param("email") String email);
}
