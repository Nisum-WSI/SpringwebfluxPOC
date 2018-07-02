package com.nisum.springwebfluxpoc;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


/*public interface WebFluxRepo extends CrudRepository<Score, Long>{

}*/

public interface WebFluxRepo extends ReactiveMongoRepository<Score, Long>{

}

