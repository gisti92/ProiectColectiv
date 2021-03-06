USE ProiectColectiv

--**********************************************************************************************************
--************************************ Adaugarea permisiunirol *********************************************
--**********************************************************************************************************
IF NOT EXISTS (SELECT name FROM master.sys.server_principals WHERE name = 'prColectiv')
	BEGIN
		CREATE LOGIN prColectiv  WITH PASSWORD    = N'prColectiv'
	END

IF NOT EXISTS (SELECT name FROM sys.database_principals WHERE name = 'prColectiv') 
	BEGIN
		USE ProiectColectiv
		CREATE USER prColectiv FOR LOGIN prColectiv
		EXEC sp_addrolemember N'db_owner', N'prColectiv'
	END

--**********************************************************************************************************
--****************************************  Stergere tabele ************************************************
--**********************************************************************************************************
IF EXISTS (SELECT * FROM sys.objects WHERE TYPE = 'P' AND name = 'stergeTabele')
DROP PROCEDURE stergeTabele 
GO
CREATE PROCEDURE stergeTabele AS
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Loginuri_Cadre_Didactice') DROP TABLE Loginuri_Cadre_Didactice
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'State_De_Functii') DROP TABLE State_De_Functii
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Alte_Activitati_CD') DROP TABLE Alte_Activitati_CD
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Orar') DROP TABLE Orar
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Formatii') DROP TABLE Formatii
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Cadre_Didactice') DROP TABLE Cadre_Didactice
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Discipline') DROP TABLE Discipline
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Sectii') DROP TABLE Sectii
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Sali') DROP TABLE Sali
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Echipamente') DROP TABLE Echipamente
	IF EXISTS (SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'logins') DROP TABLE logins
GO

