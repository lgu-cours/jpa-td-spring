package td.services;

public interface AuthorService {

	public String getAuthorFirstName(int id) ;

	//public void changeAuthorFirstName(int id, String firstName) ;
	
	public void createAuthor(int id, String firstName, String lastName) ;

	public void deleteAuthor(int id) ;
}
