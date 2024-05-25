package com.proyecto.torneo.servicios;

import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.repositorios.ClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionService {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    public List<Clasificacion> findAll() {
        return clasificacionRepository.findAll();
    }

    public Optional<Clasificacion> findById(Long id) {
        return clasificacionRepository.findById(id);
    }

    public Clasificacion save(Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    public void deleteById(Long id) {
        clasificacionRepository.deleteById(id);
    }

    public List<Clasificacion> findByCampeonatoId(Long campeonatoId) {
        return clasificacionRepository.findByCampeonatoId(campeonatoId);
    }

    public Clasificacion findByEquipoIdAndCampeonatoId(Long equipoId, Long campeonatoId) {
        return clasificacionRepository.findByEquipoIdAndCampeonatoId(equipoId, campeonatoId);
    }
}
