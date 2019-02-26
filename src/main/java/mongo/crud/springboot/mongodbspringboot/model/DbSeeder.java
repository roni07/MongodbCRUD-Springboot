package mongo.crud.springboot.mongodbspringboot.model;

import mongo.crud.springboot.mongodbspringboot.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.hotelRepository.deleteAll();
    }
}
