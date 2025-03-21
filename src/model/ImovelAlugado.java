package model;

public class ImovelAlugado extends Imovel{
	private Locatario locatario;
	
	public ImovelAlugado(Integer idImovel, String endereco, Proprietario proprietario, Locatario locatario) {
		super(idImovel, endereco, proprietario);
		this.locatario = locatario;
	}

	public ImovelAlugado(Imovel imovel, Locatario locatario) {
		super(imovel);
		this.locatario = locatario;
	}

	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}
	
	
}
