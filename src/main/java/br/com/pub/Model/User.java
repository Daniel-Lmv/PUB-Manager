package br.com.pub.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    @NotNull
    @NotBlank
    private ObjectId userId;

    private ArrayList<Publicacao> listaPubs = new ArrayList<>();

    public User(ObjectId id){
        this.userId = id;
    }
    
    public ArrayList<Publicacao> getListaPubs () {
    	return listaPubs;
    }
    
    public Publicacao getPubById (ObjectId PubId) {
    	for (Publicacao pub : listaPubs) {
    		if (pub.getPubId().equals(PubId)) {
    			return pub;
    		}
    	}
    	return null;
    }
    
    public void addToListaPubs (Publicacao pub) {
    	listaPubs.add(pub);;
    }
    
    public void modifyPub (Publicacao pub) {
    	for (Publicacao p : listaPubs) {
    		if (p.getPubId().equals(pub.getPubId())) {
    			listaPubs.remove(p);
    			listaPubs.add(pub);
    		}
    	}
    }
    
    public Publicacao removePub (ObjectId pubId) {
    	for (Publicacao p : listaPubs) {
    		if (p.getPubId().equals(pubId)) {
    			Publicacao removedPub = p;
    			listaPubs.remove(p);
    			return removedPub;
    		}
    	}
    	return null;
    }
}
