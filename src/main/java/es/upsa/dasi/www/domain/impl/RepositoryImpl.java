package es.upsa.dasi.www.domain.impl;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.adapters.output.daos.Dao;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    Dao dao;
    @Override
    public List<Videojuego> findVideojuegos() throws AppException {
        return dao.findVideojuegos();
    }

    @Override
    public Videojuego findVideojuegoById(int idVideojuego) throws AppException {
        return dao.findVideojuegoById(idVideojuego);
    }

    @Override
    public List<Desarrollador> findDesarrolladores() throws AppException {
        return dao.findDesarrolladores();
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int idDesarrollador) throws AppException {
        return dao.findVideojuegosByIdDesarrolladores(idDesarrollador);
    }

    @Override
    public Desarrollador findDesarrolladorById(int idDesarrollador) throws AppException {
        return dao.findDesarrolladorById(idDesarrollador);
    }

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {
        return Objects.isNull(videojuego.id())? dao.insertVideojuego(videojuego) : dao.updateVideojuego(videojuego);
    }

    @Override
    public Desarrollador save(Desarrollador desarrollador) throws AppException {
        return Objects.isNull(desarrollador.id())? dao.insertDesarrollador(desarrollador) : dao.updateDesarrollador(desarrollador);
    }

    @Override
    public void deleteVideojuegoById(int idVideojuego) throws AppException {
        dao.deleteVideojuegoById(idVideojuego);
    }

    @Override
    public void deleteDesarrolladorById(int idDesarrollador) throws AppException {
        dao.deleteDesarrolladorById(idDesarrollador);
    }
}
