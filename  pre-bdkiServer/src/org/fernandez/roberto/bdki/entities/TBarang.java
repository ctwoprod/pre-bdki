package org.fernandez.roberto.bdki.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: t_barang.
 * @author autogenerated
 */

@JsonAutoDetect
@Entity
@Table(name = "t_barang", catalog = "pre_bdki")
public class TBarang{

	/** Serial Version UID. */
	private static final long serialVersionUID = -558917090L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private String codeBarang;
	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private Long id = 0L; // init for hibernate bug workaround
	/** Field mapping. */
	private String nama;
	/** Field mapping. */
	private TVendor vendor;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public TBarang() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public TBarang(Long id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return TBarang.class;
	}
 

    /**
     * Return the value associated with the column: codeBarang.
	 * @return A String object (this.codeBarang)
	 */
	@Basic( optional = true )
	@Column( name = "code_barang", length = 10  )
	public String getCodeBarang() {
		return this.codeBarang;
		
	}
	

  
    /**  
     * Set the value related to the column: codeBarang.
	 * @param codeBarang the codeBarang value you wish to set
	 */
	public void setCodeBarang(final String codeBarang) {
		this.codeBarang = codeBarang;
	}

    /**
     * Return the value associated with the column: description.
	 * @return A String object (this.description)
	 */
	@Basic( optional = true )
	@Column( length = 256  )
	public String getDescription() {
		return this.description;
		
	}
	

  
    /**  
     * Set the value related to the column: description.
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
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
     * Return the value associated with the column: nama.
	 * @return A String object (this.nama)
	 */
	@Basic( optional = true )
	@Column( length = 256  )
	public String getNama() {
		return this.nama;
		
	}
	

  
    /**  
     * Set the value related to the column: nama.
	 * @param nama the nama value you wish to set
	 */
	public void setNama(final String nama) {
		this.nama = nama;
	}

    /**
     * Return the value associated with the column: vendor.
	 * @return A TVendor object (this.vendor)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "vendor_id", nullable = true )
	public TVendor getVendor() {
		return this.vendor;
		
	}
	

  
    /**  
     * Set the value related to the column: vendor.
	 * @param vendor the vendor value you wish to set
	 */
	public void setVendor(final TVendor vendor) {
		this.vendor = vendor;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public TBarang clone() throws CloneNotSupportedException {
		
        final TBarang copy = (TBarang)super.clone();

		copy.setCodeBarang(this.getCodeBarang());
		copy.setDescription(this.getDescription());
		copy.setId(this.getId());
		copy.setNama(this.getNama());
		copy.setVendor(this.getVendor());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("codeBarang: " + this.getCodeBarang() + ", ");
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("nama: " + this.getNama() + ", ");
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
		
		final TBarang that; 
		try {
			that = (TBarang) proxyThat;
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
		result = result && (((getCodeBarang() == null) && (that.getCodeBarang() == null)) || (getCodeBarang() != null && getCodeBarang().equals(that.getCodeBarang())));
		result = result && (((getDescription() == null) && (that.getDescription() == null)) || (getDescription() != null && getDescription().equals(that.getDescription())));
		result = result && (((getNama() == null) && (that.getNama() == null)) || (getNama() != null && getNama().equals(that.getNama())));
		result = result && (((getVendor() == null) && (that.getVendor() == null)) || (getVendor() != null && getVendor().getId().equals(that.getVendor().getId())));	
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
