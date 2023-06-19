package br.com.pub.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String userId;

    private ArrayList<Publicacao> listaPubs;

    public User(String id){
        this.userId = id;
        this.listaPubs = new ArrayList<>();
    }

}
