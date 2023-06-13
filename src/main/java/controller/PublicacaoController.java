package controller;

import java.util.ArrayList;
import java.util.Collection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.InsertOneResult;

import com.sun.tools.javac.util.List;
import model.Publicacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pub-manager")
public class PublicacaoController {
	private MongoCollection<Publicacao> _publicacoes;
	private final ArrayList<Publicacao> ListOsPubs = new ArrayList<Publicacao>();
	
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
	 * Método getAllUserPubs, retorna todas as publicações de um determinado usuário
	 */
	@GetMapping
	public ArrayList<Publicacao> getAllUserPubs()
	{
		return ListOfPubs;
		/*MongoCursor cursor = _publicacoes.find().iterator();
		try {
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}*/
	}

	public void getOpen()
	{}

	public Publicacao getLastPub()
	{
		return null;
	}


	/**
	 * Método postPub, adiciona uma nova publicação ao banco
	 * @param publicacao
	 */
	public void postPub(Publicacao publicacao)
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
	 * Método putPub, atualiza uma publicação já existente
	 */
	public void putPub()
	{

	}

	public void delPub()
	{}
}
