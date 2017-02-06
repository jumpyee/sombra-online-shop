package com.sombra.stoliar.controller;


import com.sombra.stoliar.entity.CategoryPool;
import com.sombra.stoliar.service.CategoryPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    CategoryPoolService categoryPoolService;

    @ModelAttribute("allCategoryPools")
    public List<CategoryPool> getAllCategoryPools() {
        return categoryPoolService.findAllCategoryPools();
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home/home";
    }


}
