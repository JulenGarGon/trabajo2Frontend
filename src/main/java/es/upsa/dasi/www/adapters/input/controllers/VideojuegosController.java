package es.upsa.dasi.www.adapters.input.controllers;


import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.adapters.input.controllers.dtos.Action;
import es.upsa.dasi.www.adapters.input.controllers.forms.VideojuegoForm;
import es.upsa.dasi.www.application.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.*;
import jakarta.mvc.binding.BindingResult;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/{locale}/videojuegos")
@RequestScoped
public class VideojuegosController {

    @Inject
    BindingResult bindingResult;

    @Inject
    MvcContext mvcContext;

    //Es similar a un mapa
    @Inject
    Models models;

    @Inject
    FindVideojuegosUseCase findVideojuegosUseCase;

    @Inject
    FindVideojuegoByIdUseCase findVideojuegoByIdUseCase;

    @Inject
    FindDesarrolladorByIdUseCase findDesarrolladorByIdUseCase;

    @Inject
    UpdateVideojuegoUseCase updateVideojuegoUseCase;

    @Inject
    DeleteVideojuegoByIdUseCase deleteVideojuegoByIdUseCase;

    @Inject
    InsertVideojuegoUseCase insertVideojuegoUseCase;

    @Inject
    FindDesarrolladoresUseCase findDesarrolladoresUseCase;

    @GET
    @Controller
    @UriRef("getVideojuegos")
    //El view es la vista por defecto
    @View("/jsps/videojuegos.jsp")
    public void getVideojuegos() throws AppException {
        List<Videojuego> videojuegos = findVideojuegosUseCase.execute();
        models.put("videojuegos", videojuegos);
    }

    @GET
    @Path("/{idVideojuego}")
    @Controller
    @UriRef("getVideojuegoById")
    @View("/jsps/videojuego.jsp")
    public void getVideojuegoById(@PathParam("idVideojuego") int idVideojuego) throws AppException {

        Videojuego videojuego = findVideojuegoByIdUseCase.execute(idVideojuego);
        models.put("videojuego", videojuego);
        models.put("action", Action.SELECT);
        Desarrollador desarrollador = findDesarrolladorByIdUseCase.execute(videojuego.desarrollador());
        models.put("desarrollador", desarrollador);
        List<Desarrollador> desarrolladores = findDesarrolladoresUseCase.execute();
        models.put("desarrolladores", desarrolladores);
        mvcContext.uri("getVideojuegoById", Map.of("idVideojuego", "0", "locale", mvcContext.getLocale()));
    }

    @PUT
    @Path("/{idVideojuego}")
    @Controller
    @UriRef("updateVideojuegoById")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateVideojuegoById(@PathParam("idVideojuego")     int idVideojuego,
                                         @Valid @BeanParam                     VideojuegoForm form
                                         ) throws AppException
    {



        Videojuego videojuego = Videojuego.builder()
                .withId(idVideojuego)
                .withNombre(form.getNombre())
                .withGenero(form.getGenero())
                .withEstreno(form.getEstreno())
                .withPortada(form.getPortada())
                .withDuracion(form.getDuracion())
                .withTamanio(form.getTamanio())
                .withVentas(form.getVentas())
                .withDesarrollador(form.getDesarrollador())
                .withNota(form.getNota())
                .build();
        Videojuego updatedVideojuego = updateVideojuegoUseCase.execute(videojuego);
        List<Desarrollador> desarrolladores = findDesarrolladoresUseCase.execute();
        models.put("desarrolladores", desarrolladores);
        return Response.status(Response.Status.SEE_OTHER)
                                        .location(mvcContext.uri("getVideojuegoById" , Map.of("idVideojuego", idVideojuego, "locale", mvcContext.getLocale())))
                                        .build();
    }

    @DELETE
    @Path("/{idVideojuego}")
    @Controller
    @UriRef("deleteVideojuegoById")
    public Response deleteVideojuegoById(@PathParam("idVideojuego") int idVideojuego) throws AppException
    {
        deleteVideojuegoByIdUseCase.execute(idVideojuego);
        return Response.status(Response.Status.SEE_OTHER)
                                        .location(mvcContext.uri("getVideojuegos", Map.of("locale", mvcContext.getLocale())))
                                        .build();
    }

    @POST
    @Controller
    @UriRef("insertVideojuego")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertVideojuego(@Valid @BeanParam VideojuegoForm form
                                        ) throws AppException
    {



        Videojuego videojuego = Videojuego.builder()
                .withId(0)
                .withNombre(form.getNombre())
                .withGenero(form.getGenero())
                .withEstreno(form.getEstreno())
                .withPortada(form.getPortada())
                .withDuracion(form.getDuracion())
                .withTamanio(form.getTamanio())
                .withVentas(form.getVentas())
                .withDesarrollador(form.getDesarrollador())
                .withNota(form.getNota())
                .build();

        if (bindingResult.isFailed()){
            Map<String, String> errores = bindingResult.getAllErrors()
                    .stream()
                    .collect(Collectors.toMap(paramError -> paramError.getParamName(),
                                              paramError -> paramError.getMessage()
                                             ));
            List<Desarrollador> desarrolladores = findDesarrolladoresUseCase.execute();
            models.put("desarrolladores", desarrolladores);
            models.put("videojuego", videojuego);
            models.put("action", Action.INSERT);
            models.put("errores", errores);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("/jsps/videojuego.jsp")
                    .build();
        }

        Videojuego insertedVideojuego = insertVideojuegoUseCase.execute(videojuego);
        List<Desarrollador> desarrolladores = findDesarrolladoresUseCase.execute();
        models.put("desarrolladores", desarrolladores);
        return Response.status(Response.Status.SEE_OTHER)
                .location(mvcContext.uri("getVideojuegos", Map.of("locale", mvcContext.getLocale())))
                .build();
    }
}
