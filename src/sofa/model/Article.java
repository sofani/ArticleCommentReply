package sofa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Article implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY) 
	 private int aId;
     private String userName;
     private String title;
     private String summary;
     private String description;
     private byte[] photo;
     
     public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@OneToMany(mappedBy = "article", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
     private List<Comment> comments;
     
	 public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public int getaId() {
		return aId;
	 }
	 public void setaId(int aId) {
		this.aId = aId;
	 }
	 public byte[] getPhoto() {
		return photo;
	 }
	 public void setPhoto(byte[] photo) {
		this.photo = photo;
	 }

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
