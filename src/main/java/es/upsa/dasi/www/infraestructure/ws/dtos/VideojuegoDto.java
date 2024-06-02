package es.upsa.dasi.www.infraestructure.ws.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class VideojuegoDto {
    private int id;
    private String nombre;
    private String genero;
    private String estreno;
    private String portada;
    private float duracion;
    private float tamanio;
    private int ventas;
    private int desarrollador;
    private float nota;
}
