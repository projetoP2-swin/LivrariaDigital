package Tela1.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Tela1.Criptografia.CriptografiaDeSenha;
import Tela1.Livreiro;
import Tela1.PersistenciaADM;
import Tela1.TelaAddLivreiro;

public class OuvinteDaClasseTelaAddLivreiro implements ActionListener{
	private TelaAddLivreiro livreiroInfo;
	
	public OuvinteDaClasseTelaAddLivreiro(TelaAddLivreiro livreiroInfo ) {
		this.livreiroInfo = livreiroInfo;	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		PersistenciaADM p = new PersistenciaADM();
		CriptografiaDeSenha criptografia = new CriptografiaDeSenha();

		String nome = livreiroInfo.getNome();
		String email=livreiroInfo.getEmail();
		String senha = criptografia.criptografia(livreiroInfo.getSenha());
		
		boolean condicao = nome.equals("") || email.equals("") || senha.equals("");
		
		if(condicao == true) {
			JOptionPane.showMessageDialog(livreiroInfo, "Não deixe campos em branco");
		}else {
			Livreiro livreiro = new Livreiro(nome, email, senha);			
			
			try {
				p.salvarCentral(livreiro);
				JOptionPane.showMessageDialog(livreiroInfo, "Dados Salvos com sucesso");
				livreiroInfo.dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(livreiroInfo, "Houve um problema ao salvar os dados");
			}
			
		}

	}

}
