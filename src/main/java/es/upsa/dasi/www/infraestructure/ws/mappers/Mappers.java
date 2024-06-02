package es.upsa.dasi.www.infraestructure.ws.mappers;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.www.infraestructure.ws.dtos.DesarrolladorDto;
import es.upsa.dasi.www.infraestructure.ws.dtos.VideojuegoDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Mappers {
    public VideojuegoDto toVideojuegoDto(Videojuego videojuego){
        return VideojuegoDto.builder()
                            .withNombre(videojuego.nombre())
                            .withGenero(videojuego.genero())
                            .withEstreno(videojuego.estreno())
                            .withPortada(videojuego.portada())
                            .withDuracion(videojuego.duracion())
                            .withTamanio(videojuego.tamanio())
                            .withVentas(videojuego.ventas())
                            .withDesarrollador(videojuego.desarrollador())
                            .withNota(videojuego.nota())
                            .build();
    }


    public DesarrolladorDto toDesarrolladorDto (Desarrollador desarrollador){
        return DesarrolladorDto.builder()
                .withId(desarrollador.id())
                .withNombre(desarrollador.nombre())
                .withFundacion(desarrollador.fundacion())
                .withFundador(desarrollador.fundador())
                .withEmpleados(desarrollador.empleados())
                .withSede(desarrollador.sede())
                .withSitioWeb(desarrollador.sitioWeb())
                .withLogo(desarrollador.logo())
                .build();
    }
}
