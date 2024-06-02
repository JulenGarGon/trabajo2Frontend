package es.upsa.dasi.www.adapters.input.controllers;


import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.www.adapters.input.controllers.dtos.Action;
import es.upsa.dasi.www.adapters.input.controllers.forms.DesarrolladorForm;
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

@Path("/{locale}/desarrolladores")
@RequestScoped
public class DesarrolladoresController {

    @Inject
    BindingResult bindingResult;
    @Inject
    MvcContext mvcContext;

    @Inject
    Models models;

    @Inject
    FindDesarrolladoresUseCase findDesarrolladoresUseCase;

    @Inject
    FindDesarrolladorByIdUseCase findDesarrolladorByIdUseCase;

    @Inject
    FindVideojuegosByDesarrolladoresUseCase findVideojuegosByDesarrolladoresUseCase;

    @Inject
    UpdateDesarrolladorByIdUseCase updateDesarrolladorByIdUseCase;

    @Inject
    DeleteDesarrolladorByIdUseCase deleteDesarrolladorByIdUseCase;

    @Inject
    InsertDesarrolladorUseCase insertDesarrolladorUseCase;

    @GET
    @Controller
    @UriRef("getDesarrolladores")
    @View("/jsps/desarrolladores.jsp")
    public void getDesarrolladores() throws AppException{
        List<Desarrollador> desarrolladores = findDesarrolladoresUseCase.execute();
        models.put("desarrolladores", desarrolladores);
    }

    @GET
    @Path("/{idDesarrollador}")
    @Controller
    @UriRef("getDesarrolladorById")
    @View("/jsps/desarrollador.jsp")
    public void getDesarrolladorById(@PathParam("idDesarrollador") int idDesarrollador) throws AppException {
        Desarrollador desarrollador = findDesarrolladorByIdUseCase.execute(idDesarrollador);
        models.put("desarrollador", desarrollador);
        models.put("action", Action.SELECT);
        List<Videojuego> videojuegos = findVideojuegosByDesarrolladoresUseCase.execute(desarrollador.id());
        models.put("videojuegos", videojuegos);
        mvcContext.uri("getDesarrolladorById", Map.of("idDesarrollador", "0", "locale", mvcContext.getLocale()));
    }

    @PUT
    @Path("/{idDesarrollador}")
    @Controller
    @UriRef("updateDesarrolladorById")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateDesarrolladorById(@PathParam("idDesarrollador")   int idDesarrollador,
                                            @Valid @BeanParam DesarrolladorForm    form
                                            ) throws AppException {

        Desarrollador desarrollador = Desarrollador.builder()
                                                    .withId(idDesarrollador)
                                                    .withNombre(form.getNombre())
                                                    .withFundacion(form.getFundacion())
                                                    .withFundador(form.getFundador())
                                                    .withEmpleados(form.getEmpleados())
                                                    .withSede(form.getSede())
                                                    .withSitioWeb(form.getSitioWeb())
                                                    .withLogo(form.getLogo())
                                                    .build();

        Desarrollador updatedDesarrollador = updateDesarrolladorByIdUseCase.execute(desarrollador);

        return Response.status(Response.Status.SEE_OTHER)
                                        .location(mvcContext.uri("getDesarrolladorById", Map.of("idDesarrollador", idDesarrollador, "locale", mvcContext.getLocale())))
                                        .build();
    }
    @DELETE
    @Path("/{idDesarrollador}")
    @Controller
    @UriRef("deleteDesarrolladorById")
    public Response deleteDesarrolladorById(@PathParam("idDesarrollador")  int idDesarrollador) throws AppException {

        deleteDesarrolladorByIdUseCase.execute(idDesarrollador);
        return Response.status(Response.Status.SEE_OTHER)
                                        .location(mvcContext.uri("getDesarrolladores", Map.of("locale", mvcContext.getLocale())))
                                        .build();
    }


    @POST
    @Controller
    @UriRef("insertDesarrollador")
    public Response updateDesarrolladorById(@Valid @BeanParam DesarrolladorForm form
    ) throws AppException {

        Desarrollador desarrollador = Desarrollador.builder()
                .withId(0)
                .withNombre(form.getNombre())
                .withFundacion(form.getFundacion())
                .withFundador(form.getFundador())
                .withEmpleados(form.getEmpleados())
                .withSede(form.getSede())
                .withSitioWeb(form.getSitioWeb())
                .withLogo(form.getLogo())
                .build();

        if (bindingResult.isFailed()){
            Map<String, String> errores = bindingResult.getAllErrors()
                    .stream()
                    .collect(Collectors.toMap(paramError -> paramError.getParamName(),
                            paramError -> paramError.getMessage()
                    ));
            models.put("videojuego", desarrollador);
            models.put("action", Action.INSERT);
            models.put("errores", errores);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("/jsps/desarrollador.jsp")
                    .build();
        }

        Desarrollador insertedDesarrollador = insertDesarrolladorUseCase.execute(desarrollador);

        return Response.status(Response.Status.SEE_OTHER)
                .location(mvcContext.uri("getDesarrolladores", Map.of("locale", mvcContext.getLocale())))
                .build();
    }

}
