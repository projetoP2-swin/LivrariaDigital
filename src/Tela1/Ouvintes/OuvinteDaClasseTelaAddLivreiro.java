package Tela1.Ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Criptografia.CriptografiaDeSenha;
import Persistencia.Livreiro.Livreiro;
import Persistencia.PersistenciaLivreiro.PersistenciaADM;
import Tela1.Tela.TelaAddLivreiro;
import Tela2.ADM.Tela.TelaADM;

public class OuvinteDaClasseTelaAddLivreiro implements ActionListener{
	private TelaAddLivreiro livreiroInfo;

	public OuvinteDaClasseTelaAddLivreiro(TelaAddLivreiro livreiroInfo ) {
		this.livreiroInfo = livreiroInfo;
	}

	public String[] permitirCadastroSe(){
		String[] info = {livreiroInfo.getNome(),livreiroInfo.getEmail(),livreiroInfo.getSenha(),""};

		//info[3] trabalha como um valor booleando.
		//A ideia é recuperar todos os dados do Livreiro em um método simples.
		info[3]= info[0].equals("") || info[1].equals("") || info[2].equals("")?"1":"0";
		return info;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] info = this.permitirCadastroSe();

		if(info[3].equals("1")) {
			JOptionPane.showMessageDialog(livreiroInfo, "Não deixe campos em branco");

		}else if(info[1].contains("@")) {
			PersistenciaADM p = new PersistenciaADM();
			CriptografiaDeSenha criptografia = new CriptografiaDeSenha();

			try {
				info[2] = criptografia.criptografia(info[2]);
				Livreiro livreiro = new Livreiro(info[0], info[1], info[2]);
				p.salvarCentral(livreiro);
				JOptionPane.showMessageDialog(livreiroInfo, "Dados Salvos com sucesso");
				livreiroInfo.dispose();
				TelaADM telaADM = new TelaADM("Livraria Digital - User");
				telaADM.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(livreiroInfo, "Houve um problema ao salvar os dados");
			}

		}else{
			JOptionPane.showMessageDialog(livreiroInfo, "Digite um email válido");
		}

	}

}
