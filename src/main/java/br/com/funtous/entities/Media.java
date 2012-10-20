package br.com.funtous.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="media")
@NamedQueries({
	@NamedQuery(name="Media.findAll", query="SELECT m FROM Media m"),
	@NamedQuery(name="Media.findById", query="SELECT m FROM Media m WHERE m.id = :id")
})
public class Media implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8448092211059596625L;
	
	@Column(name="IDT_MEDIA")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="TYPE")
	@Enumerated(EnumType.STRING)
	private MediaType type;
	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE", nullable=false, insertable=true, updatable=false)
	private Date createdDate;
	@ManyToOne
	@JoinColumn(name="CREATED_BY")
	private User user;
	@Column(name="DATA", nullable=false, insertable=true, updatable=true, length=2048)
	private byte[] data;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="media")
	private List<Commentary> commentaries;
	
	public Media() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MediaType getType() {
		return type;
	}
	public void setType(MediaType type) {
		this.type = type;
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
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public List<Commentary> getCommentaries() {
		return commentaries;
	}
	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}
}
