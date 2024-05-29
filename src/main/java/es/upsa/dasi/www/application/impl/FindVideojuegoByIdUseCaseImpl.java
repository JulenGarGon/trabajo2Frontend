package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.FindVideojuegoByIdUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindVideojuegoByIdUseCaseImpl implements FindVideojuegoByIdUseCase {
    @Inject
    Repository repository;

    @Override
    public Videojuego execute(int idVideojuego) throws AppException {
        return repository.findVideojuegoById(idVideojuego);
    }
}
