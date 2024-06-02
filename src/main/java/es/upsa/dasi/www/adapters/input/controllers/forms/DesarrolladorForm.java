package es.upsa.dasi.www.adapters.input.controllers.forms;

import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;
import lombok.Data;

@Data
public class DesarrolladorForm {

    @FormParam("nombre")
    @MvcBinding
    @NotNull(message = "{field.nombre} : {error.notnull}")
    @Size(min = 1, max = 50, message = "{field.nombre} : {error.size}")
    private String nombre;
    @FormParam("fundacion")
    @MvcBinding
    @NotNull(message = "{field.fundacion} : {error.notnull}")
    private String fundacion;
    @FormParam("fundador")
    @MvcBinding
    @NotNull(message = "{field.fundador} : {error.notnull}")
    @Size(min = 1, max = 100, message = "{field.fundador} : {error.size}")
    private String fundador;
    @FormParam("empleados")
    @MvcBinding
    @NotNull(message = "{field.empleados} : {error.notnull}")
    @Positive(message = "{field.empleados} : {error.positive}")
    private int empleados;
    @FormParam("sede")
    @MvcBinding
    @NotNull(message = "{field.sede} : {error.notnull}")
    @Size(min = 1, max = 200, message = "{field.sede} : {error.size}")
    private String sede;
    @FormParam("sitioWeb")
    @MvcBinding
    @NotNull(message = "{field.sitioweb} : {error.notnull}")
    @Size(min = 1, max = 200, message = "{field.sitioweb} : {error.size}")
    private String sitioWeb;
    @FormParam("logo")
    @MvcBinding
    @NotNull(message = "{field.logo} : {error.notnull}")
    @NotBlank(message = "{field.logo} : {error.notblank}")
    private String logo;
}
