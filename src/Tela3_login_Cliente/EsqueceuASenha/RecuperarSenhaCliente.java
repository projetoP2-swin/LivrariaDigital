package Tela3_login_Cliente.EsqueceuASenha;

import Criptografia.CriptografiaDeSenha;
import EnvioDeEmail.EnviarEmail;
import Persistencia.Usuario.Usuario;
import Tela2_login_ADM.EsqueceuASenha.RecuperarSenhaADM;
import Tela3_login_Cliente.Tela.TelaLoginCliente;
import TelaPadrao.TelaPadrao;

import javax.swing.*;
import java.awt.*;

public class RecuperarSenhaCliente extends EnviarEmail {
    private TelaLoginCliente telaClientes;
    private JLabel label;
    private String email;
    private String nome;
    private long codigo = System.currentTimeMillis();;
    private Usuario user;


    public RecuperarSenhaCliente(TelaLoginCliente telaClientes, JLabel label){
        this.telaClientes=telaClientes;
        this.label=label;
        label.setForeground(Color.WHITE);
        this.verificaSeExisteEmail();
    }


    public void pedeOCodigo(){

        try {
            label.setIcon(null);
            label.setForeground(Color.WHITE);
            label.setText("Esqueceu a senha?");

            String codigo = JOptionPane.showInputDialog(telaClientes,"Digite o código: ");
            if(codigo.equals(this.getCodigo())){
                this.codigoCorreto();
            }else{
                this.codigoIncorreto();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaClientes,"Houve um erro");
        }
    }
    public void codigoCorreto() throws Exception {
        String novaSenha = JOptionPane.showInputDialog(telaClientes,"Digite sua nova senha: ");
        if(novaSenha==null){
            throw new Exception("Digite algo");
        }
        novaSenha = CriptografiaDeSenha.criptografia(novaSenha);
        user.setSenha(novaSenha);
        central.addUser(user);
        central.salvar();

    }
    public void codigoIncorreto(){
        JOptionPane.showMessageDialog(telaClientes,"Seu código está errado");
    }

    public void gerenciarEnvioDeEmail(){
        String numeroDeRecuperacao = user.getNumeroDeRecuperacao();


        if(numeroDeRecuperacao==null){
            user.setNumeroDeRecuperacao(this.getCodigo());
            central.addUser(user);
            central.salvar();
            this.envioDeEmail();
            this.pedeOCodigo();
        }else{
            String botoes[] ={"Sim","Não"};
            int index = JOptionPane.showOptionDialog(telaClientes,
                    "<html>Já enviamos uma mensagem para este email <br>" +
                    "Desenja reenviar outro código? <html>",
                    TITULO_DAS_JANELAS,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    botoes,
                    botoes[0]);

            if(index==0){
                this.envioDeEmail();
                user.setNumeroDeRecuperacao(this.getCodigo());
                central.addUser(user);
                central.salvar();
                this.pedeOCodigo();
            }else if(index==1){
                this.codigo=Long.parseLong(user.getNumeroDeRecuperacao());
                this.pedeOCodigo();
            }
        }
    }
    public void iniciaThread(){
        Thread thread = new Thread(() -> {
            this.gerenciarEnvioDeEmail();
        });
        ImageIcon gif = new ImageIcon("img/img_ADM/load/Book.gif");
        this.label.setText("");
        this.label.setIcon(gif);
        thread.start();

    }
    public void verificaSeExisteEmail(){
        String emailDigitado = JOptionPane.showInputDialog(telaClientes,
                "<html>Digite seu email<br> para recuperação de senha: <html>",
                TITULO_DAS_JANELAS,JOptionPane.QUESTION_MESSAGE);
        if(emailDigitado!=null){
            for(Usuario user: central.getUsuario()){
                if(user.getEmail().equals(emailDigitado)){
                    this.nome= user.getNome();
                    this.email=emailDigitado;
                    this.user=user;
                    break;
                }
            }

        }
        if(user!=null){
            this.iniciaThread();
        }else{
            JOptionPane.showMessageDialog(telaClientes,
                    "Não existe uma conta com esse email",
                    TITULO_DAS_JANELAS,JOptionPane.QUESTION_MESSAGE);
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
        return Long.toString(codigo);
    }

    @Override
    public TelaPadrao getTelaDeReferencia() {
        return this.telaClientes;
    }
}
