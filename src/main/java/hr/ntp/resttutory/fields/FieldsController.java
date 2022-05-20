package hr.ntp.resttutory.fields;

import hr.ntp.resttutory.fields.Field2;
import hr.ntp.resttutory.fields.FieldRepository;
import hr.ntp.resttutory.locations.Location2;
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
@RequestMapping("fields")
public class FieldsController {

    @Autowired
    private FieldRepository fieldRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Field2>> getAllFields() {
        try {
            List<Field2> fields = new ArrayList<>();

            fieldRepository.findAll().forEach(fields::add);
            if (fields.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fields, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/field/{id}")
    public ResponseEntity<Field2> getFieldById(@PathVariable Long id) {
        Field2 field = fieldRepository.findById(id);
        if (field != null) {
            return new ResponseEntity<>(field, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
