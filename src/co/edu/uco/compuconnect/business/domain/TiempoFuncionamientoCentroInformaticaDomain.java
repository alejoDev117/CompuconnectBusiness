package co.edu.uco.compuconnect.business.domain;

import java.time.LocalTime;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilDateTime;
import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class TiempoFuncionamientoCentroInformaticaDomain {
	
	private static final TiempoFuncionamientoCentroInformaticaDomain DEFAULT_OBJECT = new TiempoFuncionamientoCentroInformaticaDomain();
	private UUID identificador;
	private PeriodoFuncionamientoDomain periodoFuncionamiento;
	private CentroInformaticaDomain centroInformatica;
	private DiaSemanalDomain dia;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	
	public TiempoFuncionamientoCentroInformaticaDomain(UUID identificador, PeriodoFuncionamientoDomain periodoFuncionamiento,CentroInformaticaDomain centroInformatica, DiaSemanalDomain dia,LocalTime horaInicio, LocalTime horaFin) {
		super();
		setIdentificador(identificador);
		setPeriodoFuncionamiento(periodoFuncionamiento);
		setCentroInformatica(centroInformatica);
		setDia(dia);
		setHoraInicio(horaInicio);
		setHoraFin(horaFin);
		
		
	}


	private TiempoFuncionamientoCentroInformaticaDomain() {
		super();	
		setIdentificador(UtilUUID.getDefaultUuid());
		setPeriodoFuncionamiento(PeriodoFuncionamientoDomain.getDefaultObject());
		setCentroInformatica(CentroInformaticaDomain.getDefaultObject());
		setDia(DiaSemanalDomain.getDefaultObject());
		setHoraInicio(UtilDateTime.getDefaultValueLocaltime());
		setHoraFin(UtilDateTime.getDefaultValueLocaltime());
		
		}
	
	
	
	
	
	
	
	public static final TiempoFuncionamientoCentroInformaticaDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}




	public UUID getIdentificador() {
		return identificador;
	}
	
	
	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}
	
	public PeriodoFuncionamientoDomain getPeriodoFuncionamiento() {
		return periodoFuncionamiento;
	}
	
	
	private final void setPeriodoFuncionamiento(final PeriodoFuncionamientoDomain centroInformatica) {
		this.periodoFuncionamiento = UtilObject.getDefault(periodoFuncionamiento, PeriodoFuncionamientoDomain.getDefaultObject());
		
	}
	
	
	public CentroInformaticaDomain getCentroInfomatica() {
		return centroInformatica;
		
	}
	
	
	private  final void setCentroInformatica(final CentroInformaticaDomain centroInformatica) {
		this.centroInformatica = UtilObject.getDefault(centroInformatica, CentroInformaticaDomain.getDefaultObject());
		
	}
	
	
	public DiaSemanalDomain getDia() {
		return dia;
	}
	
	
	private void setDia(final DiaSemanalDomain dia) {
		this.dia = UtilObject.getDefault(dia, DiaSemanalDomain.getDefaultObject());
		
	}
	
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	
	private void  setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = UtilDateTime.getDefaultLocalTime(horaInicio);
	
	}

	
	
	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	private void setHoraFin(LocalTime horaFin) {
		this.horaFin = UtilDateTime.getDefaultLocalTime(horaFin);
	
	}
	
	
	
	
}
