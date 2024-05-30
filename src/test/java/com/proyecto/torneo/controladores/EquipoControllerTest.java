package com.proyecto.torneo.controladores;

import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.servicios.CampeonatoService;
import com.proyecto.torneo.servicios.ClasificacionService;
import com.proyecto.torneo.servicios.EquipoService;
import com.proyecto.torneo.servicios.EstadioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(EquipoController.class)
public class EquipoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EquipoService equipoService;

    @MockBean
    private EstadioService estadioService;

    @MockBean
    private CampeonatoService campeonatoService;

    @MockBean
    private ClasificacionService clasificacionService;

    @Test
    public void testCrearEquipoForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/equipos/create"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("crear_equipo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("equipo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("estadios"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("campeonatos"));
    }

    @Test
    public void testDeleteById() throws Exception {
        Long equipoId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/equipos/delete/{id}", equipoId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Equipo eliminado correctamente"));
        Mockito.verify(equipoService, Mockito.times(1)).deleteById(equipoId);
    }

    @Test
    public void testFiltrarEquipos() throws Exception {
        Long campeonatoId = 1L;
        List<Equipo> equiposFiltrados = new ArrayList<>();
        Mockito.when(equipoService.findByCampeonatoId(campeonatoId)).thenReturn(equiposFiltrados);

        mockMvc.perform(MockMvcRequestBuilders.post("/equipos/filtrar")
                        .param("campeonatoId", campeonatoId.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("equipos"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("equipos"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("campeonatos"));
    }
}
