package SpaceADM.CadastroDeLivros.Factory.TipoDeLivros;

import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.DesenvolvimentoPessoal;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Literatura;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Periodicos;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Tipos.Tecnicos;

import java.util.ArrayList;

public class ChamaTiposDeLivros {

    public static Livro factory(ArrayList<String> info){
        String tipo = info.get(0);
        switch (tipo) {
            case "Literatura":
                return new Literatura(info, info.get(5));
            case "Desenvolvimento Pessoal":
                return new DesenvolvimentoPessoal(info, info.get(5));
            case "Periódicos":
                return new Periodicos(info, info.get(7), info.get(5), info.get(6));
            case "Técnico":
                return new Tecnicos(info, info.get(5), info.get(6));
            default:
                return null;
        }

    }
}
