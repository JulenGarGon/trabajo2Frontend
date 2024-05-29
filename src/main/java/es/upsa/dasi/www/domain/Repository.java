package es.upsa.dasi.www.domain;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface Repository {

    List<Videojuego> findVideojuegos() throws AppException;

    Videojuego findVideojuegoById(int idVideojuego) throws AppException;
}
