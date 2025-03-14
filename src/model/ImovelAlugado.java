package model;

public class ImovelAlugado extends Imovel{
	private Integer idLocatario;
	
	public ImovelAlugado(Integer idImovel, String status, String endereco, Integer idAgenda, Integer idImobiliaria, Integer idProprietario, Integer idLocatario) {
		super(idImovel, status, endereco, idAgenda, idImobiliaria, idProprietario);
		this.idLocatario = idLocatario;
	}

	public ImovelAlugado(Imovel imovel, Integer idLocatario) {
		super(imovel);
		this.idLocatario = idLocatario;
	}

	public Integer getIdLocatario() {
		return idLocatario;
	}

	public void setIdLocatario(Integer idLocatario) {
		this.idLocatario = idLocatario;
	}
	
	
}
