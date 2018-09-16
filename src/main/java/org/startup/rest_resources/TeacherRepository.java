package org.startup.rest_resources;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.startup.model.Teacher;

import java.util.List;

/**
 * Created by Abdullah Al Amin on 9/15/2018.
 */

@RepositoryRestResource(collectionResourceRel = "teacher", path = "teacher")
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {

    @RestResource(path = "maxsalarybewteen")
    public List<Teacher> getAllByExpectedSalaryMaxBetween(@Param("start") short start,@Param("end") short end);

    @RestResource(path = "minsalarybewteen")
    public List<Teacher> getAllByExpectedSalaryMinBetween(@Param("start") short start, @Param("end")short end);

    @RestResource(path = "gender")
    public List<Teacher> getAllByGender(@Param("gender")String gender);

    @RestResource(path = "deptandgender")
    public List<Teacher> getAllByGenderAndDepartment(@Param("gender")String  gender, @Param("dept") String dept);

    @RestResource(path = "all")
    @Query("select t from Teacher t")
    public List<Teacher> findAll();

    @RestResource(path = "dept")
    public List<Teacher>findAllByDepartment(@Param("dept")String dept);

    @RestResource(path = "deptanduni")
    public List<Teacher>findAllByDepartmentAndUniversity(@Param("dept") String dept, @Param("uni") String uni);

    @RestResource(path = "uni")
    public List<Teacher>findAllByUniversity(@Param("uni")String uni);
}
