package SpaceADM.CadastroDeLivros.Factory;


import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Ouvintes.OuvinteDosJButtons;
import SpaceADM.CadastroDeLivros.Tela.Componentes.DesenvolvimentoPessoal;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Literatura;
import SpaceADM.CadastroDeLivros.Tela.Componentes.Periodicos;

import java.awt.event.ActionListener;


public class ChamaComponentesAddNaTela {

    public static ComponentesAddNaTela fabricaDeComponentes(int chave){
        switch (chave){
            case 1:
                return new Literatura();
            case 2:
                return new Periodicos();

            case 3:
                return new DesenvolvimentoPessoal();
            case 4:
                System.out.println("3");
                return null;
            default:
                return null;
        }

    }

}
