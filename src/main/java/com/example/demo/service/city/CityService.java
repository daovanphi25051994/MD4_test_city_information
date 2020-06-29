package com.example.demo.service.city;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City model) {
        return cityRepository.save(model);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getOne(Long id) {
        return cityRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}