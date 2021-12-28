package fact.it.apt_themeparkservice;

import fact.it.apt_themeparkservice.model.Themepark;
import fact.it.apt_themeparkservice.repository.ThemeparkRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.context.Theme;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ThemeparkRepositoryTests {

    @Autowired
    private ThemeparkRepository themeparkRepository;

    @BeforeEach
    public void beforeAllTests() {
        themeparkRepository.saveAll(Lists.newArrayList(
                new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1")
        ));
    }

    @Test
    void findThemeparkByThemeparkCode_happy() {
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");

        Themepark result = themeparkRepository.findThemeparkByThemeparkCode("TP1");

        assertThat(result).isNotNull();
        //vergelijkt de elementen van de aangemaakte themepark met die uit de before each
        assertThat(result).usingRecursiveComparison().isEqualTo(themepark);
    }

    @Test
    void findThemeparkByNameContaining_happy() {
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");

        List<Themepark> result = themeparkRepository.findThemeparkByNameContaining("Themepark");

        assertThat(result).isNotNull().isNotEmpty();
        //vergelijk het eerste item uit de lijst
//        assertThat(result.get(0)).usingRecursiveComparison().isEqualTo(themepark);
        assertThat(result).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(themepark);

    }



}
