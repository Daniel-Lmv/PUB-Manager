package controller;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {
	private static MongoClient _connection;
	
	/**
	 * Método getDatabase responsavel pela conexão
	 * @return dtb
	 * @throws Exception
	 */
	public static MongoDatabase getDatabase() throws Exception
	{
		try {
			
			if(_connection == null)
			{
				_connection = MongoClients.create();
			}
			CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
				    MongoClientSettings.getDefaultCodecRegistry(),
				    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
			);
			MongoDatabase  dtb = _connection.getDatabase("Publicacoes").withCodecRegistry(pojoCodecRegistry);
			return dtb;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Método closeConnection que encerra a conexão com o banco
	 */
	public static void closeConnection()
	{
		if(_connection != null)
		{
			_connection.close();
		}
	}
}
