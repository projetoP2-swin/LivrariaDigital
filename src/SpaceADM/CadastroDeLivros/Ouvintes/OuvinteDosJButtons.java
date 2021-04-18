package SpaceADM.CadastroDeLivros.Ouvintes;

import Interfaces.Package_SpaceADM.ComponentesAddNaTela;
import SpaceADM.CadastroDeLivros.Tela.Tela.TelaAddLivro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuvinteDosJButtons implements ActionListener {

    private TelaAddLivro tela;
    private ComponentesAddNaTela comp;

    public OuvinteDosJButtons(TelaAddLivro tela, ComponentesAddNaTela comp){
        this.tela =tela;
        this.comp =comp;
    }
    public ArrayList<String> getInfomacoes(){
        ArrayList<String> todasAsInformoces = new ArrayList<String>();
        todasAsInformoces.add(tela.getTitulo());
        todasAsInformoces.add(tela.getImagem());
        todasAsInformoces.add(tela.getResumo());
        todasAsInformoces.add(tela.getIdioma());
        todasAsInformoces.add(tela.getEditora());
        todasAsInformoces.add(tela.getQuantidade());
        todasAsInformoces.add(tela.getPreco());
        todasAsInformoces.addAll(comp.getInfo());
        todasAsInformoces.add(comp.getTipo());
        return todasAsInformoces;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(!this.getInfomacoes().contains("")){
            System.out.println(this.getInfomacoes());

        }else{
            System.out.println("Não deixe campos em branco");
        }
    }
}
