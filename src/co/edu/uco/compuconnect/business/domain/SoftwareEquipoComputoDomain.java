package co.edu.uco.compuconnect.business.domain;

import java.util.UUID;

import co.edu.uco.compuconnect.crosscutting.utils.UtilObject;
import co.edu.uco.compuconnect.crosscutting.utils.UtilUUID;

public final class SoftwareEquipoComputoDomain {
	
	private static final SoftwareEquipoComputoDomain DEFAULT_OBJECT = new SoftwareEquipoComputoDomain();
	private UUID identificador;
	private SoftwareDomain software;
	private EquipoComputoDomain equipoComputo;
	
	
	
	
	public SoftwareEquipoComputoDomain(UUID identificador, SoftwareDomain software, EquipoComputoDomain equipoComputo) {
		super();
		setIdentificador(identificador);
		setSoftware(software);
		setEquipoComputo(equipoComputo);
	}




	private SoftwareEquipoComputoDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultUuid());
		setSoftware(SoftwareDomain.getDefaultObject());
		setEquipoComputo(EquipoComputoDomain.getDefaultObject());
	}

	
	



	public static final SoftwareEquipoComputoDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}




	public final UUID getIdentificador() {
		return identificador;
	}




	private final void setIdentificador(UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
		
	}




	public final SoftwareDomain getSoftware() {
		return software;
	}




	private final void setSoftware(SoftwareDomain software) {
		this.software = UtilObject.getDefault(software, SoftwareDomain.getDefaultObject());
		
	}




	public final EquipoComputoDomain getEquipoComputo() {
		return equipoComputo;
	}




	private final void setEquipoComputo(EquipoComputoDomain equipoComputo) {
		this.equipoComputo = UtilObject.getDefault(equipoComputo, EquipoComputoDomain.getDefaultObject());
		
	}





	

}
