package es.upsa.dasi.www.infraestructure;

import jakarta.mvc.form.FormMethodOverwriter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.lang.reflect.Method;
import java.util.Map;

@ApplicationPath("/content")
public class VideojuegosApplication extends Application {
    @Override
    public Map<String, Object> getProperties() {
        return Map.of(FormMethodOverwriter.FORM_METHOD_OVERWRITE, FormMethodOverwriter.Options.ENABLED);
    }
}
