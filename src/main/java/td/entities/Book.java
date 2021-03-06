/*
 * Created on 21 janv. 2015 ( Time 17:25:52 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package td.entities;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "BOOK"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="BOOK", schema="ROOT" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="BookEntity.countAll", query="SELECT COUNT(x) FROM Book x" )
} )
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="ID", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ISBN", nullable=false, length=13)
    private String     isbn         ;

    @Column(name="TITLE", length=160)
    private String     title        ;

    @Column(name="PRICE")
    private BigDecimal price        ;

    @Column(name="QUANTITY")
    private Integer    quantity     ;

    @Column(name="DISCOUNT")
    private Integer    discount     ;

    @Column(name="AVAILABILITY")
    private Short      availability ;

    @Column(name="BEST_SELLER")
    private Short      bestSeller   ;

	// "publisherId" (column "PUBLISHER_ID") is not defined by itself because used as FK in a link 
	// "authorId" (column "AUTHOR_ID") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="AUTHOR_ID", referencedColumnName="ID")
    private Author author      ;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Book() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : ISBN ( VARCHAR ) 
    public void setIsbn( String isbn ) {
        this.isbn = isbn;
    }
    public String getIsbn() {
        return this.isbn;
    }

    //--- DATABASE MAPPING : TITLE ( VARCHAR ) 
    public void setTitle( String title ) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }

    //--- DATABASE MAPPING : PRICE ( DECIMAL ) 
    public void setPrice( BigDecimal price ) {
        this.price = price;
    }
    public BigDecimal getPrice() {
        return this.price;
    }

    //--- DATABASE MAPPING : QUANTITY ( INTEGER ) 
    public void setQuantity( Integer quantity ) {
        this.quantity = quantity;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    //--- DATABASE MAPPING : DISCOUNT ( INTEGER ) 
    public void setDiscount( Integer discount ) {
        this.discount = discount;
    }
    public Integer getDiscount() {
        return this.discount;
    }

    //--- DATABASE MAPPING : AVAILABILITY ( SMALLINT ) 
    public void setAvailability( Short availability ) {
        this.availability = availability;
    }
    public Short getAvailability() {
        return this.availability;
    }

    //--- DATABASE MAPPING : BEST_SELLER ( SMALLINT ) 
    public void setBestSeller( Short bestSeller ) {
        this.bestSeller = bestSeller;
    }
    public Short getBestSeller() {
        return this.bestSeller;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setAuthor( Author author ) {
        this.author = author;
    }
    public Author getAuthor() {
        return this.author;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(isbn);
        sb.append("|");
        sb.append(title);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(quantity);
        sb.append("|");
        sb.append(discount);
        sb.append("|");
        sb.append(availability);
        sb.append("|");
        sb.append(bestSeller);
        return sb.toString(); 
    } 

}
