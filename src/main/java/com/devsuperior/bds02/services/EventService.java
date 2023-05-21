package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.exceptions.IsNotFoundException;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private CityRepository cityRepository;

    public EventDTO updateEvent(EventDTO eventDTO, Long id) {
        return new EventDTO(repository.save(buildEvent(eventDTO, id)));
    }

    private Event buildEvent(EventDTO eventDTO, Long id) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new IsNotFoundException("ID not found"));

        City city = cityRepository.findById(eventDTO.getCityId())
                .orElseThrow(() -> new IsNotFoundException("ID not found"));

        event.setName(eventDTO.getName());
        event.setDate(eventDTO.getDate());
        event.setUrl(eventDTO.getUrl());
        event.setCity(city);

        return event;
    }

}
