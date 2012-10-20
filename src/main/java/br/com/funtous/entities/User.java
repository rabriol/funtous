package br.com.funtous.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
@NamedQueries({
	@NamedQuery(name="User.findByNicknameAndPassword", query="SELECT m FROM User m WHERE m.nickname = :nickname and m.password = :password")
})
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -924341599047441538L;
	
	@Column(name="IDT_USER")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="NAME", insertable=true, length=200, updatable=true, nullable=false)
	private String name;
	@Column(name="AGE")
	@Temporal(TemporalType.DATE)
	private Date age;
	@Column(name="NICKNAME", length=20, insertable=true, updatable=false, nullable=false)
	private String nickname;
	@Column(name="PASSWORD", length=20, insertable=true, updatable=false, nullable=false)
	private String password;
	@Column(name="EMAIL", length=50, insertable=true, updatable=false, nullable=false)
	private String email;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="user")
	private List<Media> medias = new ArrayList<Media>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Media> getMedias() {
		return medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
}