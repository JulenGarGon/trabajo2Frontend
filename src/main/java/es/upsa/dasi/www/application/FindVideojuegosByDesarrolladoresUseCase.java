package es.upsa.dasi.www.application;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface FindVideojuegosByDesarrolladoresUseCase {

    List<Videojuego> execute(int idDesarrollador) throws AppException;
}
