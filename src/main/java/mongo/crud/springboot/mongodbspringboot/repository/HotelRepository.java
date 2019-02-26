package mongo.crud.springboot.mongodbspringboot.repository;

import mongo.crud.springboot.mongodbspringboot.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
