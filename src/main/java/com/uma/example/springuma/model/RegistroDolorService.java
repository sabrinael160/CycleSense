package com.uma.example.springuma.model;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroDolorService {

    private final RegistroDolorRepository repository;

    public RegistroDolorService(RegistroDolorRepository repository) {
        this.repository = repository;
    }

    public List<RegistroDolor> findAll() {
        return repository.findAll();
    }

    public RegistroDolor findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(RegistroDolor registro) {
        repository.save(registro);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
