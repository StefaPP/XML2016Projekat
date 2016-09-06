package sparql;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.eval.EvalResult;
import com.marklogic.client.eval.EvalResultIterator;
import com.marklogic.client.eval.ServerEvaluationCall;

import xmldb.DBConnection;
import xmldb.DBConnection.ConnectionProperties;

public class MyXQuery {
	
	private static DatabaseClient client;
	
	public static void Query(ConnectionProperties props, String Doc) throws IOException{
		
		client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user,props.pass, props.authType);
		
		// Script file which is to be invoked
				String filePath = Doc;

				
				System.out.println("[INFO] Invoking: " + filePath);

				// Initialize XQuery invoker object
				ServerEvaluationCall invoker = client.newServerEval();

				// Read the file contents into a string object
				String query = readFile(filePath, StandardCharsets.UTF_8);

				// Invoke the query
				invoker.xquery(query);

				// Interpret the results
				EvalResultIterator response = invoker.eval();

				System.out.print("[INFO] Response: ");
		
		
				if (response.hasNext()) {

					for (EvalResult result : response) {
						System.out.println("\n" + result.getString());
					}
				} else { 		
					System.out.println("your query returned an empty sequence.");
				}

				client.release();
	}
	
	public static synchronized String invoke(ConnectionProperties props, String query){
		DatabaseClient client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user,
				props.pass, props.authType);
		ServerEvaluationCall invoker = client.newServerEval();
		invoker.xquery(query);
		EvalResultIterator response = invoker.eval();
		String retVal = "";
		if (response.hasNext()) {
			for (EvalResult result : response) {
				retVal += result.getString() + "\n";
			}
		} else { 		
			System.out.println("your query returned an empty sequence.");
		}
		client.release();
		return retVal;
	}

	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
