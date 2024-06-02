package es.upsa.dasi.www.application;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface UpdateVideojuegoUseCase {
    Videojuego execute(Videojuego videojuego) throws AppException;
}
