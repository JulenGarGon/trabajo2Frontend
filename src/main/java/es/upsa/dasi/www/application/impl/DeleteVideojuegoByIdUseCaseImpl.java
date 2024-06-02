package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.DeleteVideojuegoByIdUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteVideojuegoByIdUseCaseImpl implements DeleteVideojuegoByIdUseCase {

    @Inject
    Repository repository;
    @Override
    public void execute(int idVideojuego) throws AppException {
        repository.deleteVideojuegoById(idVideojuego);
    }
}
