package br.com.pub.Model;

import java.time.Instant;

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
    private ObjectId pubId;
    
    private String status;
    private Instant publishedAt;
    
    @NotBlank
    @NotNull
    private String text;
    
    @NotBlank
    @NotNull
    private String summary;

    public ObjectId getPubId () {
    	return pubId;
    }
    
    public void setPubId(ObjectId pubId) {
		this.pubId = pubId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Instant publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}