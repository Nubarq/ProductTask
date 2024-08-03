package com.alas.task1.controller;

import com.alas.task1.dto.country.request.CountryCreateRequestDTO;
import com.alas.task1.dto.country.request.CountryDeleteRequestDTO;
import com.alas.task1.dto.country.request.CountryReadRequestDTO;
import com.alas.task1.dto.country.request.CountryUpdateRequestDTO;
import com.alas.task1.model.Country;
import com.alas.task1.service.CountryService;
import com.alas.task1.service.Impl.CountryServiceImplWithCahceAnnotations;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CountryController {

    CountryService countryService;
    public CountryController(@Qualifier("countryServiceImplWithTemplate") CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Page<Country> getAllCountries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return countryService.readAllCountries(page, size);
    }

    @GetMapping("/by-id")
    public Country getCountryById(@RequestBody CountryReadRequestDTO dto) {
        return countryService.readCountryById(dto);
    }

    @PutMapping("/update")
    public Country updateCountryById(@RequestBody CountryUpdateRequestDTO dto) {
        return countryService.updateCountry(dto);
    }

    @DeleteMapping("/delete")
    public void deleteCountryById(@RequestBody CountryDeleteRequestDTO dto) {
        countryService.deleteCountry(dto);
    }

    @PostMapping("/create")
    public Country createCountry(@RequestBody CountryCreateRequestDTO dto) {
        return countryService.createCountry(dto);
    }

}
