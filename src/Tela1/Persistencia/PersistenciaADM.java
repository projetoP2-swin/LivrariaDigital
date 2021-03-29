package Tela1.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PersistenciaADM {
private XStream xStream = new XStream(new DomDriver("UTF-8"));
	
	public void salvarCentral(Object livreiro) throws Exception {
		File arquivo = new File("livreiro-db.xml");
		String xml=null;
		if(!arquivo.exists()) {
			arquivo.createNewFile();
			xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
		}
		PrintWriter pw = new PrintWriter(arquivo);
		xStream.alias("Livreiro", livreiro.getClass());
		xml += xStream.toXML(livreiro);
		pw.write(xml);
		pw.close();
	}


	public Livreiro recuperarLivreiro() throws Exception {
		File arquivo = new File("livreiro-db.xml");
		xStream.alias("Livreiro", Livreiro.class);
		if(arquivo.exists()) {
			FileReader fr = new FileReader(arquivo);
			return (Livreiro) xStream.fromXML(fr);

		}
		return null;

	}
}
