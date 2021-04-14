package Utilitarios.Persistencia.Central_de_informacoes.Info_Login;

public class LoginSingleton {
    private boolean livreiro;
    private int usuario=-1;

    private static LoginSingleton login;
    private LoginSingleton() {

    }

    public static synchronized LoginSingleton getUnicaInstancia(){
        if(login == null){
            login=new LoginSingleton();
        }
        return login;

    }


    public boolean isLivreiro() {
        return livreiro;
    }

    public void setLivreiro(boolean livreiro) {
        this.livreiro = livreiro;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
