package com.tcs.country.repository;
import com.tcs.country.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CountryRepository extends CrudRepository<Country,Integer> {
    public Country findById(int code);
}