package alex.klimchuk.spring5.webapp.repositories;

import alex.klimchuk.spring5.webapp.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright Alex Klimchuk (c) 23.12.2019.
 */
@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
