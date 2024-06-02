package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.DeleteDesarrolladorByIdUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteDesarrolladorByIdUseCaseImpl implements DeleteDesarrolladorByIdUseCase {

    @Inject
    Repository repository;
    @Override
    public void execute(int idDesarrollador) throws AppException {
        repository.deleteDesarrolladorById(idDesarrollador);
    }
}
