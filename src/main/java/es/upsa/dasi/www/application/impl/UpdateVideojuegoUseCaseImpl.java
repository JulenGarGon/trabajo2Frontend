package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.UpdateVideojuegoUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateVideojuegoUseCaseImpl implements UpdateVideojuegoUseCase {
    @Inject
    Repository repository;


    @Override
    public Videojuego execute(Videojuego videojuego) throws AppException {
        return repository.save(videojuego);
    }
}
