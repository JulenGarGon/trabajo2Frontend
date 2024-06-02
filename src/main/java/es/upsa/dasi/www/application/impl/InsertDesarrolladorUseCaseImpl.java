package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.InsertDesarrolladorUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InsertDesarrolladorUseCaseImpl implements InsertDesarrolladorUseCase {

    @Inject
    Repository repository;

    @Override
    public Desarrollador execute(Desarrollador desarrollador) throws AppException {
        return repository.save(desarrollador);
    }
}
