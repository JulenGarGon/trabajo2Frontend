package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.FindDesarrolladorByIdUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindDesarrolladorByIdUseCaseImpl implements FindDesarrolladorByIdUseCase {

    @Inject
    Repository repository;

    @Override
    public Desarrollador execute(int idDesarrollador) throws AppException {
        return repository.findDesarrolladorById(idDesarrollador);
    }
}
