package es.upsa.dasi.www.infraestructure.ws;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.domain.exceptions.EntityNotFoundException;
import es.upsa.dasi.www.adapters.output.daos.Dao;
import es.upsa.dasi.www.infraestructure.ws.dtos.ErrorDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@ApplicationScoped
public class GatewayDao implements Dao {

    private static final String GATEWAY_URI = "http://localhost:8083";
    @Override
    public List<Videojuego> findVideojuegos() throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                                        .path("/videojuego")
                                        .request(MediaType.APPLICATION_JSON)
                                        .get();

            switch (response.getStatusInfo().toEnum()){
                case OK:
                    List<Videojuego> data = response.readEntity(new GenericType<List<Videojuego>>() {});
                    return data;
                default:
                    ErrorDto errorDto = response.readEntity(ErrorDto.class);
                    throw new AppException(errorDto.getMessage());
            }
        }
    }

    @Override
    public Videojuego findVideojuegoById(int idVideojuego) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/videojuego/{idVideojuego}")
                    .resolveTemplate("idVideojuego", idVideojuego)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            switch (response.getStatusInfo().toEnum()){
                case OK:
                    Videojuego data = response.readEntity(Videojuego.class);
                    return data;
                case NOT_FOUND:
                    ErrorDto errorNotFound = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException(errorNotFound.getMessage());
                default:
                    ErrorDto errorDto = response.readEntity(ErrorDto.class);
                    throw new AppException(errorDto.getMessage());
            }
        }
    }
}
