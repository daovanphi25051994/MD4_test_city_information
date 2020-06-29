package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.city.ICityService;
import com.example.demo.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryService.getAll();
    }

    @GetMapping("/list")
    public ModelAndView listCity(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("cities", cityService.getAll());
        return modelAndView;
    }

    @GetMapping("/city-create")
    public ModelAndView moveToForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("countries",  countries());
        return modelAndView;
    }

    @PostMapping("/city-create")
    public ModelAndView createCity(@ModelAttribute("city") City city){
        ModelAndView modelAndView = new ModelAndView("list");
        cityService.save(city);
        modelAndView.addObject("cities", cityService.getAll());
        modelAndView.addObject("message", "them thanh cong");
        return modelAndView;
    }

    @GetMapping("/city-info/{id}")
    public ModelAndView cityInfo(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("city-info");
        modelAndView.addObject("city", cityService.getOne(id));
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView moveToEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", cityService.getOne(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCity(@ModelAttribute("city") City city){
        ModelAndView modelAndView = new ModelAndView("list");
        cityService.save(city);
        modelAndView.addObject("message", "edit thanh cong");
        modelAndView.addObject("cities", cityService.getAll());
        return modelAndView;
    }

}