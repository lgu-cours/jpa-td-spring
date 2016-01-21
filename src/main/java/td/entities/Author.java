package td.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * The persistent class for the AUTHOR database table.
 * 
 */
@Entity
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;
	
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //@OneToMany(mappedBy="author", targetEntity=Book.class ) // Fecth Type is LAZY by default
    @OneToMany(mappedBy="author", targetEntity=Book.class, fetch=FetchType.EAGER)
    private List<Book> listOfBook  ;


    public Author() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfBook( List<Book> listOfBook ) {
        this.listOfBook = listOfBook;
    }
    public List<Book> getListOfBook() {
        return this.listOfBook;
    }


	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	

}