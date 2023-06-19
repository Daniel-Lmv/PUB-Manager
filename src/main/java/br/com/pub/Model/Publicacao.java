package br.com.pub.Model;

import java.awt.image.BufferedImage;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publicacao {
    @Id
    private String pubId;
    private String status;
    private ZonedDateTime publishedAt;

    @NotBlank
    @NotNull
    private String text;

    @NotNull
    @NotBlank
    private String summary;


}