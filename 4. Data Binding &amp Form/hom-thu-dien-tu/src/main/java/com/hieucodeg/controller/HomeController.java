package com.hieucodeg.controller;


import com.hieucodeg.dao.ConfigurationDao;
import com.hieucodeg.model.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping( method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        Configuration configuration = ConfigurationDao.getConfiguration();
        model.addAttribute("configuration",configuration);
        return "info";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String loadEdit(ModelMap model) {
        Configuration configuration = ConfigurationDao.getConfiguration();
        model.addAttribute("listLanguages",ConfigurationDao.getListLanguages());
        model.addAttribute("listPageSize",ConfigurationDao.getListPageSize());
        model.addAttribute("configuration",configuration);
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submit(@ModelAttribute("configuration") Configuration configuration,ModelMap model) {
        ConfigurationDao.updateConfi(configuration);
        model.addAttribute("configuration",ConfigurationDao.getConfiguration());
        return "info";
    }
}
