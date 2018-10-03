package org.startup.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.startup.model.FileData;
import org.startup.model.Teacher;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Abdullah Al Amin on 9/15/2018.
 */

@RepositoryRestResource(collectionResourceRel = "teacher", path = "teacher")
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {

    @RestResource(path = "maxsalarybewteen")
    public List<Teacher> getAllByApprovedByAdminAndExpectedSalaryMaxBetween(@Param("approved")boolean approved,
                                                                            @Param("start") short start,
                                                                            @Param("end") short end,
                                                                            Pageable page);

    @RestResource(path = "minsalarybewteen")
    public List<Teacher> getAllByApprovedByAdminAndExpectedSalaryMinBetween(@Param("approved") boolean approved,
                                                                            @Param("start") short start,
                                                                            @Param("end")short end,
                                                                            @PathParam("page")Pageable page);

    @RestResource(path = "gender")
    public List<Teacher> getAllByGenderAndApprovedByAdmin(@Param("gender")String gender,@Param("approved")boolean approved, Pageable page);

    public Teacher findByEmail(String email);

    @RestResource(path = "deptandgender")
    public List<Teacher> getAllByGenderAndDepartmentAndApprovedByAdmin(@Param("gender")String  gender,
                                                     @Param("dept") String dept,@Param("approved")boolean approved,
                                                     Pageable page);

    @RestResource(path = "all")
    @Query("select t from Teacher t")
    public List<Teacher> findAllTeacher(Pageable page);

    @RestResource(path = "dept")
    public List<Teacher>findAllByDepartmentAndApprovedByAdmin(@Param("dept")String dept,@Param("approved")boolean approved, Pageable page);

    @RestResource(path = "deptanduni")
    public List<Teacher>findAllByDepartmentAndUniversityAndApprovedByAdmin(@Param("dept") String dept,
                                                         @Param("uni") String uni,@Param("approved")boolean approved,
                                                         Pageable page);

    @RestResource(path = "uni")
    public List<Teacher>findAllByUniversityAndApprovedByAdmin(@Param("uni")String uni,@Param("approved")boolean approved, Pageable page);

    @Query("select DISTINCT t.university from Teacher t ")
    public List<String >findUniList();

    @Query("select DISTINCT t.department from Teacher t")
    public List<String >findDeptList();



}
