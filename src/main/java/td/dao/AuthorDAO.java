package td.dao;

import td.entities.Author;

public interface AuthorDAO {
	
    void persist(Author entity);
    
    /**
     * Remove the given entity <br>
     * NB : the entity is supposed to be in the entity manger context (must not be detached)
     * @param entity
     */
    void remove(Author entity);
    
    /**
     * Delete the given entity <br>
     * The given entity is loaded in the context if necessary 
     * @param entity
     */
    void delete(Author entity);
    
    Author findById(int id);
}
