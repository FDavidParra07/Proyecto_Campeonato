package com.proyecto.torneo.servicios;

import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.repositorios.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> findById(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteById(Long id) {
        equipoRepository.deleteById(id);
    }
}
