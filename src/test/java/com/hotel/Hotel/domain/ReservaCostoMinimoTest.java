package com.hotel.Hotel.domain;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ReservaCostoMinimoTest {

    @Test
    void cobraUnaNocheAunqueLasFechasSeanElMismoDia() {
        Cliente cliente = new Cliente("Sofía López", "sofia@correo.com");
        Habitacion habitacion = new HabitacionEstandar("401", 2, 120.0, 1);

        LocalDateTime fecha = LocalDateTime.now().plusDays(5);
        RangoFechas fechas = new RangoFechas(fecha, fecha);

        Reserva reserva = new Reserva(cliente, habitacion, fechas);
        assertEquals(120.0, reserva.getCostoTotal());
    }
}