package gerador.semantico;

import gerador.parser.Classe;

public class OperationContextClass {
	private String codigo;
	private Classe tipo;
	
	public OperationContextClass(Object on,Object fpl,Object rType) {
		OperationNameClass opName = (OperationNameClass) on;
		FormalParameterListClass formParamList = (FormalParameterListClass) fpl;
		ReturnTypeClass returnType = (ReturnTypeClass) rType;
		
	}
	
	public OperationContextClass(Object on, Object fpl) {
		OperationNameClass opName = (OperationNameClass) on;
		FormalParameterListClass formParamList = (FormalParameterListClass) fpl;
		
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Classe getTipe() {
		return tipo;
	}

	public void setTipe(Classe tipe) {
		this.tipo = tipe;
	}

}
