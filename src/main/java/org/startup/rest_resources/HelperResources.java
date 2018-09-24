package org.startup.rest_resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.startup.services.HelperService;

import java.util.List;

/**
 * Created by Abdullah Al Amin on 9/16/2018.
 */
@RestController
@RequestMapping("/helpers")
public class HelperResources {


    @Autowired
    HelperService service;

    @GetMapping("/unilist")
    public List<String> getUniList(){
        return service.getUniversityList();
    }
}