--**********************************************************************************************************
--******************************************* Creare tabele ************************************************
--**********************************************************************************************************
IF EXISTS (SELECT * FROM sys.objects WHERE TYPE = 'P' AND name = 'creareTabele')
DROP PROCEDURE creareTabele 
GO
CREATE PROCEDURE creareTabele AS
	SET NoCount ON
	--**************************************** Loginuri ************************************************
	CREATE TABLE logins(
		userid varchar(30) PRIMARY KEY,
		pass varchar(30) not null,
		permissiune varchar(1) not null
	)

	INSERT INTO logins values ('Admin','adminpwd','A')
	INSERT INTO logins values ('Director','directorpwd','D')
	INSERT INTO logins values ('CadruDidactic','cadrudidacticpwd','C')

	--****************************************  Cadre_Didactice ************************************************
	CREATE TABLE Cadre_Didactice(
		Id_Cadru_Didactic	INT IDENTITY(1,1) PRIMARY KEY,
		pozitia VARCHAR(5) NOT NULL,
		den_post VARCHAR (20),
		nume VARCHAR (30) NOT NULL,
		functia VARCHAR (30),
		tit_vac VARCHAR (3) NOT NULL,
		CONSTRAINT unic_cadre_didactice UNIQUE(pozitia, den_post, nume, functia, tit_vac),
		CONSTRAINT check_tit_vac CHECK(tit_vac in ('T','V'))
	)
	
	--************************************** Loginuri_Cadre_Didactice ******************************************
	CREATE TABLE Loginuri_Cadre_Didactice(
		userid varchar(30) PRIMARY KEY REFERENCES logins(userid),
		ID_Cadru_Didactic INT REFERENCES Cadre_Didactice(Id_Cadru_Didactic) UNIQUE
	)

	--*********************************************  Discipline ************************************************
	CREATE TABLE Discipline(
		Id_Disciplina INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR (50) UNIQUE NOT NULL
	)

	--************************************************ Sectii **************************************************
	
	CREATE TABLE Sectii(
		
		Id_Sectie INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR (30) UNIQUE NOT NULL,
		nr_semestre INT 
	) 

	--************************************************ Sali ****************************************************
	CREATE TABLE Sali(
		Id_Sala INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR (30) NOT NULL, 
		capacitate SMALLINT ,
		CONSTRAINT unic_sali UNIQUE (denumire, capacitate)
	) 

	--********************************************** Echipamente ***********************************************
	CREATE TABLE Echipamente(
		Id_Echipament INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR (30) UNIQUE NOT NULL
	) 

	--********************************************** Formatii **************************************************
	CREATE TABLE Formatii(
		Id_Formatie INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR (30) UNIQUE NOT NULL,
		Id_Sectie INT REFERENCES Sectii(Id_Sectie) NOT NULL,
		an SMALLINT NOT NULL,
		grupa SMALLINT NOT NULL
	)
	
	--***************************************** State_De_Functii ***********************************************
	CREATE TABLE State_De_Functii(
		Id_Cadru_Didactic INT REFERENCES Cadre_Didactice(Id_Cadru_Didactic), 
		Id_Disciplina INT REFERENCES Discipline(Id_Disciplina), 
		Id_Sectia INT REFERENCES Sectii(Id_Sectie),
		an SMALLINT, 
		oreC1 SMALLINT, 
		oreS1 SMALLINT, 
		oreL1 SMALLINT, 
		oreC2 SMALLINT, 
		oreS2 SMALLINT, 
		oreL2 SMALLINT,
		CONSTRAINT unic_state_functii UNIQUE(Id_Cadru_Didactic, Id_Disciplina, Id_Sectia, an)
	)

	--************************************ Alte_Activitati_CD **************************************************
	CREATE TABLE Alte_Activitati_CD(
		Id_Cadru_Didactic  INT PRIMARY KEY REFERENCES Cadre_Didactice(Id_Cadru_Didactic), 
		Preg_Admitere INT NOT NULL, 
		Comisii_absolvire INT NOT NULL, 
		Consultatii INT NOT NULL,
		Examene INT NOT NULL, 
		Indr_lucr_disert INT NOT NULL, 
		Indr_lucr_lic INT NOT NULL, 
		Indr_proiect INT NOT NULL, 
		Lucr_control INT NOT NULL, 
		Seminarii_cerc  INT NOT NULL
	)

	--****************************************** Orar **************************************************
	CREATE TABLE Orar(
		ziua SMALLINT, 
		ora_inceput SMALLINT, 
		ora_sfarsit SMALLINT, 
		frecventa SMALLINT, 
		Id_Disciplina INT REFERENCES Discipline(Id_Disciplina),
		tip VARCHAR(1),
		Id_Cadru_Didactic INT REFERENCES Cadre_Didactice(Id_Cadru_Didactic), 
		Id_Sala INT REFERENCES Sali(Id_Sala), 
		Id_Formatie INT REFERENCES Formatii(Id_Formatie),
		CONSTRAINT check_orar_unique UNIQUE (ziua,ora_inceput,frecventa,Id_Cadru_Didactic,Id_Sala,Id_Formatie),
 		CONSTRAINT check_ora_inceput_orar CHECK (ora_inceput >= 8  and ora_inceput <= 18),
		CONSTRAINT check_ora_sfarsit_orar CHECK (ora_sfarsit >= 10  and ora_sfarsit <= 20),
		CONSTRAINT check_frecventa_orar CHECK (frecventa in (0,1,2)),
		CONSTRAINT check_ziua_orar CHECK (ziua >= 1 and ziua <=7),
		CONSTRAINT check_tipOra_orar CHECK (tip in ('L','S','C'))
	)
	SET NoCount OFF
GO
--**********************************************************************************************************
--******************************************* adaugaFormatie ***********************************************
--**********************************************************************************************************
IF EXISTS (SELECT * FROM sys.objects WHERE TYPE = 'P' AND name = 'adaugaFormatie') DROP PROCEDURE adaugaFormatie
GO
CREATE PROCEDURE adaugaFormatie 
@Id_Sectie INT,
@an SMALLINT,
@grupa SMALLINT,
@subgrupa SMALLINT AS
	SET NoCount ON
	INSERT INTO Formatii 
		Select
			CASE WHEN @grupa=0 THEN SUBSTRING((SELECT denumire from Sectii where Id_Sectie=@Id_Sectie),1,1)+CAST(@an AS VARCHAR(10)) WHEN @subgrupa=0 THEN CAST(@grupa as VARCHAR(30)) ELSE CAST(@grupa as VARCHAR(30))+'/'+CAST(@subgrupa as VARCHAR(30)) END,
			@Id_Sectie,
			@an,
			@grupa
	SET NoCount OFF
