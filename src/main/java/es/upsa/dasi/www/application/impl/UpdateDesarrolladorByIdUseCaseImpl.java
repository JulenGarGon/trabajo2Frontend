package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.UpdateDesarrolladorByIdUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateDesarrolladorByIdUseCaseImpl implements UpdateDesarrolladorByIdUseCase {

    @Inject
    Repository repository;

    @Override
    public Desarrollador execute(Desarrollador desarrollador) throws AppException {
        return repository.save(desarrollador);
    }
}
