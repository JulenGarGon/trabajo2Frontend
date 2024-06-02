package es.upsa.dasi.www.infraestructure.ws;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.domain.exceptions.EntityNotFoundException;
import es.upsa.dasi.www.adapters.output.daos.Dao;
import es.upsa.dasi.www.infraestructure.ws.dtos.ErrorDto;
import es.upsa.dasi.www.infraestructure.ws.dtos.VideojuegoDto;
import es.upsa.dasi.www.infraestructure.ws.mappers.Mappers;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@ApplicationScoped
public class GatewayDao implements Dao {

    @Inject
    Mappers mappers;


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

    @Override
    public List<Desarrollador> findDesarrolladores() throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                                        .path("/desarrollador")
                                        .request(MediaType.APPLICATION_JSON)
                                        .get();
            switch (response.getStatusInfo().toEnum()){
                case OK:
                    List<Desarrollador> data = response.readEntity(new GenericType<List<Desarrollador>>(){});
                    return data;
                default:
                    ErrorDto errorDto = response.readEntity(ErrorDto.class);
                    throw new AppException(errorDto.getMessage());
            }
        }
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrolladores(int idDesarrollador) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()) {
            Response response = client.target(GATEWAY_URI)
                    .path("/videojuegos/{idDesarrollador}")
                    .resolveTemplate("idDesarrollador", idDesarrollador)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            switch (response.getStatusInfo().toEnum()){
                case OK:
                    List<Videojuego> data = response.readEntity(new GenericType<List<Videojuego>>(){});
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

    @Override
    public Desarrollador findDesarrolladorById(int idDesarrollador) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/desarrollador/{idDesarrollador}")
                    .resolveTemplate("idDesarrollador", idDesarrollador)
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            switch (response.getStatusInfo().toEnum()){
                case OK:
                    Desarrollador data = response.readEntity(Desarrollador.class);
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

    @Override
    public Videojuego updateVideojuego(Videojuego videojuego) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/videojuego/{idVideojuego}")
                    .resolveTemplate("idVideojuego", videojuego.id())
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.json(mappers.toVideojuegoDto(videojuego)));

            switch (response.getStatusInfo().toEnum()){
                case OK:
                    Videojuego data = response.readEntity(Videojuego.class);
                    return data;
                case NOT_FOUND:
                    ErrorDto notFoundError = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException( notFoundError.getMessage() );
                default:
                    ErrorDto errorDto = response.readEntity(ErrorDto.class);
                    throw new AppException(errorDto.getMessage());
            }
        }
    }

    @Override
    public Desarrollador updateDesarrollador(Desarrollador desarrollador) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/desarrollador/{idDesarrollador}")
                    .resolveTemplate("idDesarrollador", desarrollador.id())
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.json(mappers.toDesarrolladorDto(desarrollador)));

            switch (response.getStatusInfo().toEnum()){
                case OK:
                    Desarrollador data = response.readEntity(Desarrollador.class);
                    return data;
                case NOT_FOUND:
                    ErrorDto notFoundError = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException( notFoundError.getMessage() );
                default:
                    ErrorDto errorDto = response.readEntity(ErrorDto.class);
                    throw new AppException(errorDto.getMessage());
            }
        }
    }

    @Override
    public void deleteVideojuegoById(int idVideojuego) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/videojuego/{idVideojuego}")
                    .resolveTemplate("idVideojuego", idVideojuego)
                    .request(MediaType.APPLICATION_JSON)
                    .delete();

            switch (response.getStatusInfo().toEnum()){
                case NO_CONTENT:
                    return;
                default:
                    ErrorDto errorDto = response.readEntity(ErrorDto.class);
                    throw new AppException(errorDto.getMessage());
            }
        }
    }

    @Override
    public void deleteDesarrolladorById(int idDesarrollador) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/desarrollador/{idDesarrollador}")
                    .resolveTemplate("idDesarrollador", idDesarrollador)
                    .request(MediaType.APPLICATION_JSON)
                    .delete();

            switch (response.getStatusInfo().toEnum()){
                case NO_CONTENT:
                    return;
                default:
                    ErrorDto errorDto = response.readEntity(ErrorDto.class);
                    throw new AppException(errorDto.getMessage());
            }
        }
    }

    @Override
    public Videojuego insertVideojuego(Videojuego videojuego) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/videojuego")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(mappers.toVideojuegoDto(videojuego)));

            switch (response.getStatusInfo().toEnum()){
                case CREATED:
                    Videojuego data = response.readEntity(Videojuego.class);
                    String location = response.getHeaderString(HttpHeaders.LOCATION);
                    return data;
                case NOT_FOUND:
                    ErrorDto notFoundError = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException( notFoundError.getMessage() );

                default:
                    ErrorDto error = response.readEntity( ErrorDto.class );
                    throw new AppException( error.getMessage() );
            }
        }
    }

    @Override
    public Desarrollador insertDesarrollador(Desarrollador desarrollador) throws AppException {
        try (Client client = ClientBuilder.newBuilder().build()){
            Response response = client.target(GATEWAY_URI)
                    .path("/desarrollador")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(mappers.toDesarrolladorDto(desarrollador)));

            switch (response.getStatusInfo().toEnum()){
                case CREATED:
                    Desarrollador data = response.readEntity(Desarrollador.class);
                    String location = response.getHeaderString(HttpHeaders.LOCATION);
                    return data;
                case NOT_FOUND:
                    ErrorDto notFoundError = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException( notFoundError.getMessage() );

                default:
                    ErrorDto error = response.readEntity( ErrorDto.class );
                    throw new AppException( error.getMessage() );
            }
        }
    }


}
