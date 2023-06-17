package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public class Publicacao {
	private int pubId;
	private String userId;
	private Boolean status;
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

	public int getPubId() 
	{
		return pubId;
	}

	public void setPubId(int pubId) 
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

	public Boolean getStatus() 
	{
		return status;
	}

	public void setStatus(Boolean status) 
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
