package model;

public class ImovelLivre extends Imovel{

	public ImovelLivre(Integer idImovel, String status, String endereco, Integer idAgenda, Integer idImobiliaria, Integer idProprietario) {
		super(idImovel, status, endereco, idAgenda, idImobiliaria, idProprietario);
	}

	public ImovelLivre(Imovel imovel) {
		super(imovel);
	}

	public ImovelLivre(Integer idImovel) {
		super(idImovel);
	}

}