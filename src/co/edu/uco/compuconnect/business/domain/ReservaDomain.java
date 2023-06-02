package co.edu.uco.compuconnect.business.domain;



import java.util.Date;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class ReservaDomain{
	
	private static final ReservaDomain DEFAULT_OBJECT = new ReservaDomain();
	private UUID identificador;
	private AgendaDomain agenda;
	private UsuarioDomain autor;
	private TipoReservaDomain tipoReserva;
	private Date fechaInicio;
	private Date fechaFin;
	private FrecuenciaDomain frecuencia;
	private String descripcion;
	private Date horaCreacion;
	private DetalleReservaDomain detalle;
	

	public ReservaDomain(UUID identificador, AgendaDomain agenda ,UsuarioDomain autor, TipoReservaDomain tipoReserva, Date FechaInicio, Date FechaFin,FrecuenciaDomain frecuencia,String descripcion, Date horaCreacion,
			DetalleReservaDomain detalle) {
		setIdentificador(identificador);
		setAgenda(agenda);
		setAutor(autor);
		setTipoReserva(tipoReserva);
		setFechaInicio(FechaInicio);
		setFechaFin(FechaFin);
		setFrecuencia(frecuencia);
		setDescripcion(descripcion);
		setHoraCreacion(horaCreacion);
		setDetalle(detalle);
	}
	
	private ReservaDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setAgenda(AgendaDomain.getDefaultObject());
		setAutor(UsuarioDomain.getDeafaulObject());
		setTipoReserva(TipoReservaDomain.getDefaultObject());
		setFechaInicio(UtilDateTime.getDefaultValueDate());
		setFechaFin(UtilDateTime.getDefaultValueDate());
		setFrecuencia(FrecuenciaDomain.getDefaultObject());
		setDescripcion(UtilText.getUtilText().getDefaultValue());
		setHoraCreacion(UtilDateTime.getDefaultValueDate());
		setDetalle(DetalleReservaDomain.getDefaultObject());
	}
	
	
	
	
	public static final ReservaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public UUID getIdentificador() {
		return identificador;
	}


	private final void  setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}
	

	
	public UsuarioDomain getAutor() {
		return autor;
	}


	private final  void setAutor(UsuarioDomain autor) {
		this.autor = UtilObject.getDefault(autor, UsuarioDomain.getDeafaulObject());
		
	}


	public String getDescripcion() {
		return descripcion;
	}

	
	private final void  setDescripcion(String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}


	public Date getHoraCreacion() {
		return horaCreacion;
	}


	private final void   setHoraCreacion(Date horaCreacion) {
		this.horaCreacion = UtilDateTime.getDefaultDate(horaCreacion);
		
	}

	
	
	public final TipoReservaDomain getTipoReserva() {
		return tipoReserva;
	}

	private final void setTipoReserva(TipoReservaDomain tipoReserva) {
		this.tipoReserva = UtilObject.getDefault(tipoReserva, TipoReservaDomain.getDefaultObject());
		
	}

	public final Date getFechaInicio() {
		return fechaInicio;
	}

	private final void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = UtilDateTime.getDefaultDate(fechaInicio);
		
	}

	public final Date getFechaFin() {
		return fechaFin;
	}

	private final void setFechaFin(Date fechaFin) {
		this.fechaFin = UtilDateTime.getDefaultDate(fechaFin);
		
	}

	public final FrecuenciaDomain getFrecuencia() {
		return frecuencia;
	}

	private final void setFrecuencia(FrecuenciaDomain frecuencia) {
		this.frecuencia = UtilObject.getDefault(frecuencia, FrecuenciaDomain.getDefaultObject());
	
		
	}

	public final AgendaDomain getAgenda() {
		return agenda;
	}

	public final void setAgenda(AgendaDomain agenda) {
		this.agenda = UtilObject.getDefault(agenda, AgendaDomain.getDefaultObject());
	}

	public final DetalleReservaDomain getDetalle() {
		return detalle;
	}

	public final ReservaDomain setDetalle(DetalleReservaDomain detalle) {
		this.detalle = UtilObject.getDefault(detalle, DetalleReservaDomain.getDefaultObject());
		return this;
	}


	
	

}
