package model;

public class ImovelAlugado extends Imovel{
	private Locatario locatario;
	
	public ImovelAlugado(Integer idImovel, String status, String endereco, Imobiliaria imobiliaria, Proprietario proprietario, Locatario locatario) {
		super(idImovel, status, endereco, proprietario);
		this.locatario = locatario;
	}

	public ImovelAlugado(Imovel imovel, Locatario idLocatario) {
		super(imovel);
		this.locatario = idLocatario;
	}

	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}
	
	
}
