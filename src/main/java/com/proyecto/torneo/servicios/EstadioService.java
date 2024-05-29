package com.proyecto.torneo.servicios;

import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.repositorios.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository estadioRepository;

    public List<Estadio> findAll() {
        return estadioRepository.findAll();
    }

    public Optional<Estadio> findById(Long id) {
        return estadioRepository.findById(id);
    }

    public Estadio save(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public void deleteById(Long id) {
        estadioRepository.deleteById(id);
    }
}
