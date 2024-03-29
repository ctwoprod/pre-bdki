package org.fernandez.roberto.bdki.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: t_login.
 * @author autogenerated
 */

@JsonAutoDetect
@Entity
@Table(name = "t_login", catalog = "pre_bdki")
public class TLogin{

	/** Serial Version UID. */
	private static final long serialVersionUID = -558917088L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Long id = 0L; // init for hibernate bug workaround
	/** Field mapping. */
	private Long idAnggota;
	/** Field mapping. */
	private Date lastLogin;
	/** Field mapping. */
	private String password;
	/** Field mapping. */
	private String username;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public TLogin() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public TLogin(Long id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return TLogin.class;
	}
 

    /**
     * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic( optional = false )
	@Column( name = "id", nullable = false  )
	public Long getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0L) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: idAnggota.
	 * @return A Long object (this.idAnggota)
	 */
	@Basic( optional = true )
	@Column( name = "id_anggota"  )
	public Long getIdAnggota() {
		return this.idAnggota;
		
	}
	

  
    /**  
     * Set the value related to the column: idAnggota.
	 * @param idAnggota the idAnggota value you wish to set
	 */
	public void setIdAnggota(final Long idAnggota) {
		this.idAnggota = idAnggota;
	}

    /**
     * Return the value associated with the column: lastLogin.
	 * @return A Date object (this.lastLogin)
	 */
	@Basic( optional = true )
	@Column( name = "last_login"  )
	public Date getLastLogin() {
		return this.lastLogin;
		
	}
	

  
    /**  
     * Set the value related to the column: lastLogin.
	 * @param lastLogin the lastLogin value you wish to set
	 */
	public void setLastLogin(final Date lastLogin) {
		this.lastLogin = lastLogin;
	}

    /**
     * Return the value associated with the column: password.
	 * @return A String object (this.password)
	 */
	@Basic( optional = true )
	@Column( length = 256  )
	public String getPassword() {
		return this.password;
		
	}
	

  
    /**  
     * Set the value related to the column: password.
	 * @param password the password value you wish to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

    /**
     * Return the value associated with the column: username.
	 * @return A String object (this.username)
	 */
	@Basic( optional = true )
	@Column( length = 256  )
	public String getUsername() {
		return this.username;
		
	}
	

  
    /**  
     * Set the value related to the column: username.
	 * @param username the username value you wish to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public TLogin clone() throws CloneNotSupportedException {
		
        final TLogin copy = (TLogin)super.clone();

		copy.setId(this.getId());
		copy.setIdAnggota(this.getIdAnggota());
		copy.setLastLogin(this.getLastLogin());
		copy.setPassword(this.getPassword());
		copy.setUsername(this.getUsername());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("idAnggota: " + this.getIdAnggota() + ", ");
		sb.append("lastLogin: " + this.getLastLogin() + ", ");
		sb.append("password: " + this.getPassword() + ", ");
		sb.append("username: " + this.getUsername());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final TLogin that; 
		try {
			that = (TLogin) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getIdAnggota() == null) && (that.getIdAnggota() == null)) || (getIdAnggota() != null && getIdAnggota().equals(that.getIdAnggota())));
		result = result && (((getLastLogin() == null) && (that.getLastLogin() == null)) || (getLastLogin() != null && getLastLogin().equals(that.getLastLogin())));
		result = result && (((getPassword() == null) && (that.getPassword() == null)) || (getPassword() != null && getPassword().equals(that.getPassword())));
		result = result && (((getUsername() == null) && (that.getUsername() == null)) || (getUsername() != null && getUsername().equals(that.getUsername())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Long newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0L) {
							newHashCode = getId();
						} else {
							newHashCode = (long) super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
		return (int) (this.hashCode & 0xffffff);
	}
	

	
}
