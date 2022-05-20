package hr.ntp.resttutory.locations;

import java.util.List;

public interface LocationRepository {
    List<Location2> findAll();
    Location2 findById(Long id);
}
