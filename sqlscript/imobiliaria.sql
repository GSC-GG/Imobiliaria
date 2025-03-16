drop database if exists imobiliaria;
create database imobiliaria;
use imobiliaria;

create table Aluguel(
	idAluguel int(5) auto_increment primary key,
    idLocatario int(5) not null,
    valor double not null,
    dataVencimento DATE not null,
    dataPagamento DATE default null,
	situacao varchar(8) not null
);

create table Contrato(
	idContrato int(5) auto_increment primary key,
    idImovel int(5)  not null,
    valorAluguel double not null,
    dataAssinatura DATE default null,
	situacao varchar(8) not null
);

create table Corretor(
	idCorretor int(5) auto_increment primary key,
    idImobiliaria int(5) not null,
    nome varchar(50) not null,
	telefone char(11) not null,
    email varchar(50) not null
);

create table Funcionario(
	idFuncionario int(5) auto_increment primary key,
    idImobiliaria int(5) not null,
    nome varchar(50) not null,
	telefone char(11) not null,
    email varchar(50) not null
);

create table Imobiliaria(
	idImobiliaria int(5) auto_increment primary key,
    cnpj char(14) not null
);

create table Imovel(
	idImovel int(5) auto_increment primary key,
    idImobiliaria int(5) not null,
    situacao varchar(12) not null,
	endereco varchar(100) not null,
    idProprietario int(5) not null,
    idLocatario int(5) default null
);

create table Locatario(
	idLocatario int(5) auto_increment primary key,
    nome varchar(50) not null,
	telefone char(11) not null,
    email varchar(50) not null,
    situacao varchar(11) not null
);

create table Proposta(
	idProposta int(5) auto_increment primary key,
    idContrato int(5) not null,
    valorAluguel double not null
);

create table Proprietario(
	idProprietario int(5) auto_increment primary key,
    nome varchar(50) not null,
	telefone char(11) not null,
    email varchar(50) not null
);

create table Visita(
	idVisita int(5) auto_increment primary key,
    idImovel int(5) not null,
    dataVisita DATE not null,
    situacao varchar(10)
);

create table Vistoria(
	idVistoria int(5) auto_increment primary key,
    idImovel int(5) not null,
    dataVistoria DATE not null,
    resultado varchar(10) not null
);

DELIMITER $$
-- CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_`(IN `` INT)
-- BEGIN
-- 	INSERT INTO VALUES;
-- END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Aluguel`(IN `v_idLocatario` INT, IN `v_valor` DOUBLE, IN `v_dataVencimento` DATE)
BEGIN
    INSERT INTO Aluguel (idLocatario, valor, dataVencimento, dataPagamento, situacao) VALUES (v_idLocatario, v_valor, v_dataVencimento, default, 'Pendente');
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Contrato`(IN `v_idImovel` INT, IN `v_valorAluguel` DOUBLE)
BEGIN
    INSERT INTO Contrato (idImovel, valorAluguel, dataAssinatura, situacao) VALUES (v_idImovel, v_valorAluguel, default, 'Pendente');
    
    UPDATE Imovel
    SET situacao = 'Negociacao'
    WHERE idImovel = v_idImovel;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Corretor`(IN `v_idImobiliaria` INT(5), IN `v_nome` VARCHAR(50), IN `v_telefone` CHAR(11), IN `v_email` VARCHAR(50))
BEGIN
    INSERT INTO Corretor (nome, telefone, email) VALUES (v_nome, v_telefone, v_email);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Funcionario`(IN `v_nome` VARCHAR(50), IN `v_telefone` CHAR(11), IN `v_email` VARCHAR(50))
BEGIN
    INSERT INTO Funcionario (nome, telefone, email) VALUES (v_nome, v_telefone, v_email);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Imobiliaria`(IN `v_cnpj` CHAR(14))
BEGIN
    INSERT INTO Imobiliaria (cnpj) VALUES (v_cnpj);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Imovel`(IN `v_idImobiliaria` INT, IN `v_endereco` VARCHAR(50))
BEGIN
	INSERT INTO Imovel (idImobiliaria, situacao, endereco, idAgenda, idLocatario) VALUES (v_idImobiliaria, 'Indisponivel', v_endereco, default, default);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Locatario`(IN `v_nome` VARCHAR(50), IN `v_telefone` CHAR(11), IN `v_email` VARCHAR(50))
