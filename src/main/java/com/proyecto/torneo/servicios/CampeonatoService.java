package com.proyecto.torneo.servicios;

import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.repositorios.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public List<Campeonato> findAll() {
        return campeonatoRepository.findAll();
    }

    public Optional<Campeonato> findById(Long id) {
        return campeonatoRepository.findById(id);
    }

    public Campeonato save(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public void deleteById(Long id) {
        campeonatoRepository.deleteById(id);
    }
}
