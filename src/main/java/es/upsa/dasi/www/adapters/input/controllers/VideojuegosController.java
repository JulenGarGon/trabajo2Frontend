package es.upsa.dasi.www.adapters.input.controllers;


import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.application.FindVideojuegoByIdUseCase;
import es.upsa.dasi.www.application.FindVideojuegosUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Path("/videojuegos")
@RequestScoped
public class VideojuegosController {

    @Inject
    MvcContext mvcContext;

    //Es similar a un mapa
    @Inject
    Models models;

    @Inject
    FindVideojuegosUseCase findVideojuegosUseCase;

    @Inject
    FindVideojuegoByIdUseCase findVideojuegoByIdUseCase;

    @GET
    @Controller
    @UriRef("getVideojuegos")
    //El view es la vista por defecto
    @View("/jsps/videojuegos.jsp")
    public void getVideojuegos() throws AppException {
        List<Videojuego> videojuegos = findVideojuegosUseCase.execute();
        models.put("videojuegos", videojuegos);



        //return "/jsps/videojuegos.jsp";
        //return Response.ok()
        //                .entity("/jsps/videojuegos.jsp")
        //                .build();
    }

    @GET
    @Path("/{idVideojuego}")
    @Controller
    @UriRef("getVideojuegoById")
    @View("/jsps/videojuego.jsp")
    public void getVideojuegoById(@PathParam("idVideojuego") int idVideojuego) throws AppException {
        Videojuego videojuego = findVideojuegoByIdUseCase.execute(idVideojuego);
        models.put("videojuego", videojuego);
        mvcContext.uri("getVideojuegoById", Map.of("idVideojuego", "0"));
    }
}
