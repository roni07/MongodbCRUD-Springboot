package mongo.crud.springboot.mongodbspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Hotels")
public class Hotel {
    @Id
    private String hotelId;
    private double pricePerNight;
    private Address address;
    private List<Review> reviews;
    @DBRef
    @Indexed
    private Person person;

    public Hotel(double pricePerNight, Address address, List<Review> reviews, Person person) {
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.reviews = reviews;
        this.person = person;
    }
}
