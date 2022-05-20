package hr.ntp.resttutory.ads;

import hr.ntp.resttutory.ads.Ad;
import hr.ntp.resttutory.ads.Ad2;

import java.util.List;

public interface AdRepository {
    int save(Ad ad);
    void saveDemand(AdDemand adDemand);
    List<Ad2> findAll();
    List<Ad2> findAllCriteria(Long user);
    List<Ad2> findUserAds(Long user);
}
