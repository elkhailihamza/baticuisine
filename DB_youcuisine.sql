CREATE TABLE IF NOT EXISTS clients(
	client_id SERIAL PRIMARY KEY,
	nom VARCHAR(255) NOT NULL,
	adresse VARCHAR(255) NOT NULL,
	telephone VARCHAR(30) NOT NULL,
	estProfessionnel BOOLEAN NOT NULL
);

CREATE TYPE ETAT AS ENUM ('En cours', 'Terminé', 'Annulé');

CREATE TABLE IF NOT EXISTS projets(
	projet_id SERIAL PRIMARY KEY,
	nomProjet VARCHAR(255) NOT NULL,
	margeBeneficiaire NUMERIC(10, 2) NOT NULL,
	coutTotal NUMERIC(10, 2) NOT NULL,
	etatProjet ETAT NOT NULL,

	clientId INT,
	CONSTRAINT fk_client FOREIGN KEY (clientId) REFERENCES clients(client_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS quotes(
	quote_id SERIAL PRIMARY KEY,
	montantEstime NUMERIC(10, 2) NOT NULL,
	dateEmission DATE NOT NULL,
	dateValidate DATE,
	accepte BOOLEAN NOT NULL,

	projetId INT,
	CONSTRAINT fk_projet FOREIGN KEY (projetId) REFERENCES projets(projet_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS components(
	component_id SERIAL PRIMARY KEY,
	nom VARCHAR(255) NOT NULL,
	typeComponent VARCHAR(255) NOT NULL,
	tauxTVA NUMERIC(10, 2) NOT NULL,
	
	projetId INT,
	CONSTRAINT fk_projet FOREIGN KEY (projetId) REFERENCES projets(projet_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS labor (
	hourlyRate NUMERIC(10, 2) NOT NULL,
	hoursWorked NUMERIC(10, 2) NOT NULL,
	workerProductivity NUMERIC(10, 2) NOT NULL
	
) INHERITS (components);

CREATE TABLE IF NOT EXISTS materials(
	coutUnitaire Numeric(10, 2) NOT NULL,
	quantite NUMERIC(10, 2) NOT NULL,
	coutTransport NUMERIC(10, 2) NOT NULL,
	coefficientQualite NUMERIC(10, 2) NOT NULL
) INHERITS (components);