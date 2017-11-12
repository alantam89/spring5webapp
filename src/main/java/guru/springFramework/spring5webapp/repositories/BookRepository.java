package guru.springFramework.spring5webapp.repositories;

import guru.springFramework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
