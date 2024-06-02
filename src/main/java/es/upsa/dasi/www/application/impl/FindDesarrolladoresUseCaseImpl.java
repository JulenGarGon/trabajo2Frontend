package es.upsa.dasi.www.application.impl;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.FindDesarrolladoresUseCase;
import es.upsa.dasi.www.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FindDesarrolladoresUseCaseImpl implements FindDesarrolladoresUseCase {

    @Inject
    Repository repository;
    @Override
    public List<Desarrollador> execute() throws AppException {
        return repository.findDesarrolladores();
    }
}
