package guru.springFramework.spring5webapp.repositories;


import guru.springFramework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
