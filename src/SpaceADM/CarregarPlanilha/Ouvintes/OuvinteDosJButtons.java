package SpaceADM.CarregarPlanilha.Ouvintes;

import SpaceADM.CarregarPlanilha.Factory.EscolheTipo;
import SpaceADM.CarregarPlanilha.Tela.TelaCarregarPlanilha;
import SpaceADM.Home.Tela.TelaHomeADM;
import Utilitarios.Persistencia.Central_de_informacoes.Central.CentralDeInformacoes;
import Utilitarios.Persistencia.Central_de_informacoes.Livro.Superclasse.Livro;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import jxl.Sheet;
import jxl.Workbook;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class OuvinteDosJButtons implements ActionListener {
    private File file;
    private Workbook workbook;
    private TelaCarregarPlanilha tela;
    private String caminhoFile;

    public OuvinteDosJButtons(TelaCarregarPlanilha tela){
        this.tela=tela;
    }

    public void addFileSchooser() throws Exception {
        JFileChooser fc = new JFileChooser();

        fc.setPreferredSize(new Dimension(700,400));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fc.showOpenDialog(fc);
        if(result != JFileChooser.CANCEL_OPTION){
            this.file = fc.getSelectedFile();
            caminhoFile = file.toString().trim();

            this.workbook = Workbook.getWorkbook(new File(caminhoFile));
            Sheet sheet = workbook.getSheet(0);
            int numeroDeLinhas = sheet.getRows();

            for(int i =1;i<numeroDeLinhas;i++){
                Object[] linha = new Object[13];
                for(int j=0;j<13;j++){
                    linha[j]=sheet.getCell(j, i).getContents();
                }
                this.tela.getModel1().addRow(linha);
            }
        }
    }

    public void testeNumeros(ArrayList<String> info) throws Exception {
        try{
            Integer.parseInt(info.get(2));
            Integer.parseInt(info.get(6));
            Float.parseFloat(info.get(7));
            if(info.get(0).toLowerCase().equals("periódicos")){
                Long.parseLong(info.get(11));
            }
        }catch(Exception e){
            throw new Exception("Digite um número no campo de número");
        }
    }
    public void testeGeneros(ArrayList<String> info, int numeroDaLinha) throws Exception {
        String tipo = info.get(0).toLowerCase();
        String generoString =
                "literatura,periódicos,desenvolvimento pessoal,técnico";

        ArrayList<String> generos = new ArrayList<>(
                Arrays.asList(generoString.split(",")));
        String[][] matrizGenero ={
                {"literatura brasileira"+
                "literatura estrangeira"+
                "infanto juvenil"+
                "artes"+
                "biografia"+
                "poesia"},
                {"gibi revista de notícias"},
                {"autoajuda religião saúde"},
                {"paradidático formação profissional"}

        };
        int index = generos.indexOf(tipo);
        if(index !=-1){
            if(!matrizGenero[index][0].contains(info.get(8).toLowerCase())||
                info.get(8).equals(" ")||info.get(8).equals("")){
                throw new Exception("Problema com os Generos");
            }
        }else{
            throw new Exception("Livro na linha: "+numeroDaLinha+1+" não reconhecido");
        }
    }

    public void uparParaOBanco() throws Exception {

        DefaultTableModel tabelaInformacoes = this.tela.getModel1();

        if(tabelaInformacoes.getRowCount() != 0){

            CentralDeInformacoes central= Persistencia.getUnicaInstancia().recuperar();
            ArrayList<Livro> arrayLivros = new ArrayList<Livro>();

            for(int i=0;i< tabelaInformacoes.getRowCount();i++){
                ArrayList<String> info = new ArrayList<String>();

                if(!this.tela.getModel1().getValueAt(i,0).equals("")){
                    for(int j =0;j <13;j++){
                        info.add((String) tabelaInformacoes.getValueAt(i,j));
                    }
                    this.testeNumeros(info);
                    this.testeGeneros(info,i);
                    Livro livro = EscolheTipo.factory(info);
                    if(livro!=null){
                        arrayLivros.add(livro);
                    }
                }
            }
            central.addArrayDeLivros(arrayLivros);
            central.salvar();

        }else{
            throw new Exception("Abra uma planilha .XLS");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String textBTN = button.getText();
        try{
            if(textBTN.equals("Pegar .XLS")){
                this.addFileSchooser();
            }else if(textBTN.equals("Carregar")) {

                this.uparParaOBanco();
                JOptionPane.showMessageDialog(tela,"Cadastro Realizado");
                this.tela.dispose();
                new TelaHomeADM();

            }else if(textBTN.equals("Adicionar Linha")){
                this.addLinha();
            }else if(textBTN.equals("Remover Linha")){
                this.removeLinha();
            }else{
                this.limpaPlanilha();
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(tela,ex.getMessage());
        }

    }
    public DefaultTableModel getModelParaOperacoes(){
        return this.tela.getModel1();
    }

    public void limpaPlanilha(){
        int index = this.tela.getModel1().getRowCount();
        if(index !=0){
            for(int a = index; a> 0; a--){
                this.tela.getModel1().removeRow(a-1);
            }
        }else{
            JOptionPane.showMessageDialog(tela, "Sem linhas para remover");
        }
    }

    public void removeLinha(){
        int index = this.getModelParaOperacoes().getRowCount();
        if(index !=0){
            this.getModelParaOperacoes().removeRow(index-1);
        }else{
            JOptionPane.showMessageDialog(tela, "Sem linhas para remover");
        }
    }

    public void addLinha(){
        this.getModelParaOperacoes().addRow(new Object[]{});
    }
}
