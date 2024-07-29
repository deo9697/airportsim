package CUSTOMQUERY2.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "Flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private String description;
    @Column(nullable = false)
    private String fromAirport;
    @Column(nullable = false)
    private String toAirport;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ONTIME;

    public Flight(Integer id, String description, String fromAirport, String toAirport, Status status) {

        this.id = id;
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }

    public Flight() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "description='" + description + '\'' +
                ", fromAirport='" + fromAirport + '\'' +
                ", toAirport='" + toAirport + '\'' +
                '}';
    }
}