BEGIN
    INSERT INTO Locatario (nome, telefone, email, situacao) VALUES (v_nome, v_telefone, v_email, 'Desalojado');
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Proposta`(IN `v_idContrato` INT, IN `v_valorAluguel` DOUBLE)
BEGIN
    INSERT INTO Proposta (idContrato, valorAluguel) VALUES (v_idContrato, v_valorAluguel);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Proprietario`(IN `v_nome` VARCHAR(50), IN `v_telefone` CHAR(11), IN `v_email` VARCHAR(50))
BEGIN
    INSERT INTO Proprietario (nome, telefone, email) VALUES (v_nome, v_telefone, v_email);
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Visita`(IN `v_dataVisita` DATE)
BEGIN
    INSERT INTO Visita (dataVisita, situacao) VALUES (v_dataVisita, 'Pendente');
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_Vistoria`(IN `v_dataVistoria` DATE)
BEGIN
    INSERT INTO Vistoria (dataVistoria, resultado) VALUES (v_dataVistoria, 'Pendente');
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Aluguel`(IN `v_idAluguel` INT)
BEGIN
    SELECT * FROM Aluguel WHERE idAluguel = v_idAluguel;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Contrato`(IN `v_idContrato` INT)
BEGIN
    SELECT * FROM Contrato WHERE idContrato = v_idContrato;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Contrato_Imovel`(IN `v_idImovel` INT)
BEGIN
    SELECT * FROM Contrato WHERE idImovel = v_idImovel;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Corretor`(IN `v_idCorretor` INT)
BEGIN
    SELECT * FROM Corretor WHERE idCorretor = v_idCorretor;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Funcionario`(IN `v_idFuncionario` INT)
BEGIN
    SELECT * FROM Funcionario WHERE idFuncionario = v_idFuncionario;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Imobiliaria`(IN `v_idImobiliaria` INT)
BEGIN
    SELECT * FROM Imobiliaria WHERE idImobiliaria = v_idImobiliaria;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Imovel`(IN `v_idImovel` INT)
BEGIN
    SELECT * FROM Imovel WHERE idImovel = v_idImovel;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_ImovelIdProp`(IN `v_idProprietario` INT)
BEGIN
	SELECT * FROM Imovel WHERE idProprietario = v_idProprietario;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Locatario`(IN `v_idLocatario` INT)
BEGIN
    SELECT * FROM Locatario WHERE idLocatario = v_idLocatario;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Proposta`(IN `v_idProposta` INT)
BEGIN
    SELECT * FROM Proposta WHERE idProposta = v_idProposta;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Proprietario`(IN `v_idProprietario` INT)
BEGIN
    SELECT Proprietario.* FROM Proprietario WHERE idProprietario = v_idProprietario;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Visita`(IN `v_idVisita` INT)
BEGIN
    SELECT * FROM Visita WHERE idVisita = v_idVisita;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Vistoria`(IN `v_idVistoria` INT)
BEGIN
    SELECT * FROM Vistoria WHERE idVistoria = v_idVistoria;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_Ultimo_Proprietario`()
BEGIN
	SELECT * FROM Proprietario ORDER BY idProprietario DESC LIMIT 1;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `aceitar_Proposta`(IN `v_idProposta` INT)
BEGIN
    DECLARE v_valorAluguel INT;
    DECLARE v_idContrato INT;
    
    SELECT valorAluguel INTO v_valorAluguel
    FROM Proposta WHERE idProposta = v_idProposta
    LIMIT 1;

    SELECT idContrato INTO v_idContrato
    FROM Proposta WHERE idProposta = v_idProposta
    LIMIT 1;

    UPDATE Contrato
    SET valorAluguel = v_valorAluguel
    WHERE idContrato = v_idContrato;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `recusar_Proposta`(IN `v_idProposta` INT)
BEGIN
    DELETE FROM Proposta
    WHERE idProposta = v_idProposta;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `fechar_Contrato`(IN `v_idContrato` INT, IN `v_idLocatario` INT)
BEGIN
    DECLARE v_idImovel INT;
    
    UPDATE Contrato
    SET situacao = 'Vigente', dataAssinatura = CURDATE()
    WHERE idContrato = v_idContrato;

    SELECT idImovel INTO v_idImovel
    FROM Contrato WHERE idContrato = v_idContrato
    LIMIT 1;

    UPDATE Imovel
    SET situacao = 'Alugado', idLocatario = v_idLocatario
    WHERE idImovel = v_idImovel;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `encerrar_Contrato`(IN `v_idContrato` INT)
