package es.upsa.dasi.www.adapters.output.daos;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface Dao {
    List<Videojuego> findVideojuegos() throws AppException;

    Videojuego findVideojuegoById(int idVideojuego) throws AppException;

    List<Desarrollador> findDesarrolladores() throws AppException;

    List<Videojuego> findVideojuegosByIdDesarrolladores(int idDesarrollador) throws AppException;

    Desarrollador findDesarrolladorById(int idDesarrollador) throws AppException;

    Videojuego updateVideojuego(Videojuego videojuego) throws AppException;

    Desarrollador updateDesarrollador(Desarrollador desarrollador) throws AppException;

    void deleteVideojuegoById(int idVideojuego) throws AppException;

    void deleteDesarrolladorById(int idDesarrollador) throws AppException;

    Videojuego insertVideojuego(Videojuego videojuego) throws AppException;

    Desarrollador insertDesarrollador(Desarrollador desarrollador) throws AppException;
}
