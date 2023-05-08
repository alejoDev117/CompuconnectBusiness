package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilMail;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class PersonaEncargadaDomain {
    private UUID identificador;
    private String nombre;
    private String correoInstitucional;
    private String numeroCelular;

    private static final PersonaEncargadaDomain DEFAULT_OBJECT = new PersonaEncargadaDomain();

    public PersonaEncargadaDomain(UUID identificador, String nombre, String correoInstitucional, String numeroCelular) {
        setIdentificador(identificador);
        setNombre(nombre);
        setCorreoInstitucional(correoInstitucional);
        setNumeroCelular(numeroCelular);
    }

    private PersonaEncargadaDomain() {
        setIdentificador(UtilUUID.getDefaultUuid());
        setNombre(UtilText.getDefaultValue());
        setCorreoInstitucional(UtilMail.getDefaultValueMail());
        setNumeroCelular(UtilText.getDefaultValue());
    }

    public static PersonaEncargadaDomain getDefaultObject() {
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
        this.nombre = UtilText.applyTrim(nombre);
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    private final void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = UtilText.applyTrim(correoInstitucional);
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    private final void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = UtilText.applyTrim(numeroCelular);
    }
}
