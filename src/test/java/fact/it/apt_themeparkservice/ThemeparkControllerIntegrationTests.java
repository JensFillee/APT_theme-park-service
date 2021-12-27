package fact.it.apt_themeparkservice;

import fact.it.apt_themeparkservice.model.Themepark;
import fact.it.apt_themeparkservice.repository.ThemeparkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ThemeparkControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ThemeparkRepository themeparkRepository;

    private Themepark themepark1 = new Themepark("1","Themepark1","straatlaan 1", 5000,"156555");
    private Themepark themepark2 =  new Themepark("2","Themepark2","straatlaan 2", 8000,"156444");


    @BeforeEach
    public void beforeAllTests() {
        themeparkRepository.deleteAll();
        themeparkRepository.save(themepark1);
        themeparkRepository.save(themepark2);
    }

    @AfterEach
    public void afterAllTests() {
        //Watch out with deleteAll() methods when you have other data in the test database!
        themeparkRepository.deleteAll();
    }

    @Test
    public void givenThemepark_whenGetThemeparkByParkCode_thenReturnJsonThemepark() throws Exception {

        mockMvc.perform(get("/api/themeparks/{themeparkCode}","156555"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("Themepark1")))
                .andExpect(jsonPath("$.themeparkCode",is("156555")))
                .andExpect(jsonPath("$.address",is("straatlaan 1")))
                .andExpect(jsonPath("$.capacity",is(5000)));
    }

    @Test
    public void givenThemeparks_whenGetThemeparkByName_thenReturnJsonThemeparks() throws Exception {

        mockMvc.perform(get("/api/themeparks/name/{name}","Themepark"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name",is("Themepark1")))
                .andExpect(jsonPath("$[0].themeparkCode",is("156555")))
                .andExpect(jsonPath("$[0].address",is("straatlaan 1")))
                .andExpect(jsonPath("$[0].capacity",is(5000)))
                .andExpect(jsonPath("$[1].name",is("Themepark2")))
                .andExpect(jsonPath("$[1].themeparkCode",is("156444")))
                .andExpect(jsonPath("$[1].address",is("straatlaan 2")))
                .andExpect(jsonPath("$[1].capacity",is(8000)));
    }
}
