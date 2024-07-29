package CUSTOMQUERY2.controller;

import CUSTOMQUERY2.entities.Flight;
import CUSTOMQUERY2.entities.Status;
import CUSTOMQUERY2.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    @PostMapping("/provision")
    public List<Flight> provisionFlights(
            @RequestParam(value = "n", defaultValue = "100") int n) {
        Random random = new Random();
        List<Flight> flights = IntStream.range(0, n).mapToObj(i -> {
            Flight flight = new Flight();
            flight.setDescription("Flight " + random.nextInt(10000));
            flight.setFromAirport("Airport " + random.nextInt(100));
            flight.setToAirport("Airport " + random.nextInt(100));
            flight.setStatus(Status.values()[random.nextInt(Status.values().length)]);
            return flight;
        }).collect(Collectors.toList());
        return flightRepo.saveAll(flights);
    }

    @GetMapping
    public Page<Flight> getAllFlights(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return flightRepo.findAll(pageable);
    }

    @GetMapping("/ontime")
    public List<Flight> getOnTimeFlights() {
        return flightRepo.findByStatus(Collections.singletonList(Status.ONTIME));
    }

    @GetMapping("/statuses")
    public List<Flight> getFlightsByStatuses(
            @RequestParam("p1") Status p1,
            @RequestParam("p2") Status p2) {
        return flightRepo.findByStatus(List.of(p1, p2));
    }
}
