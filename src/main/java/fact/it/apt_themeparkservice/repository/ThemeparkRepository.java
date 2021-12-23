package fact.it.apt_themeparkservice.repository;

import fact.it.apt_themeparkservice.model.Themepark;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeparkRepository extends MongoRepository<Themepark,String> {
    Themepark findThemeParkByThemeparkCode(String Themeparkcode);
    List<Themepark> findThemeparkByNameContaining(String name);
}
