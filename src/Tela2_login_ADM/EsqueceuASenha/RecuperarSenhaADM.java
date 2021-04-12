package Tela2_login_ADM.EsqueceuASenha;
import Criptografia.CriptografiaDeSenha;
import EnvioDeEmail.EnviarEmail;
import Persistencia.Central_de_informacoes.CentralDeInformacoes;
import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaAll.Persistencia;
import Tela2_login_ADM.Tela.TelaADM;
import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RecuperarSenhaADM extends EnviarEmail {

    private static TelaADM telaAdm;
    private static final long CODIGO = System.currentTimeMillis();

    private String email;
    private String nome;
    private Livreiro livreiro = central.getLivreiro();


    public void gerenciarEnvioDeEmail(){
        if(livreiro.getNumeroDeRecuperacao()==null ||
                !livreiro.getNumeroDeRecuperacao().equals(this.getCodigo()) ){
            this.envioDeEmail();
        }
    }

    public void addNumeroDeRecuperacao(String codigo) throws Exception {
        livreiro.setNumeroDeRecuperacao(codigo);
        central.addLivreiro(livreiro);
        central.salvar();

    }

    public void codigoCorreto() throws Exception {
        String senha =this.showInputDialog_QUESTION("Digite sua nova senha: ");


        senha = CriptografiaDeSenha.criptografia(senha);
        livreiro.setSenha(senha);
        central.addLivreiro(livreiro);
        central.salvar();


        this.showMessageDialog_INFORMATION("Senha alterada com sucesso");
    }

    public void codigoIncorreto(){
        this.showMessageDialog_INFORMATION("Seu codigo está errado, tente novamente.");
    }

    public String pegaEmailEscondido(){

        this.email = livreiro.getEmail();
        this.nome =  livreiro.getNome();

        String resultado= email.substring(2,email.indexOf("@"));

        resultado = email.substring(0,2)+
                "*".repeat(resultado.length())+
                email.substring(email.indexOf("@"));


        return resultado;
    }

    public RecuperarSenhaADM(TelaADM telaAdm, JLabel label) throws Exception {
        RecuperarSenhaADM.telaAdm = telaAdm;
        String emailMETHOD = this.pegaEmailEscondido();

        this.gerenciarEnvioDeEmail();
        this.addNumeroDeRecuperacao(Long.toString(CODIGO));

        //Saindo da tela de Load do jLabel
        label.setText("Esqueceu sua senha?");
        label.setForeground(Color.WHITE);
        label.setIcon(null);

        String resultado = this.showInputDialog_QUESTION(
                "<html>Enviamos um código de recuperação para: <br>"+
                emailMETHOD+
                "<br><br>Digite o código: <html>");

        String codigoAsString = Long.toString(CODIGO);
        if(resultado.equals(codigoAsString)){
            this.codigoCorreto();
        }else{
            this.codigoIncorreto();
        }

    }

    @Override
    public String getEmailDestino() {
        return this.email;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCodigo() {
        return Long.toString(CODIGO);
    }

    @Override
    public TelaPadrao getTelaDeReferencia() {
        return telaAdm;
    }



}