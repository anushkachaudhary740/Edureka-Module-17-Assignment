package com.tcs.country.service;

import com.tcs.country.model.Country;
import com.tcs.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryService{
    @Autowired
    private CountryRepository countryRepository;
    public List<Country> getAllCountries(){
        List<Country> list1=null;
        try {

            list1 = (List<Country>) this.countryRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list1;
    }
    public Country getCountryByCode(int code) {
        Country country = null;
        try {
            country = this.countryRepository.findById(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return country;

    }
    public Country addNewCountry(Country country){
        try {
            this.countryRepository.save(country);
        }catch (Exception e){
            e.printStackTrace();
        }
        return country;
    }

    public  void deleteCountryById(int code) {
        this.countryRepository.deleteById(code);

    }

    public void updateCountry(Country country, String name) {
        country.setName(name);
        this.countryRepository.save(country);
    }
}

