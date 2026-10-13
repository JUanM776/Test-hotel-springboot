package com.hotel.Hotel.domain;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ReservaCancelarTest {

    @Test
    void cancelarReservaPendienteLiberaHabitacion() {
        Cliente cliente = new Cliente("Diego Ruiz", "diego@correo.com");
        Habitacion habitacion = new HabitacionEstandar("501", 2, 180.0, 1);

        LocalDateTime entrada = LocalDateTime.now().plusDays(2);
        RangoFechas fechas = new RangoFechas(entrada, entrada.plusDays(1));

        Reserva reserva = new Reserva(cliente, habitacion, fechas);
        reserva.confirmar();

        reserva.cancelar();

        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
        assertEquals(EstadoHabitacion.DISPONIBLE, habitacion.getEstado());
        reserva.cancelar();
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
        assertEquals(EstadoHabitacion.DISPONIBLE, habitacion.getEstado());
    }
}