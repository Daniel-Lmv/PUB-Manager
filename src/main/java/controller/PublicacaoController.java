package controller;

import java.util.Collection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.InsertOneResult;

import model.Publicacao;

public class PublicacaoController {
	private MongoCollection<Publicacao> _publicacoes;
	
	/**
	 * Construtor da classe
	 * @throws Exception
	 */
	public PublicacaoController() throws Exception
	{
		//Chama a função que cria a conexão com o banco
		_publicacoes = controller.Connection.getDatabase().getCollection("Publicacoes", Publicacao.class);	
	}
	
	/**
	 * Método que adiciona uma nova publicação ao banco
	 * @param publicacao
	 */
	public void addPublicacao(Publicacao publicacao)
	{
		//Cria uma coleção
		InsertOneResult result = _publicacoes.insertOne(publicacao);
		
		if(result.getInsertedId() != null)
		{
			System.out.println("Publicacão inserida com sucesso!");
		}else {
			System.out.println("Não foi possivel inserir a publicação.");
		}
	}

	/**
	 * Método consultaPublicação, pesquisa uma pub no banco pelo titulo da pub
	 */
	public void consultaPublicacao()
	{
		MongoCursor cursor = _publicacoes.find().iterator();
		try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
            }
       } finally {
             cursor.close();
        }
	}
}
