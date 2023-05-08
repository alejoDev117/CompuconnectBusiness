package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class ContenidoDomain {
    private UUID identificador;
    private String descripcion;

    private static final ContenidoDomain DEFAULT_OBJECT = new ContenidoDomain();

    public ContenidoDomain(UUID identificador, String descripcion) {
        setIdentificador(identificador);
        setDescripcion(descripcion);
    }

    private ContenidoDomain() {
        setIdentificador(UtilUUID.getDefaultUuid());
        setDescripcion(UtilText.getDefaultValue());
    }

    public static ContenidoDomain getDefaultObject() {
        return DEFAULT_OBJECT;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    public String getDescripcion() {
        return descripcion;
    }

    private final void setDescripcion(String descripcion) {
        this.descripcion = UtilText.applyTrim(descripcion);
    }
}

