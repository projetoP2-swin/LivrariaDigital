package Tela1.Persistencia;

import java.io.File;
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
		pw.flush();
		pw.close();
	}
	
	// TODO recuperação de dados
	/*public CentralDeInformacoes recuperarCentral(String NomeArquivo) throws Exception {
		File arquivo = new File(NomeArquivo);
		
		if(arquivo.exists()) {
			FileInputStream fis = new FileInputStream(arquivo);
			return (CentralDeInformacoes) xStream.fromXML(fis);
		
		} else {
			CentralDeInformacoes central = new CentralDeInformacoes();
			return central;
		}
		
	}*/
}
