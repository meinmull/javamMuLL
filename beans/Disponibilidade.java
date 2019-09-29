package beans;

public class Disponibilidade {

	private String StringDia; 
	private int DIADASEMANA; 
	private int COD_DIA; 
	private int DIADEHOJE;
	private int RESULTADODIACOLETA;  
	private int TOTALSEMANA;
	private String periodos;
	private String dias;
	private double HOR_COLETA;

	
	public double getHOR_COLETA() {
		return HOR_COLETA;
	}
	public void setHOR_COLETA(double hOR_COLETA) {
		HOR_COLETA = hOR_COLETA;
	}
	public String getDATACOLETA() {
		return DATACOLETA;
	}
	public void setDATACOLETA(String dATACOLETA) {
		DATACOLETA = dATACOLETA;
	}
	private String DATACOLETA;
	public String getStringDia() {
		return StringDia;
	}
	public void setStringDia(String stringDia) {
		StringDia = stringDia;
	}
	public int getDIADASEMANA() {
		return DIADASEMANA;
	}
	public void setDIADASEMANA(int dIADASEMANA) {
		DIADASEMANA = dIADASEMANA;
	}
	public int getCOD_DIA() {
		return COD_DIA;
	}
	public void setCOD_DIA(int cOD_DIA) {
		COD_DIA = cOD_DIA;
	}
	public String getPeriodos() {
		return periodos;
	}
	public void setPeriodos(String periodos) {
		this.periodos = periodos;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public int getDIADEHOJE() {
		return DIADEHOJE;
	}
	public void setDIADEHOJE(int i) {
		DIADEHOJE = i;
	}
	public int getRESULTADODIACOLETA() {
		return RESULTADODIACOLETA;
	}
	public void setRESULTADODIACOLETA(int rESULTADODIACOLETA) {
		RESULTADODIACOLETA = rESULTADODIACOLETA;
	}
	public int getTOTALSEMANA() {
		return TOTALSEMANA;
	}
	public void setTOTALSEMANA(int tOTALSEMANA) {
		TOTALSEMANA = tOTALSEMANA;
	}
	
}
