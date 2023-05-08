package co.edu.uco.compuconnect.business.domain;

import java.time.LocalTime;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class HorarioPersonaEncargadaDomain {
	
	private static final HorarioPersonaEncargadaDomain DEFAULT_OBJECT = new HorarioPersonaEncargadaDomain();
	private UUID identificador;
	private TiempoFuncionamientoCentroInformaticaDomain tiempoFuncionamiento;
	private PersonaEncargadaDomain personaEncargada;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	
	public HorarioPersonaEncargadaDomain(UUID identificador, TiempoFuncionamientoCentroInformaticaDomain tiempoFuncionamiento, PersonaEncargadaDomain personaEncargada, LocalTime horaInicio, LocalTime horaFin) {
		super();
		setIdentificador(identificador);
		setTiempoFuncionamiento(tiempoFuncionamiento);
		setPersonaEncargada(personaEncargada);
		setHoraInicio(horaInicio);
		setHoraFin(horaFin);
	}
	
	private HorarioPersonaEncargadaDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setTiempoFuncionamiento(TiempoFuncionamientoCentroInformaticaDomain.getDefaultObject());
		setPersonaEncargada(CoordinadorDomain.getDefaultObject());
		setHoraInicio(UtilDateTime.getDefaultValueLocaltime());
		setHoraFin(UtilDateTime.getDefaultValueLocaltime());
	}
	
	public static final HorarioPersonaEncargadaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
	
	public final UUID getIdentificador() {
		return identificador;
	}
	
	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}
	
	public final TiempoFuncionamientoCentroInformaticaDomain getTiempoFuncionamiento() {
		return tiempoFuncionamiento;
	}
	
	private final void setTiempoFuncionamiento(TiempoFuncionamientoCentroInformaticaDomain tiempoFuncionamiento) {
		this.tiempoFuncionamiento = UtilObject.getDefault(tiempoFuncionamiento, TiempoFuncionamientoCentroInformaticaDomain.getDefaultObject());
	}
	
	public final PersonaEncargadaDomain getPersonaEncargada() {
		return personaEncargada;
	}
	
	private final void setPersonaEncargada(PersonaEncargadaDomain personaEncargada) {
		this.personaEncargada = UtilObject.getDefault(personaEncargada, CoordinadorDomain.getDefaultObject());
	}
	
	public final LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	private final void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = UtilDateTime.getDefaultLocalTime(horaInicio)
				;
	}
	
	public final LocalTime getHoraFin() {
		return horaFin;
	}
	
	private final void setHoraFin(LocalTime horaFin) {
		this.horaFin = UtilDateTime.getDefaultLocalTime(horaFin);
	}

}
