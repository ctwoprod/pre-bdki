package org.fernandez.roberto.bdki.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: t_vendor.
 * @author autogenerated
 */

@JsonAutoDetect
@Entity
@Table(name = "t_vendor", catalog = "pre_bdki")
public class TVendor{

	/** Serial Version UID. */
	private static final long serialVersionUID = -558917087L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private String alamat;
	/** Field mapping. */
	private String aktif;
	/** Field mapping. */
	private Long id = 0L; // init for hibernate bug workaround
	/** Field mapping. */
	private String name;
	/** Field mapping. */
	private String noTelp;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public TVendor() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public TVendor(Long id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return TVendor.class;
	}
 

    /**
     * Return the value associated with the column: alamat.
	 * @return A String object (this.alamat)
	 */
	@Basic( optional = true )
	@Column( length = 256  )
	public String getAlamat() {
		return this.alamat;
		
	}
	

  
    /**  
     * Set the value related to the column: alamat.
	 * @param alamat the alamat value you wish to set
	 */
	public void setAlamat(final String alamat) {
		this.alamat = alamat;
	}

    /**
     * Return the value associated with the column: aktif.
	 * @return A String object (this.aktif)
	 */
	@Basic( optional = true )
	@Column( length = 1  )
	public String getAktif() {
		return this.aktif;
		
	}
	

  
    /**  
     * Set the value related to the column: aktif.
	 * @param aktif the aktif value you wish to set
	 */
	public void setAktif(final String aktif) {
		this.aktif = aktif;
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
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	@Basic( optional = true )
	@Column( length = 256  )
	public String getName() {
		return this.name;
		
	}
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

    /**
     * Return the value associated with the column: noTelp.
	 * @return A String object (this.noTelp)
	 */
	@Basic( optional = true )
	@Column( name = "no_telp", length = 256  )
	public String getNoTelp() {
		return this.noTelp;
		
	}
	

  
    /**  
     * Set the value related to the column: noTelp.
	 * @param noTelp the noTelp value you wish to set
	 */
	public void setNoTelp(final String noTelp) {
		this.noTelp = noTelp;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public TVendor clone() throws CloneNotSupportedException {
		
        final TVendor copy = (TVendor)super.clone();

		copy.setAlamat(this.getAlamat());
		copy.setAktif(this.getAktif());
		copy.setId(this.getId());
		copy.setName(this.getName());
		copy.setNoTelp(this.getNoTelp());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("alamat: " + this.getAlamat() + ", ");
		sb.append("aktif: " + this.getAktif() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName() + ", ");
		sb.append("noTelp: " + this.getNoTelp() + ", ");
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
		
		final TVendor that; 
		try {
			that = (TVendor) proxyThat;
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
		result = result && (((getAlamat() == null) && (that.getAlamat() == null)) || (getAlamat() != null && getAlamat().equals(that.getAlamat())));
		result = result && (((getAktif() == null) && (that.getAktif() == null)) || (getAktif() != null && getAktif().equals(that.getAktif())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		result = result && (((getNoTelp() == null) && (that.getNoTelp() == null)) || (getNoTelp() != null && getNoTelp().equals(that.getNoTelp())));
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