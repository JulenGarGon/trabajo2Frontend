package es.upsa.dasi.www.adapters.output.daos;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface Dao {
    List<Videojuego> findVideojuegos() throws AppException;

    Videojuego findVideojuegoById(int idVideojuego) throws AppException;
}