GO

--**********************************************************************************************************
--******************************************* modificaFormatie *********************************************
--**********************************************************************************************************
IF EXISTS (SELECT * FROM sys.objects WHERE TYPE = 'P' AND name = 'modificaFormatie') DROP PROCEDURE modificaFormatie
GO
CREATE PROCEDURE modificaFormatie 
	@Id_Formatie INT,
	@Id_Sectie INT,
	@an SMALLINT,
	@grupa SMALLINT,
	@subgrupa SMALLINT AS
		SET NoCount ON
		UPDATE Formatii 
			SET 
				Id_Sectie = @Id_Sectie,
				denumire = CASE WHEN @subgrupa=0 THEN CAST(@grupa as VARCHAR(30)) ELSE CAST(@grupa as VARCHAR(30))+'/'+CAST(@subgrupa as VARCHAR(30)) END,
				an = @an,
				grupa = @grupa
		WHERE Id_Formatie=@Id_Formatie
		SET NoCount OFF
	GO

EXEC stergeTabele
EXEC creareTabele

--***************************************** Projects ***********************************************
	-- tip 1 - eveniment administrativ
	-- tip 2 - proiect stiintific
	-- stare 0 - neaprobat
	-- stare 1 - aprobat
	-- stare -1 - respins

	DROP TABLE Projects
	CREATE TABLE Projects (
		id INT IDENTITY(1,1) PRIMARY KEY,
		tip INT,
		denumire VARCHAR(1024),
		descriere VARCHAR(8000),
		timp_inceput DATE,
		timp_sfirsit DATE,
		stare int
		CONSTRAINT check_stare check(stare in (0,1,-1))
	)
	
	DROP TABLE Phases
	-- tip 1 - activitate administrativa
	-- tip 2 - faza

	
	CREATE TABLE Phases (
		id INT IDENTITY(1,1) PRIMARY KEY,
		project_id INT,
		tip INT,
		denumire VARCHAR(1024),
		descriere VARCHAR(8000),
		timp_inceput DATE,
		timp_sfirsit DATE	
	)
	
	DROP TABLE Tasks
	-- tip 1 - sarcina
	-- tip 2 - activitate
	-- confidential - {0,1}
	CREATE TABLE Tasks (
		id INT IDENTITY(1,1) PRIMARY KEY,
		phase_id INT,
		tip INT,
		denumire VARCHAR(1024),
		descriere VARCHAR(8000),
		timp_inceput DATE,
		timp_sfirsit DATE,
		confidential smallint
		CONSTRAINT check_confidential check(confidential in (0,1)) 
	)
	

	DROP TABLE TaskLogisticEquipment
	CREATE TABLE TaskLogisticEquipment (
		task_id INT,
		equipment_id INT
	)
	

	DROP TABLE TaskLogisticRoom
	CREATE TABLE TaskLogisticRoom (
		task_id INT,
		room_id INT
	)
	
	-- budget_type 1 - CheltuieliCuMobilitate
	-- budget_type 2 - CheltuieliCuManopera
	-- budget_type 3 - CheltuieliDeLogistica
	
	DROP TABLE  TaskBudget
	CREATE TABLE TaskBudget (
		id INT IDENTITY(1,1) PRIMARY KEY,
		task_id INT,
		budget_type INT,
		suma INT,
		descriere VARCHAR(5000)
	)
	
	DROP TABLE TaskTeam
	CREATE TABLE TaskTeam (
		task_id INT,
		cadru_didactic_id INT
	)
	

	DROP TABLE SemestruDiscipline
	CREATE TABLE SemestruDiscipline (
		id INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR(100),
		nr_credite INT,
		semestru_id INT
	)
	
	DROP TABLE Semestre
	CREATE TABLE Semestre (
		id INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR(100),
		program_id INT
	)
	
	DROP TABLE ProgramDeStudii
	CREATE TABLE ProgramDeStudii (
		id INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR(100)
	)
	
	DROP TABLE CercuriStudentesti
	CREATE TABLE CercuriStudentesti (
		id INT IDENTITY(1,1) PRIMARY KEY,
		denumire VARCHAR(100),
		mentor VARCHAR(100),
		an INT,
		descriere VARCHAR(250),
		program_id INT
	)

	--Plan invatamint--
	DROP TABLE ProgrameDeStudiu
	CREATE TABLE ProgrameDeStudiu (
		program_id INT PRIMARY KEY IDENTITY(1,1),
		sectie_id INT,
		denumire_program VARCHAR(50),
		semestru INT
	)

	--Discipline in plan--
	DROP TABLE PlanuriInvatamint
	CREATE TABLE PlanuriInvatamint (
		program_id INT,
		disciplina VARCHAR(50),
		ore_curs INT,
		ore_sem INT,
		ore_lab INT,
		ore_pr INT,
		finalizare VARCHAR(1),
		nr_credite INT		
	)

	insert into Cadre_Didactice values ('21','Lect','Cioban Vasile','Lect. dr.','T')

