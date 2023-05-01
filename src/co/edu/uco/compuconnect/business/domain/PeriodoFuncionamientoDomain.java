package co.edu.uco.compuconnect.business.domain;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class PeriodoFuncionamientoDomain {
	
    private static final PeriodoFuncionamientoDomain DEFAULT_OBJECT = new PeriodoFuncionamientoDomain();
	private UUID identificador;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private DiaFestivoDomain diaFestivo;
	private EstadoPeriodoFuncionamientoDomain estado;
	
	
	
	public PeriodoFuncionamientoDomain(UUID identificador, String nombre, Date fechaInicio, Date fechaFin, DiaFestivoDomain diaFestivo, EstadoPeriodoFuncionamientoDomain estado) {
		super();
		setIdentificador(identificador);
		setNombre(nombre);
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setDiaFestivo(diaFestivo);
		setEstado(estado);
	}


	private PeriodoFuncionamientoDomain() {
		super();	
		setIdentificador(UtilUUID.getDefaultUuid());
		setNombre(UtilText.getDefaultValue());
		setFechaInicio(UtilDateTime.getDefaultValueDate());
		setFechaFin(UtilDateTime.getDefaultValueDate());
		setDiaFestivo(DiaFestivoDomain.getDefaultObject());
		setEstado(EstadoPeriodoFuncionamientoDomain.getDefaultObject());

		}
	

	
	
	
	public static final PeriodoFuncionamientoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}


	public UUID getIdentificador() {
		return identificador;
	}
	
	
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
		
	}

	public String getNombre() {
		return nombre;
	}
	
	private final void setNombre(final String nombre) {
		this.nombre = UtilText.applyTrim(nombre);
		
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	
	private final void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = UtilDateTime.getDefaultDate(fechaInicio);
		
	}
	
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	private final void setFechaFin(final Date fechaInicio) {
		this.fechaFin = UtilDateTime.getDefaultDate(fechaFin);
		
	}
	
	
	public DiaFestivoDomain getDiaFestivo() {
		return diaFestivo;
	}
	
	
	private void setDiaFestivo(final DiaFestivoDomain diaFestivo) {
		this.diaFestivo = UtilObject.getDefault(diaFestivo, DiaFestivoDomain.getDefaultObject()));
		
	
	}
	
	
	public EstadoPeriodoFuncionamientoDomain getEstado() {
		return estado;
	}
	
	
	private  void setEstado(EstadoPeriodoFuncionamientoDomain estado) {
		this.estado = UtilObject.getDefault(estado, EstadoPeriodoFuncionamientoDomain.getDefaultObject());
		
	}
	
	
}
