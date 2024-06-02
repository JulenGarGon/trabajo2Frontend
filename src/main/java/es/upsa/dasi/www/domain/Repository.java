package es.upsa.dasi.www.domain;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface Repository {

    List<Videojuego> findVideojuegos() throws AppException;

    Videojuego findVideojuegoById(int idVideojuego) throws AppException;

    List<Desarrollador> findDesarrolladores() throws AppException;

    List<Videojuego> findVideojuegosByIdDesarrollador(int idDesarrollador) throws AppException;

    Desarrollador findDesarrolladorById(int idDesarrollador) throws AppException;

    Videojuego save(Videojuego videojuego) throws AppException;

    Desarrollador save(Desarrollador desarrollador) throws AppException;

    void deleteVideojuegoById(int idVideojuego) throws AppException;

    void deleteDesarrolladorById(int idDesarrollador) throws AppException;
}
