package com.hotel.Hotel.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hotel.Hotel.domain.Cliente;
import com.hotel.Hotel.domain.HabitacionEstandar;
import com.hotel.Hotel.dto.request.CrearReservaRequest;
import com.hotel.Hotel.exception.ReglaNegocioException;
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

        HabitacionEstandar habitacion =
        new HabitacionEstandar("205", 2, 120.0, 1);

    when(clienteRepository.findById(clienteId))
            .thenReturn(Optional.of(cliente));
    when(habitacionRepository.findById(habitacionId))
            .thenReturn(Optional.of(habitacion));

        assertThrows(
        ReglaNegocioException.class,
        () -> reservaService.crear(solicitud));

        verifyNoInteractions(reservaRepository, reservaMapper);   
    }
}