package ClasseMain.ExisteLivreiro;

import Tela1.Tela.TelaAddLivreiro;
import Tela2.ADM.Tela.TelaADM;
import TelaPadrao.TelaPadrao;

import java.io.File;

public class ExisteLivreiroQuestion {

    public static boolean existLivreiro() throws Exception{
        File arquivo = new File("livreiro-db.xml");
        return arquivo.exists();
    }

    public TelaPadrao primeiraTelaFactory() throws Exception{
        boolean condicao = ExisteLivreiroQuestion.existLivreiro();
        if(condicao){
            return new TelaADM("Livraria Digital - User");
        }else{
            return new TelaAddLivreiro("Livraria Digital - Adicionar Livreiro");
        }
    }


}
