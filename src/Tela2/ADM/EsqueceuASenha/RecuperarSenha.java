package Tela2.ADM.EsqueceuASenha;
import Criptografia.CriptografiaDeSenha;
import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaLivreiro.PersistenciaADM;
import Tela2.ADM.Tela.TelaADM;

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

public class RecuperarSenha {

    private static TelaADM telaAdm;
    private static final long CODIGO = System.currentTimeMillis();
    private static final String TITULO_DAS_JANELAS="Recuperação de senha";

    private String email;
    private String nome;
    private PersistenciaADM PERSISTENCIA_ADM = new PersistenciaADM();
    private Livreiro livreiro = PERSISTENCIA_ADM.recuperarLivreiro();


    public void gerenciarEnvioDeEmail(){
        if(livreiro.getNumeroDeRecuperacao()==null ||
                !livreiro.getNumeroDeRecuperacao().equals(Long.toString(CODIGO)) ){
            this.envioDeEmail();
        }
    }

    public void addNumeroDeRecuperacao(String codigo) throws Exception {
        livreiro.setNumeroDeRecuperacao(codigo);
        PERSISTENCIA_ADM.salvarCentral(livreiro);

    }

    public void codigoCorreto() throws Exception {
        String senha =JOptionPane.showInputDialog(telaAdm,"Digite sua nova senha: ",
                TITULO_DAS_JANELAS,JOptionPane.QUESTION_MESSAGE);


        senha = new CriptografiaDeSenha().criptografia(senha);
        livreiro.setSenha(senha);
        PERSISTENCIA_ADM.salvarCentral(livreiro);

        JOptionPane.showMessageDialog(telaAdm,"Senha alterada com sucesso",
                TITULO_DAS_JANELAS,JOptionPane.INFORMATION_MESSAGE);
    }

    public void codigoIncorreto(){
        JOptionPane.showMessageDialog(telaAdm,"Seu codigo está errado, tente novamente.",
                TITULO_DAS_JANELAS,JOptionPane.INFORMATION_MESSAGE);
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


    public void envioDeEmail() {
        String senha="EstanteDigital.//0210@#";
        String emailRemetente = "estante.digital2@gmail.com";
        String emailDestino = this.email;
        String assunto = "Recuperação de senha";

        String mensagem = "Olá, "+
                this.nome+
                "\nSeu código de recuperação é:\n"+
                CODIGO;

        Properties props = new Properties();
        props.put("mail.smtp.user", emailRemetente);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.EnableSSL.enable","true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(emailRemetente, senha);
                    }
                });

        session.setDebug(false);
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailRemetente));

            Address[] toUser = InternetAddress.parse(emailDestino);
            message.setRecipients(Message.RecipientType.TO,toUser);
            message.setSubject(assunto);
            message.setText(mensagem);
            Transport.send(message);

        }catch(Exception e){
            JOptionPane.showMessageDialog(telaAdm,"Algo deu errado",
                    TITULO_DAS_JANELAS,JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public RecuperarSenha(TelaADM telaAdm,JLabel label) throws Exception {
        RecuperarSenha.telaAdm = telaAdm;
        String emailMETHOD = this.pegaEmailEscondido();

        this.gerenciarEnvioDeEmail();
        this.addNumeroDeRecuperacao(Long.toString(CODIGO));

        //Saindo da tela de Load do jLabel
        label.setText("Esqueceu sua senha?");
        label.setForeground(Color.WHITE);
        label.setIcon(null);

        String resultado = JOptionPane.showInputDialog(telaAdm,
                "<html>Enviamos um código de recuperação para: <br>"+emailMETHOD+"<br><br>Digite o código: <html>",
                RecuperarSenha.TITULO_DAS_JANELAS,JOptionPane.QUESTION_MESSAGE).replace(" ","");

        String codigoAsString = Long.toString(CODIGO);
        if(resultado.equals(codigoAsString)){
            this.codigoCorreto();
        }else{
            this.codigoIncorreto();
        }

    }
}