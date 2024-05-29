package com.proyecto.torneo.servicios;

import com.proyecto.torneo.entidades.Gol;
import com.proyecto.torneo.repositorios.GolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GolService {

    @Autowired
    private GolRepository golRepository;

    public List<Gol> findAll() {
        return golRepository.findAll();
    }

    public Optional<Gol> findById(Long id) {
        return golRepository.findById(id);
    }

    public Gol save(Gol gol) {
        return golRepository.save(gol);
    }

    public void deleteById(Long id) {
        golRepository.deleteById(id);
    }
}
