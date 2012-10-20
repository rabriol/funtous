package br.com.funtous.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="commentary")
@Entity
@NamedQueries({
	@NamedQuery(name="Commentary.findById", query="SELECT c FROM Commentary c WHERE c.id = :id")
})
public class Commentary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5013450432487397519L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDT_COMMENTARY")
	private Long id;
	@ManyToOne
	@JoinColumn(name="IDT_MEDIA")
	private Media media;
	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE", nullable=false, insertable=true, updatable=false)
	private Date createdDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREATED_BY")
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
