package Tela1.Ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Criptografia.CriptografiaDeSenha;
import Tela1.Persistencia.Livreiro;
import Tela1.Persistencia.PersistenciaADM;
import Tela1.Tela.TelaAddLivreiro;
import Tela2.User.Tela.TelaUser;

public class OuvinteDaClasseTelaAddLivreiro implements ActionListener{
	private final TelaAddLivreiro livreiroInfo;
	
	public OuvinteDaClasseTelaAddLivreiro(TelaAddLivreiro livreiroInfo ) {
		this.livreiroInfo = livreiroInfo;	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String nome = livreiroInfo.getNome();
		String email=livreiroInfo.getEmail();
		String senha = livreiroInfo.getSenha();

		boolean condicao = nome.equals("") || email.equals("") || senha.equals("");
		if(condicao) {
			JOptionPane.showMessageDialog(livreiroInfo, "Não deixe campos em branco");
		}else {
			PersistenciaADM p = new PersistenciaADM();
			CriptografiaDeSenha criptografia = new CriptografiaDeSenha();
			senha = criptografia.criptografia(senha);
			Livreiro livreiro = new Livreiro(nome, email, senha);
			
			try {
				p.salvarCentral(livreiro);
				JOptionPane.showMessageDialog(livreiroInfo, "Dados Salvos com sucesso");
				livreiroInfo.dispose();
				TelaUser telaUser = new TelaUser("Livraria Digital - User");
				telaUser.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(livreiroInfo, "Houve um problema ao salvar os dados");
			}
			
		}

	}

}
