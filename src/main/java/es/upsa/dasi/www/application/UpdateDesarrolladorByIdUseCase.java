package es.upsa.dasi.www.application;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface UpdateDesarrolladorByIdUseCase {

    Desarrollador execute(Desarrollador desarrollador) throws AppException;
}
