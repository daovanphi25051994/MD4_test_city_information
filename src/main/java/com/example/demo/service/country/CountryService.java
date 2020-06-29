package com.example.demo.service.country;

import com.example.demo.model.Country;
import com.example.demo.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Country save(Country model) {
        return countryRepository.save(model);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getOne(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}