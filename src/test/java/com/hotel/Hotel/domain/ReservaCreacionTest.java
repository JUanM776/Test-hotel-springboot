package com.hotel.Hotel.domain;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ReservaCreacionTest {

    @Test
    void reservaNuevaComienzaPendiente(){
        Cliente cliente = new Cliente("Mateo Hernandez", "mateo@correo.com");
        Habitacion habitacion = new HabitacionEstandar("101", 2, 100.0, 1);

        RangoFechas fechas = new RangoFechas(
            LocalDateTime.now().plusDays(1),
            LocalDateTime.now().plusDays(3));

        Reserva reserva = new Reserva(cliente, habitacion, fechas);
    }

}