BEGIN
    DECLARE v_idImovel INT;
    DECLARE v_idLocatario INT;
    
    SELECT idImovel INTO v_idImovel
    FROM Contrato WHERE idContrato = v_idContrato
    LIMIT 1;

    SELECT idLocatario INTO v_idLocatario
    FROM Imovel WHERE idImovel = v_idImovel
    LIMIT 1;

    UPDATE Imovel
    SET situacao = 'Disponivel', idLocatario = NULL
    WHERE idImovel = v_idImovel;

    DELETE FROM Aluguel
    WHERE idLocatario = v_idLocatario;

    DELETE FROM Contrato
    WHERE idContrato = v_idContrato;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `avaliar_Imovel`(IN `v_idVistoria` INT(5), IN `v_resultado` VARCHAR(11))
BEGIN
	DECLARE v_idAgenda INT(5);
    
    SELECT idAgenda INTO v_idAgenda
    FROM Vistoria
    WHERE idVistoria = v_idVistoria;

	CASE v_resultado
		WHEN 'Aprovado' THEN 
        
			UPDATE Vistoria 
			SET resultado = 'Aprovado'
			WHERE idVistoria = v_idVistoria;
            
            UPDATE Imovel
			SET situacao = 'Disponivel', idAgenda = v_idAgenda
			WHERE idImovel = v_idAgenda;
            
		WHEN 'Reprovado' THEN
        
			UPDATE Vistoria 
			SET resultado = 'Reprovado'
			WHERE idVistoria = v_idVistoria;
            
			UPDATE Imovel
			SET situacao = 'Indisponivel'
			WHERE idAgenda = v_idAgenda;
            
	END CASE;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `realizar_Visita` (IN `v_idVisita` INT(5))
BEGIN
	UPDATE Visita
    SET situacao = 'Realizada'
    WHERE idVisita = v_idVisita;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pagar_Aluguel` (IN `v_idAluguel` INT(5))
BEGIN
	UPDATE Aluguel
    SET situacao = 'Pago'
    WHERE idAluguel = v_idAluguel;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `verifica_Pagamento_Aluguel` ()
BEGIN
	DECLARE v_idLocatario INT(5);
	DECLARE v_idImovel INT(5);
	DECLARE v_idContrato INT(5);
    
	SELECT idLocatario INTO v_idLocatario
    FROM Aluguel WHERE CURDATE() > dataVencimento;
    
	SELECT idImovel INTO v_idImovel
	FROM Imovel WHERE idLocatario = v_idLocatario;
    
    SELECT idContrato INTO v_idContrato
    FROM Contrato WHERE idImovel = v_idImovel;
    
	CALL encerrar_Contrato(v_idContrato);
            
	UPDATE Aluguel
    SET situacao = 'Atrasado', valorPagamento = valorPagamento * 2.125
    WHERE CURDATE() > dataPagamento AND CURDATE() <= dataVencimento;
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mes_Aluguel` (IN `v_idAluguel` INT(5))
BEGIN
	UPDATE Aluguel
    SET dataPagamento = ADDDATE(dataPagamento, INTERVAL 1 MONTH),
    dataVencimento = ADDDATE(dataVencimento, INTERVAL 1 MONTH)
    WHERE dataPagamento < CURDATE();
END $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_Corretores` (IN `v_idImobiliaria` INT(5))
	SELECT Corretor.* FROM Corretor 
    WHERE Corretor.idImobiliaria = v_idImobiliaria;
    
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_Funcionarios` (IN `v_idImobiliaria` INT(5))
	SELECT Funcionario.* FROM Funcionario 
    WHERE Funcionario.idImobiliaria = v_idImobiliaria;

CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_Visitas` (IN `v_idAgenda` INT (5))
	SELECT Visita.* FROM Visita
    WHERE Visita.idAgenda = v_idAgenda $$
    
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_Vistorias` (IN `v_idAgenda` INT (5))
	SELECT Vistoria.* FROM Vistoria
    WHERE Vistoria.idAgenda = v_idAgenda $$
    
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_Alugueis` (IN `v_idLocatario` INT (5))
	SELECT Aluguel.* FROM Aluguel
    WHERE Aluguel.idLocatario = v_idLocatario $$
    
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_Imoveis` (IN `v_idImobiliaria` INT(5))
	SELECT Imovel.* FROM Imovel
    WHERE Imovel.idImobiliaria = v_idImobiliaria $$

-- CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_ImoveisLivres` (IN `v_idImobiliaria` INT(5))
	-- SELECT Imovel.* FROM Imovel
    -- WHERE Imovel.idImobiliaria = v_idImobiliaria AND 
		-- Imovel.situacao = 'Disponivel' $$

DELIMITER ;