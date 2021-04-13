package SpaceUSER.Cadastro.Ouvintes;


import SpaceUSER.Cadastro.Tela.TelaCadastroCliente;
import SpaceUSER.Login.Tela.TelaLoginCliente;
import Utilitarios.Persistencia.Central_de_informacoes.CentralDeInformacoes;
import Utilitarios.Persistencia.PersistenciaSingleton.Persistencia;
import Utilitarios.Persistencia.Usuario.Usuario;
import Utilitarios.criptografia.CriptografiaDeSenha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OuvinteDosButtons implements ActionListener {
    private static final Persistencia persistencia = Persistencia.getUnicaInstancia();
    private static final CentralDeInformacoes central = persistencia.recuperar();
    private final TelaCadastroCliente telaCadastroCliente;


    public OuvinteDosButtons(TelaCadastroCliente telaCadastroCliente){
        this.telaCadastroCliente=telaCadastroCliente;
    }

    private void fechaJanela(){
        telaCadastroCliente.dispose();
        new TelaLoginCliente("Livraria Digital - Login Cliente");
    }

    public void cadastroDeClientes() throws Exception {
        String[] info= this.permitirCadastroSe();
        info[2]= CriptografiaDeSenha.criptografia(info[2]);
        info[6]= (String) telaCadastroCliente.getGenero1().getSelectedItem();
        info[7]= (String) telaCadastroCliente.getGenero2().getSelectedItem();
        info[8]= (String) telaCadastroCliente.getGenero3().getSelectedItem();

        Usuario user = new Usuario(info[0], info[1], info[2],info[3],info[4], info[6], info[7], info[8]);
        central.addUser(user);
        this.dataIsValida();
        central.salvar();
        JOptionPane.showMessageDialog(telaCadastroCliente,"Cadastro realizado com sucesso!");
        this.fechaJanela();
    }

    public String[] permitirCadastroSe() throws Exception {
        String[] info = this.verificaSeHaCamposEmBranco();

        ArrayList<Usuario> usuarios=central.getUsuario();
        if(info[1].contains("@")) {
            for (Usuario user : usuarios) {
                if (user.getEmail().equals(info[1])) {
                    throw new Exception("Esse email ja está cadastrado");
                }
            }
            return info;

        }else if(info[5].equals("1")){
            throw new Exception("Não deixe campos em branco");
        }
        throw new Exception("Insira um email válido");



    }


    public void dataIsValida() throws Exception {
        String data =telaCadastroCliente.getData();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        try{
            Date hoje = new Date();
            Date dataObject = formato.parse(data);
            if(dataObject.after(hoje)){
                throw new Exception("Informe uma data válida");
            }

        }catch(Exception e){
            throw new Exception("Informe uma data válida");
        }

    }


    public String[] verificaSeHaCamposEmBranco(){
        String[] info = {telaCadastroCliente.getNome(),
                telaCadastroCliente.getEmail(),
                telaCadastroCliente.getSenha(),
                "",telaCadastroCliente.getData(),"", "", "", ""};

        JRadioButton masculino = telaCadastroCliente.getRB_MASCULINO();
        JRadioButton feminino = telaCadastroCliente.getRB_FEMININO();

        if(masculino.isSelected()){
            info[3]="Masculino";
        }else if(feminino.isSelected()){
            info[3]="Feminino";
        }
        info[5]= info[0].equals("") || info[1].equals("") ||
                info[2].equals("") ||info[3].equals("")  ||
                info[4].equals("")?"1":"0";
        return info;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao =(JButton) e.getSource();
        try {
            if(botao.getText().equals("Enviar")){
                this.cadastroDeClientes();

            }else{
                this.fechaJanela();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(telaCadastroCliente,ex.getMessage());
        }
    }
}
