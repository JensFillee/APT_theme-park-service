package fact.it.apt_themeparkservice;

import fact.it.apt_themeparkservice.model.Themepark;
import fact.it.apt_themeparkservice.repository.ThemeparkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.context.Theme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ThemeparkRepositoryTests {

    @Autowired
    private ThemeparkRepository themeparkRepository;

    private Themepark themepark1 = new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");
    private Themepark themepark2 =  new Themepark("2","Themepark2","straatlaan 2", 8000,"TP2");

    @BeforeEach
    public void beforeAllTests(){
        themeparkRepository.deleteAll();
        themeparkRepository.save(themepark1);
        themeparkRepository.save(themepark2);
    }

    @AfterEach
    public void afterAllTests(){
        themeparkRepository.deleteAll();
    }

    @Test
    void findThemeparkByThemeparkCode_happy() {
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");

        Themepark result = themeparkRepository.findThemeparkByThemeparkCode("TP1");
        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(themepark);
    }

    @Test
    void findThemeparkByNameContaining_happy() {
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");
        final Themepark themepark2 =  new Themepark("2","Themepark2","straatlaan 2", 8000,"TP2");
        final List<Themepark> allThemeparks = Arrays.asList(themepark1, themepark2);

        List<Themepark> result = themeparkRepository.findThemeparkByNameContaining("Themepark");
        assertThat(result).isNotNull().isNotEmpty();
        assertThat(result).usingRecursiveComparison().ignoringCollectionOrder().ignoringFields("id").isEqualTo(allThemeparks);
    }



}
