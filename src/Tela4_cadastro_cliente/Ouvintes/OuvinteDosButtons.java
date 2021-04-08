package Tela4_cadastro_cliente.Ouvintes;

import Criptografia.CriptografiaDeSenha;
import Persistencia.Central_de_informacoes.CentralDeInformacoes;
import Persistencia.PersistenciaAll.Persistencia;
import Persistencia.Usuario.Usuario;
import Tela3_login_Cliente.Tela.TelaLoginCliente;
import Tela4_cadastro_cliente.Tela.TelaCadastroCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class OuvinteDosButtons implements ActionListener {
    private static final Persistencia persistencia = new Persistencia();
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
        info[2]=CriptografiaDeSenha.criptografia(info[2]);

        Usuario user = new Usuario(info[0], info[1], info[2],info[3],info[4]);
        central.addUser(user);
        this.dataIsValida();
        central.salvar();
        JOptionPane.showMessageDialog(telaCadastroCliente,"Cadastro realizado com sucesso!");
        this.fechaJanela();
    }

    public String[] permitirCadastroSe() throws Exception {
        String[] info = this.verificaSeHaCamposEmBranco();

        ArrayList<Usuario>usuarios=central.getUsuario();
        if(info[1].contains("@")) {
            for (Usuario user : usuarios) {
                if (user.getEmail().equals(info[2])) {
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
            Date dataObject = formato.parse(data);

        }catch(Exception e){
            throw new Exception("Informe uma data válida");
        }

    }


    public String[] verificaSeHaCamposEmBranco(){
        String[] info = {telaCadastroCliente.getNome(),
                telaCadastroCliente.getEmail(),
                telaCadastroCliente.getSenha(),
                "",telaCadastroCliente.getData(),""};

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
