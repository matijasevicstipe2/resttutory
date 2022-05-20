package hr.ntp.resttutory.ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ads")
public class AdController {

    @Autowired
    private AdRepository adRepository;

    @PostMapping("/createAd")
    public ResponseEntity<String> createAd(@RequestBody Ad ad) {

        try {
            adRepository.save(new Ad(ad.getTitle(),ad.getField(),ad.getInfo(),ad.getLocation(),
                    ad.getPrice(),ad.getUser()));
            return new ResponseEntity<>("Ad was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PostMapping("/demand")
    public ResponseEntity<String> createDemand(@RequestBody AdDemand adDemand) {

        try {
            adRepository.saveDemand(adDemand);
            return new ResponseEntity<>("Ad demand was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ad2>> getAllAds() {
        try {
            List<Ad2> ads = new ArrayList<>();
            adRepository.findAll().forEach(ads::add);
            if (ads.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/criteria/{user}")
    public ResponseEntity<List<Ad2>> getCriteriaAds(@PathVariable Long user) {
        try {
            List<Ad2> ads = new ArrayList<>();
            adRepository.findAllCriteria(user).forEach(ads::add);
            if (ads.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/{user}")
    public ResponseEntity<List<Ad2>> getUserAds(@PathVariable Long user) {
        try {
            List<Ad2> ads = new ArrayList<>();
            adRepository.findUserAds(user).forEach(ads::add);
            if (ads.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
