package es.upsa.dasi.www.adapters.input.controllers;


import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;

@Path("/videojuegos")
@RequestScoped
public class VideojuegosController {

    //Es similar a un mapa
    @Inject
    Models models;

    @GET
    @Controller
    //El view es la vista por defecto
    @View("/jsps/videojuegos.jsp")
    public void getVideojuegos(){

        List<Videojuego> videojuegos = List.of(
                new Videojuego(1,"SuperMario", "Plataformas", LocalDate.parse("2008-01-01"), "www.fotomario.com", 1, 1,1, 1,1),
                new Videojuego(2,"SuperMario", "Plataformas", LocalDate.parse("2008-01-01"), "www.fotomario.com", 1, 1,1, 1,1)
        );
        models.put("videojuegos", videojuegos);



        //return "/jsps/videojuegos.jsp";
        //return Response.ok()
        //                .entity("/jsps/videojuegos.jsp")
        //                .build();
    }
}
