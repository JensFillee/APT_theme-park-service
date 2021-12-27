package fact.it.apt_themeparkservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fact.it.apt_themeparkservice.model.Themepark;
import org.junit.jupiter.api.Test;

public class ThemeparkModelTests {

    @Test
    void testConstructor(){
        Themepark themepark = new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");
        assertEquals("Themepark1",themepark.getName());
        assertEquals("straatlaan 1",themepark.getAddress());
        assertEquals(5000,themepark.getCapacity());
        assertEquals("TP1",themepark.getThemeparkCode());

    }

    @Test
    void getThemeparkCode_happy(){
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");

        assertThat(themepark).isNotNull();
        assertThat(themepark.getThemeparkCode()).isEqualTo("TP1");
    }

    @Test
    void getName_happy(){
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"TP1");

        assertThat(themepark).isNotNull();
        assertThat(themepark.getName()).isEqualTo("Themepark1");
    }

    @Test
    void getAddress_happy(){
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"156555");

        assertThat(themepark).isNotNull();
        assertThat(themepark.getAddress()).isEqualTo("straatlaan 1");
    }

    @Test
    void getCapacity_happy(){
        final Themepark themepark =  new Themepark("1","Themepark1","straatlaan 1", 5000,"156555");

        assertThat(themepark).isNotNull();
        assertThat(themepark.getCapacity()).isEqualTo(5000);
    }
}
