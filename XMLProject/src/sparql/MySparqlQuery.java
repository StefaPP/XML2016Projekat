package sparql;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.io.JacksonHandle;
import com.marklogic.client.semantics.SPARQLMimeTypes;
import com.marklogic.client.semantics.SPARQLQueryDefinition;
import com.marklogic.client.semantics.SPARQLQueryManager;

import xmldb.DBConnection;
import xmldb.DBConnection.ConnectionProperties;

public class MySparqlQuery {

	public static final String AKT_DONET = "/propisi/akti/doneti";
	public static final String AKT_U_PROCEDURI = "/propisi/akti/u_proceduri";
	private static final String PROPERTY = "http://www.parlament.gov.rs/propisi/predicate/";

	private String type;
	private String oznaka;
	private String naziv;
	private String mesto;
	private String datumMin;
	private String datumMax;
	private String vrsta;

	public String execute(ConnectionProperties props, String metadataCollection, boolean useFilter) {

		String query = makeQuery(metadataCollection, useFilter);
		DatabaseClient client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user,
				props.pass, props.authType);
		SPARQLQueryManager sparqlQueryManager = client.newSPARQLQueryManager();
		JacksonHandle resultsHandle = new JacksonHandle();
		resultsHandle.setMimetype(SPARQLMimeTypes.SPARQL_JSON);
		SPARQLQueryDefinition queryDef = sparqlQueryManager.newQueryDefinition(query);
		resultsHandle = sparqlQueryManager.executeSelect(queryDef, resultsHandle);
		client.release();
		return resultsHandle.get().toString();
	}

	private String makeQuery(String metadataCollection, boolean useFilter) {
		StringBuilder query = new StringBuilder();

		query.append("PREFIX xs:     <http://www.w3.org/2001/XMLSchema#>\n");
		query.append("SELECT * FROM <" + metadataCollection + ">\n");
		query.append("WHERE{\n");
		query.append(selectTemplate("oznaka"));
		query.append(selectTemplate("naziv"));
		query.append(selectTemplate("datum"));
		query.append(selectTemplate("vrsta"));
		
		query.append("\n}");
		System.out.println(query.toString());
		return query.toString();
	}

	private String selectTemplate(String what) {
		return "?akt <" + PROPERTY + what + ">?" + what + " .\n";
	}
	
	/**
	 * Reading file contents into a string.
	 */
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	public static String execute(ConnectionProperties props, String path) {
		String query = null;
		try {
			query = readFile(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DatabaseClient client = DatabaseClientFactory.newClient(props.host,
				props.port, props.database, props.user, props.pass,
				props.authType);
		
		// Create a SPARQL query manager to query RDF datasets
		SPARQLQueryManager sparqlQueryManager = client.newSPARQLQueryManager();
		
		JacksonHandle resultsHandle = new JacksonHandle();
		resultsHandle.setMimetype(SPARQLMimeTypes.SPARQL_JSON);
		
		SPARQLQueryDefinition queryDef = sparqlQueryManager.newQueryDefinition(query);
		
		resultsHandle = sparqlQueryManager.executeSelect(queryDef, resultsHandle);

		client.release();
		return resultsHandle.get().toString();
	}
	
public static String executeFromString(ConnectionProperties props, String query) {
		
		DatabaseClient client = DatabaseClientFactory.newClient(props.host,
				props.port, props.database, props.user, props.pass,
				props.authType);
		
		// Create a SPARQL query manager to query RDF datasets
		SPARQLQueryManager sparqlQueryManager = client.newSPARQLQueryManager();
		
		JacksonHandle resultsHandle = new JacksonHandle();
		resultsHandle.setMimetype(SPARQLMimeTypes.SPARQL_JSON);
		
		SPARQLQueryDefinition queryDef = sparqlQueryManager.newQueryDefinition(query);
		
		resultsHandle = sparqlQueryManager.executeSelect(queryDef, resultsHandle);

		client.release();
		return resultsHandle.get().toString();
	}
	

	public MySparqlQuery(String type) {
		super();
		this.type = type;
		this.oznaka = "";
		this.naziv = "";
		this.mesto = "";
		this.datumMin = "1970-01-01";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		this.datumMax = dateFormat.format(date);
		this.vrsta = "";
	}

	public MySparqlQuery(String type, String oznaka, String naziv, String mesto, String datumMin, String datumMax,
			String vrsta) {
		super();
		this.type = type;
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.mesto = mesto;
		this.datumMin = datumMin.equals("") ? "1970-01-01" : datumMin;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		this.datumMax = datumMax.equals("") ? dateFormat.format(date) : datumMax;
		this.vrsta = vrsta;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getDatumMin() {
		return datumMin;
	}

	public void setDatumMin(String datumMin) {
		this.datumMin = datumMin.equals("") ? "1970-01-01" : datumMin;
	}

	public String getDatumMax() {
		return datumMax;
	}

	public void setDatumMax(String datumMax) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		this.datumMax = datumMax.equals("") ? dateFormat.format(date) : datumMax;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public String getType() {
		return type;
	}
}
