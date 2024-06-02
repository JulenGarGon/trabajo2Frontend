package es.upsa.dasi.www.adapters.input.controllers;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.adapters.input.controllers.dtos.Action;
import es.upsa.dasi.www.application.FindDesarrolladorByIdUseCase;
import es.upsa.dasi.www.application.FindDesarrolladoresUseCase;
import es.upsa.dasi.www.application.FindVideojuegoByIdUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/{locale}/forms")
@RequestScoped
public class FormsController {
    @Inject
    FindVideojuegoByIdUseCase findVideojuegoByIdUseCase;

    @Inject
    FindDesarrolladorByIdUseCase findDesarrolladorByIdUseCase;

    @Inject
    FindDesarrolladoresUseCase findDesarrolladoresUseCase;

    @Inject
    Models models;

    @GET
    @Path("/update/videojuego/{idVideojuego}")
    @Controller
    @UriRef("formUpdateVideojuegoById")
    @View("/jsps/videojuego.jsp")
    public void formsUpdateVideojuegoById(@PathParam("idVideojuego") int idVideojuego) throws AppException {
        Videojuego videojuego = findVideojuegoByIdUseCase.execute(idVideojuego);
        List<Desarrollador> desarrolladores = findDesarrolladoresUseCase.execute();
        models.put("videojuego", videojuego);
        models.put("desarrolladores", desarrolladores);
        models.put("action", Action.UPDATE);
    }
    @GET
    @Path("/delete/videojuego/{idVideojuego}")
    @Controller
    @UriRef("formDeleteVideojuegoById")
    @View("/jsps/videojuego.jsp")
    public void formsDeleteVideojuegoById(@PathParam("idVideojuego") int idVideojuego) throws AppException {
        Videojuego videojuego = findVideojuegoByIdUseCase.execute(idVideojuego);
        models.put("videojuego", videojuego);
        models.put("action", Action.DELETE);
    }

    @GET
    @Path("/insert/videojuego")
    @Controller
    @UriRef("formInsertVideojuego")
    @View("/jsps/videojuego.jsp")
    public void formsInsertVideojuego() throws AppException {
        List<Desarrollador> desarrolladores = findDesarrolladoresUseCase.execute();
        models.put("desarrolladores", desarrolladores);
        models.put("action", Action.INSERT);
    }


    @GET
    @Path("/update/desarrollador/{idDesarrollador}")
    @Controller
    @UriRef("formUpdateDesarrolladorById")
    @View("/jsps/desarrollador.jsp")
    public void formUpdateDesarrolladorById(@PathParam("idDesarrollador") int idDesarrollador) throws AppException {
        Desarrollador desarrollador = findDesarrolladorByIdUseCase.execute(idDesarrollador);
        models.put("desarrollador", desarrollador);
        models.put("action", Action.UPDATE);
    }

    @GET
    @Path("/delete/desarrollador/{idDesarrollador}")
    @Controller
    @UriRef("formDeleteDesarrolladorById")
    @View("/jsps/desarrollador.jsp")
    public void formDeleteDesarrolladorById(@PathParam("idDesarrollador") int idDesarrollador) throws AppException {
        Desarrollador desarrollador = findDesarrolladorByIdUseCase.execute(idDesarrollador);
        models.put("desarrollador", desarrollador);
        models.put("action", Action.DELETE);
    }

    @GET
    @Path("/insert/desarrollador")
    @Controller
    @UriRef("formInsertDesarrollador")
    @View("/jsps/desarrollador.jsp")
    public void formsInsertDesarrollador() throws AppException {
        models.put("action", Action.INSERT);
    }


}
