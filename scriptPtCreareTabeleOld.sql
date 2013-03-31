CREATE TABLE logins(
	userid varchar(30) PRIMARY KEY,
	pass varchar(30) not null,
	permissiune varchar(1) not null
)

INSERT INTO logins values ('Admin','adminpwd','A')
INSERT INTO logins values ('Director','directorpwd','D')
INSERT INTO logins values ('CadruDidactic','cadrudidacticpwd','C')



CREATE LOGIN prColectiv 
    WITH PASSWORD    = N'prColectiv'
USE ProiectColectiv
CREATE USER prColectiv FOR LOGIN prColectiv
EXEC sp_addrolemember N'db_owner', N'prColectiv'