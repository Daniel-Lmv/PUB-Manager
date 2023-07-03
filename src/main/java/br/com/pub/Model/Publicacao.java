package br.com.pub.Model;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pubs")
public class Publicacao {
    @Id
    private long pubId;
    @NotBlank
    private String user;

    private Instant publishedAt;

    private String text;
    @NotBlank
    private String summary;
    
	public long getPubId() {
		return pubId;
	}

	public void setPubId(long pubId) {
		this.pubId = pubId;
	}
	
	public Instant getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Instant publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}