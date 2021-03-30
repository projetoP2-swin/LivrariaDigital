package Tela2.ADM.EsqueceuASenha;
import Criptografia.CriptografiaDeSenha;
import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaLivreiro.PersistenciaADM;
import Tela2.ADM.Tela.TelaADM;

import javax.swing.*;
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
    private static long codigo = System.currentTimeMillis();
    private static String email;
    private static String nome;
    private String tituloDasJanelas="Recuperação de senha";

    public RecuperarSenha(TelaADM telaAdm) throws Exception {
        RecuperarSenha.telaAdm = telaAdm;
        String email = this.pegaEmailEscondido();
        this.envioDeEmail();
        String resultado = JOptionPane.showInputDialog(telaAdm,
                "<html>Enviamos um código de recuperação para: <br>"+email+"<br><br>Digite o código: <html>",
                this.tituloDasJanelas,JOptionPane.QUESTION_MESSAGE).replace(" ","");

        String codigoAsString = Long.toString(codigo);
        if(resultado.equals(codigoAsString)){
            this.codigoCorreto();
        }else{
            this.codigoIncorreto();
        }

    }

    public void codigoCorreto() throws Exception {
        String senha =JOptionPane.showInputDialog(telaAdm,"Digite sua nova senha: ",
                this.tituloDasJanelas,JOptionPane.QUESTION_MESSAGE);

        PersistenciaADM persistenciaADM = new PersistenciaADM();
        Livreiro livreiro = persistenciaADM.recuperarLivreiro();
        senha = new CriptografiaDeSenha().criptografia(senha);
        livreiro.setSenha(senha);
        persistenciaADM.salvarCentral(livreiro);

        JOptionPane.showMessageDialog(telaAdm,"Senha alterada com sucesso",
                this.tituloDasJanelas,JOptionPane.INFORMATION_MESSAGE);
    }

    public void codigoIncorreto(){
        JOptionPane.showMessageDialog(telaAdm,"Seu codigo está errado, tente novamente.",
                this.tituloDasJanelas,JOptionPane.INFORMATION_MESSAGE);
    }

    public String pegaEmailEscondido() throws Exception {
        PersistenciaADM persistencia = new PersistenciaADM();

        RecuperarSenha.email = persistencia.recuperarLivreiro().getEmail();
        RecuperarSenha.nome =  persistencia.recuperarLivreiro().getNome();

        String resultado= email.substring(2,email.indexOf("@"));
        resultado = email.substring(0,2)  + "*".repeat(resultado.length()) + email.substring(email.indexOf("@"));
        return resultado;
    }


    public boolean envioDeEmail() {
        String senha="Um2Tres456";
        String emailRemetente = "projetop2002@gmail.com";
        String emailDestino = RecuperarSenha.email;
        String assunto = "Recuperação de senha";
        String mensagem = "Olá, "+RecuperarSenha.nome+"\nSeu código de recuperação é:\n"+ Long.toString(codigo);

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

            Address toUser[]= InternetAddress.parse(emailDestino);
            message.setRecipients(Message.RecipientType.TO,toUser);
            message.setSubject(assunto);
            message.setText(mensagem);
            Transport.send(message);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(telaAdm,"Algo deu errado",
                    this.tituloDasJanelas,JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

    }
}
