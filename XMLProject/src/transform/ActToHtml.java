package transform;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ActToHtml extends TransformersXMLToHTML {
	public static final String ACT_RESOURCE = "/home/student/git/XML2016Projekat/XMLProject/src/schema/akt_html.xsl";
	public static final String TEST_ACT = "/home/student/git/XML2016Projekat/XMLProject/src/xml/akti/Akt1-donet.xml";
	public static final String HTML_FILE_TEST = "/home/student/git/XML2016Projekat/XMLProject/html/Temp.html";
	
	public ActToHtml() {
		// TODO Auto-generated constructor stub
	}
	
	InputStream is;

	public void test() {
		try {
			is = new FileInputStream(new File(TEST_ACT));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		

		
		OutputStream os = new ByteArrayOutputStream();
			try {
				transform(is, os);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		
		
		
		File htmlFile = new File(HTML_FILE_TEST);

		try {
			FileOutputStream fos = new FileOutputStream(htmlFile);
			fos.write(((ByteArrayOutputStream) os).toByteArray());
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	public InputStream loadXSL() throws Exception {
		InputStream is = new FileInputStream(new File(ACT_RESOURCE));


		return is;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		new ActToHtml().test();
	}
}
