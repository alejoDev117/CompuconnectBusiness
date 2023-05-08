package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilText;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public class CentroInformaticaEquipoComputoDomain {
	
	
	private static final CentroInformaticaEquipoComputoDomain DEFAULT_OBJECT = new CentroInformaticaEquipoComputoDomain();
	private UUID identificador;
	private CentroInformaticaDomain centroInformatica;
	private EquipoComputoDomain equipoComputo;
	
	
	public CentroInformaticaEquipoComputoDomain(final UUID identificador,final CentroInformaticaDomain centroInformatica,final EquipoComputoDomain equipoComputo) {
		super();
		setIdentificador(identificador);
		setCentroInformatica(centroInformatica);
		setEquipoComputo(equipoComputo);
	
	}
	
	
	private CentroInformaticaEquipoComputoDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setCentroInformatica(CentroInformaticaDomain.getDefaultObject());
		setEquipoComputo(EquipoComputoDomain.getDefaultObject());

	}
	
	
	
	
	
	public static final CentroInformaticaEquipoComputoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}


	public UUID getIdentificador() {
		return identificador;
	}
	
	private void setIdentificador(UUID identificador) {
		this.identificador = identificador;
	}
		
	public CentroInformaticaDomain getCentroInformatica() {
		return centroInformatica;
	}
	
	
	private final void setCentroInformatica(final CentroInformaticaDomain centroInformatica) {
		this.centroInformatica = UtilObject.getDefault(centroInformatica, CentroInformaticaDomain.getDefaultObject());
		
	}
	
	
	public EquipoComputoDomain getEquipoComputo() {
		return equipoComputo;
	}
	
	private final void setEquipoComputo(final EquipoComputoDomain equipoComputo) {
		this.equipoComputo = UtilObject.getDefault(equipoComputo, EquipoComputoDomain.getDefaultObject());
		
	}
	
	

}
