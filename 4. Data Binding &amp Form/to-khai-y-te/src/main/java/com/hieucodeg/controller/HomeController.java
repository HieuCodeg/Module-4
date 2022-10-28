package com.hieucodeg.controller;



import com.hieucodeg.dao.MedicalDao;
import com.hieucodeg.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class HomeController {



    @RequestMapping( method = RequestMethod.GET)
    public String loadEdit(ModelMap model) {

        model.addAttribute("medical",MedicalDao.getMedical());
        model.addAttribute("listGender",MedicalDao.getListGender());
        model.addAttribute("listCountry",MedicalDao.getListCountry());
        model.addAttribute("listTranfer",MedicalDao.getListTranfer());
        model.addAttribute("listProvince",MedicalDao.getListProvince());
        model.addAttribute("listDistrict",MedicalDao.getListDistrict());
        model.addAttribute("listTown",MedicalDao.getListTown());
        return "edit";
    }

    @RequestMapping( value = "/update",method = RequestMethod.POST)
    public String showForm(@ModelAttribute("medical") Medical medical, ModelMap modelMap) {
        MedicalDao.updateMedical(medical);
        modelMap.addAttribute("medical", MedicalDao.getMedical());
        return "info";
    }

}
