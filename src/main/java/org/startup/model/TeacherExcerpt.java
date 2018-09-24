package org.startup.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by Abdullah Al Amin on 9/20/2018.
 */
@Projection(name = "excerpt", types = Teacher.class)
public interface TeacherExcerpt {
    //// TODO: add simplified projections for teacher presentation with dept and uni 9/20/2018
}
