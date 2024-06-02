package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.FindVideojuegosByDesarrolladoresUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FindVideojuegosByDesarrolladoresUseCaseImpl implements FindVideojuegosByDesarrolladoresUseCase {
    @Inject
    Repository repository;


    @Override
    public List<Videojuego> execute(int idDesarrollador) throws AppException {
        return repository.findVideojuegosByIdDesarrollador(idDesarrollador);
    }
}
