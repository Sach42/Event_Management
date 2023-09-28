package com.sachin.Event.Management.Repository;

import com.sachin.Event.Management.Model.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface IEventRepo extends CrudRepository<Event,Long> {
    List<Event> findAllByDate(LocalDate date);
}
