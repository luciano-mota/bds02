package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.exceptions.IsDataBaseExcetion;
import com.devsuperior.bds02.exceptions.IsNotFoundException;
import com.devsuperior.bds02.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<CityDTO> findAll() {
        List<City> cityList = repository.findAll(Sort.by(Sort.Order.by("name")));

        return cityList.stream()
                .map(CityDTO::new).collect(toList());
    }

    public CityDTO insert(CityDTO dto) {
        City city = new City();
        city.setName(dto.getName());

        city = repository.save(city);
        return new CityDTO(city);
    }

    public void deleteCity(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IsNotFoundException("ID not found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new IsDataBaseExcetion("Integrity violation");
        }
    }
}
