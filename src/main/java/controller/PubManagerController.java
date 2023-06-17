package controller;

import model.Publicacao;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;
import org.bson.types.ObjectId;

@RestController 
@RequestMapping("/pub-manager/pubs")
public class PubManagerController {
	private MongoCollection<Publicacao> pubs;
	
	/**
	 * Construtor da classe
	 * @throws Exception
	 */
	public PubManagerController() throws Exception
	{
		//Chama a função que cria a conexão com o banco
		pubs = controller.Connection.getDatabase().getCollection("Publicacoes", Publicacao.class);
	}
	
	/**
	 * Método getAllPubs, retorna todas as publicações de um determinado usuário
	 * @return ListOfPubs ArrayList contendo todas as publicações do banco
	 */
	@GetMapping
	public ArrayList<Publicacao> getAllPubs()
	{
		ArrayList<Publicacao> allPubs = new ArrayList<>();
		
		FindIterable<Publicacao> result = pubs.find();
		
		for (Publicacao p : result) {
			allPubs.add(p);
		}
		
		return allPubs;
	}
	
	/**
	 * Método getPubById, retorna uma publicação a partir do id
	 * @param pubId Id da publicação que se deseja
	 * @return pub Publicação cujo id foi passado por parâmetro, se o id não foi encontrado retorna nulo
	 */
	@GetMapping("/{pubId}")
	public Publicacao getPubById(@PathVariable int pubId)
	{
		Publicacao pub = null;
		
		Document query = new Document("pubId", pubId);
		pub = pubs.find(query).first();
				
		return pub;
	}
	
	/**
	 * Método getPublished, retorna uma lista de todas as publicações com status true (já publicadas)
	 * @return pubs ArrayList contendo todas as publicações do banco com o status true
	 */
	@GetMapping("/true")
	public ArrayList<Publicacao> getPublished()
	{
		ArrayList<Publicacao> published = new ArrayList<>();
		
		Document query = new Document("status", true);
		FindIterable<Publicacao> result = pubs.find(query);
		
		for (Publicacao p : result) {
			published.add(p);
		}
		
		return published;
	}
	
	/**
	 * Método getDrafted, retorna uma lista de todas as publicações com status false (ainda como draft)
	 * @return pubs ArrayList contendo todas as publicações do banco com o status false
	 */
	@GetMapping("/false")
	public ArrayList<Publicacao> getDrafted()
	{
		ArrayList<Publicacao> draft = new ArrayList<>();
		
		Document query = new Document("status", false);
		FindIterable<Publicacao> result = pubs.find(query);
		
		for (Publicacao p : result) {
			draft.add(p);
		}
		
		return draft;
	}
	
	/**
	 * Método postPub, adiciona uma nova publicação ao banco
	 * @param publicacao
	 */
	@PostMapping
	public void postPub(@RequestBody Publicacao publicacao)
	{
		//Cria uma coleção
		InsertOneResult result = pubs.insertOne(publicacao);
		
		if(result.getInsertedId() != null)
		{
			System.out.println("Publicacão inserida com sucesso!");
		}else {
			System.out.println("Não foi possivel inserir a publicação.");
		}
	}
	
	/**
	 * Método putPub, atualiza uma publicação já existente
	 * @param pubId Id da publicação que se deseja editar
	 */
	@PutMapping
	public void putPub(ObjectId pubId)
	{

	}
	
	/**
	 * Método deletePub, deleta uma publicação existente
	 * @param pubId Id da publicação que se deseja deletar
	 */
	@DeleteMapping
	public void deletePub(ObjectId pubId)
	{

	}
}
