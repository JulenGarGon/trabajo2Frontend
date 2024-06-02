package es.upsa.dasi.www.adapters.input.controllers.forms;

import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.*;
import jakarta.ws.rs.FormParam;
import lombok.Data;

@Data
public class VideojuegoForm {

    @FormParam("nombre")
    @MvcBinding
    @NotNull(message = "{field.nombre} : {error.notnull}")
    @Size(min = 1, max = 50, message = "{field.nombre} : {error.size}")
    private String nombre;
    @FormParam("genero")
    @MvcBinding
    @NotNull(message = "{field.genero} : {error.notnull}")
    @Size(min = 1, max = 100, message = "{field.genero} : {error.size}")
    private String genero;
    @FormParam("duracion")
    @MvcBinding
    @NotNull(message = "{field.duracion} : {error.notnull}")
    @Positive(message = "{field.duracion} : {error.positive}")
    private float duracion;
    @FormParam("tamanio")
    @MvcBinding
    @NotNull(message = "{field.tamanio} : {error.notnull}")
    @Positive(message = "{field.tamanio} : {error.positive}")
    private float tamanio;
    @FormParam("estreno")
    @MvcBinding
    @NotNull(message = "{field.estreno} : {error.notnull}")
    private String estreno;
    @FormParam("ventas")
    @MvcBinding
    @NotNull(message = "{field.ventas} : {error.notnull}")
    @Positive(message = "{field.ventas} : {error.positive}")
    private int ventas;
    @FormParam("nota")
    @MvcBinding
    @NotNull(message = "{field.nota} : {error.notnull}")
    @DecimalMin(value = "0")
    @DecimalMax(value = "10")
    private float nota;
    @FormParam("desarrollador")
    @MvcBinding
    @NotNull(message = "{field.desarrollador} : {error.notnull}")
    private int desarrollador;
    @FormParam("portada")
    @MvcBinding
    @NotNull(message = "{field.portada} : {error.notnull}")
    @NotBlank(message = "{field.portada} : {error.notblank}")
    private String portada;
}
