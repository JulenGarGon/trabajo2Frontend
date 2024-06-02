package es.upsa.dasi.www.infraestructure;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.locale.LocaleResolver;
import jakarta.mvc.locale.LocaleResolverContext;

import java.util.Locale;

@RequestScoped
public class VideojuegosLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(LocaleResolverContext localeResolverContext) {
        String language = localeResolverContext.getUriInfo()
                             .getPathSegments()
                             .get(0)
                             .getPath();
        return Locale.of(language);
    }
}
