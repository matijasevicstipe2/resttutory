package hr.ntp.resttutory.locations;

import hr.ntp.resttutory.fields.Field2;
import hr.ntp.resttutory.fields.FieldRepository;
import hr.ntp.resttutory.users.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Location2>> getAllLocations() {
        try {
            List<Location2> locations = new ArrayList<>();

            locationRepository.findAll().forEach(locations::add);
            if (locations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/location/{id}")
    public ResponseEntity<Location2> getLocationById(@PathVariable Long id) {
        Location2 location = locationRepository.findById(id);
        if (location != null) {
            return new ResponseEntity<>(location, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
