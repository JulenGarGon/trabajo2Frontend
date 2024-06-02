package es.upsa.dasi.www.application;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface DeleteDesarrolladorByIdUseCase {
    public void execute(int idDesarrollador) throws AppException;
}
