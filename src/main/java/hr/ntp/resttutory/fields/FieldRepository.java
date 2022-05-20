package hr.ntp.resttutory.fields;

import java.util.List;

public interface FieldRepository {
    List<Field2> findAll();
    Field2 findById(Long id);
}
