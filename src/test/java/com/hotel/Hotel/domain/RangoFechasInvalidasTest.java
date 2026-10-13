package com.hotel.Hotel.domain;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class RangoFechasInvalidasTest {

    @Test
    void rechazaFechaDeSalidaAnteriorALaEntrada() {
        // Aquí prepararemos las fechas y comprobaremos la excepción.
        LocalDateTime entrada = LocalDateTime.now().plusDays(3);
        LocalDateTime salida = LocalDateTime.now().plusDays(2);

        assertThrows(
                IllegalArgumentException.class,
                () -> new RangoFechas(entrada, salida)
        );
    }
}