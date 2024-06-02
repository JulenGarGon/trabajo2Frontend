package es.upsa.dasi.www.application;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface DeleteVideojuegoByIdUseCase {
    public void execute(int idVideojuego) throws AppException;
}
