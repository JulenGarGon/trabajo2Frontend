package es.upsa.dasi.www.domain.impl;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.adapters.output.daos.Dao;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

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
}