insert into Sectii values ('Informatica - LR',6)
insert into Sectii values ('Ingineria informatiei - LR', 6) 
insert into Sectii values ('Matematica informatica - LR', 6)

insert into Sali values ('L302',30)
insert into Sali values ('L306',30)
insert into Sali values ('L307',30)
insert into Sali values ('L336',30)
insert into Sali values ('L338',30)
insert into Sali values ('L339',30)
insert into Sali values ('5/I',100)
insert into Sali values ('7/I',100)
insert into Sali values ('9/I',100)
insert into Sali values ('A323',25)
insert into Sali values ('L308',30)

EXEC adaugaFormatie 1,3,234,1
EXEC adaugaFormatie 1,3,232,2
EXEC adaugaFormatie 1,3,235,2
EXEC adaugaFormatie 1,2,225,2
EXEC adaugaFormatie 1,2,222,1
EXEC adaugaFormatie 1,2,225,1
EXEC adaugaFormatie 2,2,821,1
EXEC adaugaFormatie 2,3,831,1
EXEC adaugaFormatie 2,3,831,2
EXEC adaugaFormatie 2,3,831,0
EXEC adaugaFormatie 1,3,0,0
EXEC adaugaFormatie 3,1,314,0
EXEC adaugaFormatie 3,1,313,0
EXEC adaugaFormatie 1,2,226,1
EXEC adaugaFormatie 1,3,233,1
EXEC adaugaFormatie 1,3,235,1
EXEC adaugaFormatie 3,1,312,0

insert into Discipline values ('Medii de proiectare si programare')
insert into Discipline values ('Proiect colectiv')
insert into Discipline values ('Structuri de date si algoritmi')


/*
select * from Cadre_Didactice
select * from sectii
select * from sali
select * from formatii

SELECT ziua, ora_inceput, ora_sfarsit, frecventa, s.denumire as Sala ,  c.nume as Cadru_Didactic , sec.denumire as Sectie, f.an as An,f.denumire as Formatia, tip as Tipul, d.denumire as disciplina FROM orar o inner join sali s on o.Id_Sala=s.Id_Sala inner join  Discipline d on o.Id_Disciplina= d.Id_Disciplina inner join Cadre_Didactice c on o.Id_Cadru_Didactic= c.Id_Cadru_Didactic inner join formatii f on o.Id_Formatie = f.Id_Formatie inner join Sectii sec on sec.Id_Sectie = f.Id_Sectie

select * from State_De_Functii
select * from Alte_Activitati_CD
*/