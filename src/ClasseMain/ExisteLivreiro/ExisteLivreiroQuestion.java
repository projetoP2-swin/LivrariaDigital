package ClasseMain.ExisteLivreiro;

import SpaceADM.Cadastro.Tela.TelaAddLivreiro;
import SpaceUSER.Login.Tela.TelaLoginCliente;
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
            return new TelaLoginCliente("Livraria Digital - Login Clientes");
        }else{
            return new TelaAddLivreiro("Livraria Digital - Adicionar Livreiro");
        }
    }


}
