package com.tcs.country.controller;
import com.tcs.country.model.Country;
import com.tcs.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryServices;
    @GetMapping("/get")
    public ResponseEntity<List<Country>> findAllCountryDetails(){

        List<Country>list= this.countryServices.getAllCountries();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/get/{code}")
    public ResponseEntity<Country> findCountryByCode(@PathVariable("code") int code){
        Country country=countryServices.getCountryByCode(code);
        if(country==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(country));

    }
    @PostMapping("/post")
    public ResponseEntity<Country> createCountryDetails(@RequestBody Country country){
        Country st=null;
        try {
            st=this.countryServices.addNewCountry(country);
            return ResponseEntity.of(Optional.of(st));
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteCountryDetails(@PathVariable("code") int code){
        try {
            this.countryServices.deleteCountryById(code);
            return ResponseEntity.status(HttpStatus.OK).body("Data Deleted........");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/put/{name}")
    public ResponseEntity<Country> updateCountryDetails(@RequestBody Country country,@PathVariable("name") String name){
        try {
            this.countryServices.updateCountry(country, name);
            return ResponseEntity.ok().body(country);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
