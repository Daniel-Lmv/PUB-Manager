package view;

import java.util.Date;

import controller.PublicacaoController;
import model.Publicacao;

public class Main {
	public static void main(String[] args) throws Exception{
		PublicacaoController controller = new PublicacaoController();
		
		/**
		SocialMedia sm = new SocialMedia();
		sm.setUsername("jk");
		sm.setSocialMediaId("5s5feawe4");
		*/
		Date dataPublicacao = new Date();
		
		Publicacao pub = new Publicacao();
		pub.setStatus("agendada");
		pub.setSummary("Novidades na nossa loja para as festas do meio do ano");
		pub.setText("Você já realizou as compras das festas de meio de ano? se sua resposta é não corre para ver as novidades!");
		pub.setUserId("005");//informação do gestor de usuarios
		pub.setPublishedAt(dataPublicacao);
		pub.setUsername("v");
		
		controller.addPublicacao(pub);
		controller.consultaPublicacao();
	}
}
