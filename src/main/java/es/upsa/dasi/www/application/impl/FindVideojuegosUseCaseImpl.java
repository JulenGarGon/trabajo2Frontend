package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.FindVideojuegosUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
@ApplicationScoped
public class FindVideojuegosUseCaseImpl implements FindVideojuegosUseCase {

    @Inject
    Repository repository;

    @Override
    public List<Videojuego> execute() throws AppException {
        return repository.findVideojuegos();
    }
}
