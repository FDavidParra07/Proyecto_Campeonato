package com.proyecto.torneo.controladores;

import com.proyecto.torneo.servicios.EstadioService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(EstadioController.class)
public class EstadioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstadioService estadioService;

    @Test
    public void testCrearEstadioForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/estadios/create"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("crear_estadio"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("estadio"));
    }

    @Test
    public void testEliminarEstadio() throws Exception {
        Long estadioId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/estadios/delete/{id}", estadioId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Estadio eliminado correctamente"));
        Mockito.verify(estadioService, Mockito.times(1)).deleteById(estadioId);
    }
}
