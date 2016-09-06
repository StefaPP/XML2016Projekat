
package rest;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import sun.awt.datatransfer.DataTransferer;
import uloge.User;

@Path("/user")
public class LoginService {
	
	private String path ="/home/student/git/XML2016Projekat3/XMLProject/src/users/users.txt";
	//private String path	=  "C:\\Users\\Bebica\\git\\XML2016Projekat\\XMLProject\\src\\users\\users.txt";
    // private String path = "C:\\Users\\Strefa\\git\\XML2016Projekat\\XMLProject\\src\\users\\users.txt";

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User log(String user){
		
		
		Genson genson = new GensonBuilder().useDateFormat(new SimpleDateFormat("yyyy-MM-dd")).create();
		User u = genson.deserialize(user, User.class);
		
		File f = new File(path);
		try {
			Scanner scanner = new Scanner(f);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] splitStr = line.split(";");
				String username = splitStr[0].trim();
				String password = splitStr[1].trim();
				String role = splitStr[2].trim();
				if (username.equals(u.getUsername())) {
					if (password.equals(u.getPassword())) {
						scanner.close();
						u.setRole(role);
						return u;
					} else {
						scanner.close();
						return null;
					}
				}
				
			}
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}


}