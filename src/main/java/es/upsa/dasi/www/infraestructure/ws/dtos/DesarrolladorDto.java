package es.upsa.dasi.www.infraestructure.ws.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class DesarrolladorDto {
    private int id;
    private String nombre;
    private String fundacion;
    private String fundador;
    private int empleados;
    private String sede;
    private String sitioWeb;
    private String logo;
}
