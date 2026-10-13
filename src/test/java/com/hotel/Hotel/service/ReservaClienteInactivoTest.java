package com.hotel.Hotel.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hotel.Hotel.domain.Cliente;
import com.hotel.Hotel.dto.request.CrearReservaRequest;
import com.hotel.Hotel.mapper.ReservaMapper;
import com.hotel.Hotel.repository.ClienteRepository;
import com.hotel.Hotel.repository.HabitacionRepository;
import com.hotel.Hotel.repository.ReservaRepository;

@ExtendWith(MockitoExtension.class)
class ReservaClienteInactivoTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private HabitacionRepository habitacionRepository;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private ReservaMapper reservaMapper;

    @InjectMocks
    private ReservaService reservaService;

    @Test
    void reservaClienteInactivoLanzaExcepcion() {
        UUID clienteId = UUID.randomUUID();
        UUID habitacionId = UUID.randomUUID();

        LocalDateTime entrada = LocalDateTime.now().plusDays(1);
        CrearReservaRequest solicitud = new CrearReservaRequest(
            clienteId,
            habitacionId,
            entrada,
            entrada.plusDays(2));

        Cliente cliente = new Cliente("Mateo Hernandez", "mateo@correo.com");
        cliente.registrarPenalizacion();
        cliente.registrarPenalizacion();
        cliente.registrarPenalizacion();
    }
}