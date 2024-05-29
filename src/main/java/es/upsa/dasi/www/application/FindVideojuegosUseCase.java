package es.upsa.dasi.www.application;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface FindVideojuegosUseCase {

    List<Videojuego> execute() throws AppException;
}
