package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilMail;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class DestinatarioDomain {
    private UUID identificador;
    private String nombre;
    private String correo;

    private static final DestinatarioDomain DEFAULT_OBJECT = new DestinatarioDomain();

    public DestinatarioDomain(UUID identificador, String nombre, String correo) {
        setIdentificador(identificador);
        setNombre(nombre);
        setCorreo(correo);
    }

    private DestinatarioDomain() {
        setIdentificador(UtilUUID.getDefaultUuid());
        setNombre(UtilText.getUtilText().getDefaultValue());
        setCorreo(UtilMail.getDefaultValueMail());
    }

    public static DestinatarioDomain getDefaultObject() {
        return DEFAULT_OBJECT;
    }

    public UUID getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    public String getNombre() {
        return nombre;
    }

    private final void setNombre(String nombre) {
        this.nombre = UtilText.getUtilText().applyTrim(nombre);
    }

    public String getCorreo() {
        return correo;
    }

    private final void setCorreo(String correo) {
        this.correo = UtilText.getUtilText().applyTrim(correo);
    }
}
