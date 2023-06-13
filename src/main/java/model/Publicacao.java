package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

public class Publicacao {
	private ObjectId pubId;
	private String userId;
	private String status;
	private String text;
	private String summary;
	private Date publishedAt;
	private String username;
	
	private ArrayList<SocialMedia> socialMedias;
	private ArrayList<BufferedImage> images;
	
	/**
	 * Construtor da classe que inicializa os arrays(socialMedia, Images)
	 */
	public Publicacao()
	{
		socialMedias = new ArrayList<SocialMedia>();
		images = new ArrayList<BufferedImage>();
	}
	
	public void addSocialMedias(SocialMedia sm)
	{
		socialMedias.add(sm);
	}
	
	public void addImages(BufferedImage img)
	{
		images.add(img);
	}

	public ObjectId getPubId() 
	{
		return pubId;
	}

	public void setPubId(ObjectId pubId) 
	{
		this.pubId = pubId;
	}

	public String getUserId() 
	{
		return userId;
	}

	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getText() 
	{
		return text;
	}

	public void setText(String text) 
	{
		this.text = text;
	}

	public String getSummary() 
	{
		return summary;
	}

	public void setSummary(String summary) 
	{
		this.summary = summary;
	}

	public Date getPublishedAt() 
	{
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) 
	{
		this.publishedAt = publishedAt;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}
	
}
