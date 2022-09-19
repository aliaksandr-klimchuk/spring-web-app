package alex.klimchuk.spring5.webapp.repositories;

import alex.klimchuk.spring5.webapp.entities.PublisherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright Alex Klimchuk (c) 23.12.2019.
 */
@Repository
public interface PublisherRepository extends CrudRepository<PublisherEntity, Long> {

}
