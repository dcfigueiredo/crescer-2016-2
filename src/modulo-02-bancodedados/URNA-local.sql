CREATE TABLE Candidato
  (
    IDCandidato      INTEGER NOT NULL ,
    IDCargoEleitoral INTEGER NOT NULL ,
    IDPartido        INTEGER NOT NULL ,
    IDCidade         INTEGER NOT NULL ,
    NomeCompleto     VARCHAR2 (60) NOT NULL ,
    NomePopular      VARCHAR2 (30) NOT NULL ,
    DataNascimento   DATE NOT NULL ,
    TRE              VARCHAR2 (40) NOT NULL ,
    Foto             VARCHAR2 (256) NOT NULL ,
    NumeroEscolha    VARCHAR2 (5) NOT NULL
  ) ;
ALTER TABLE Candidato ADD CONSTRAINT Candidato_PK PRIMARY KEY ( IDCandidato ) ;


CREATE TABLE CargoEleitoral
  (
    IDCargoEleitoral INTEGER NOT NULL ,
    NomeCargo        VARCHAR2
    --  ERROR: VARCHAR2 size not specified
    NOT NULL
  ) ;
ALTER TABLE CargoEleitoral ADD CONSTRAINT CargoEleitoral_PK PRIMARY KEY ( IDCargoEleitoral ) ;


CREATE TABLE Cidade
  (
    IDCidade INTEGER NOT NULL ,
    IDUF     INTEGER NOT NULL ,
    Nome     VARCHAR2 (40) NOT NULL
  ) ;
ALTER TABLE Cidade ADD CONSTRAINT Cidade_PK PRIMARY KEY ( IDCidade ) ;


CREATE TABLE Eleitor
  (
    IDEleitor       NUMBER NOT NULL ,
    TituloEleitoral VARCHAR2
    --  ERROR: VARCHAR2 size not specified
    NOT NULL ,
    RG             INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (60) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    Zona           VARCHAR2 (10) NOT NULL ,
    Secao          VARCHAR2 (10) NOT NULL ,
    Situacao       CHAR (1) NOT NULL
  ) ;
ALTER TABLE Eleitor ADD CONSTRAINT Eleitor_PK PRIMARY KEY ( IDEleitor ) ;
ALTER TABLE Eleitor ADD CONSTRAINT TituloEleitoral UNIQUE ( TituloEleitoral ) ;
ALTER TABLE Eleitor ADD CONSTRAINT RG UNIQUE ( RG ) ;


CREATE TABLE Partido
  (
    IDPartido INTEGER NOT NULL ,
    Nome      VARCHAR2 (20) NOT NULL
  ) ;
ALTER TABLE Partido ADD CONSTRAINT Partido_PK PRIMARY KEY ( IDPartido ) ;


CREATE TABLE UF
  ( IDUF INTEGER NOT NULL , Sigla VARCHAR2 (3) NOT NULL
  ) ;
ALTER TABLE UF ADD CONSTRAINT UF_PK PRIMARY KEY ( IDUF ) ;


CREATE TABLE Voto
  (
    Voto_ID                NUMBER NOT NULL ,
    Candidato_Candidato_ID INTEGER NOT NULL
  ) ;
-- Error - Index Voto__IDX has no columns
ALTER TABLE Voto ADD CONSTRAINT Voto_PK PRIMARY KEY ( Voto_ID ) ;


ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_CargoEleitoral FOREIGN KEY ( IDCargoEleitoral ) REFERENCES CargoEleitoral ( IDCargoEleitoral ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Cidade FOREIGN KEY ( IDCidade ) REFERENCES Cidade ( IDCidade ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Candidato_Partido FOREIGN KEY ( IDPartido ) REFERENCES Partido ( IDPartido ) ;

ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_UF FOREIGN KEY ( IDUF ) REFERENCES UF ( IDUF ) ;

ALTER TABLE Voto ADD CONSTRAINT Voto_Candidato_FK FOREIGN KEY ( Candidato_Candidato_ID ) REFERENCES Candidato ( IDCandidato ) ;

CREATE SEQUENCE Candidato_IDCandidato_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER Candidato_IDCandidato_TRG BEFORE
  INSERT ON Candidato FOR EACH ROW WHEN (NEW.IDCandidato IS NULL) BEGIN :NEW.IDCandidato := Candidato_IDCandidato_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE CargoEleitoral_IDCargoEleitora START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER CargoEleitoral_IDCargoEleitora BEFORE
  INSERT ON CargoEleitoral FOR EACH ROW WHEN (NEW.IDCargoEleitoral IS NULL) BEGIN :NEW.IDCargoEleitoral := CargoEleitoral_IDCargoEleitora.NEXTVAL;
END;
/

CREATE SEQUENCE Eleitor_IDEleitor_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER Eleitor_IDEleitor_TRG BEFORE
  INSERT ON Eleitor FOR EACH ROW WHEN (NEW.IDEleitor IS NULL) BEGIN :NEW.IDEleitor := Eleitor_IDEleitor_SEQ.NEXTVAL;
END;
/

CREATE SEQUENCE Voto_Voto_ID_SEQ START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER Voto_Voto_ID_TRG BEFORE
  INSERT ON Voto FOR EACH ROW WHEN (NEW.Voto_ID IS NULL) BEGIN :NEW.Voto_ID := Voto_Voto_ID_SEQ.NEXTVAL;
END;
/