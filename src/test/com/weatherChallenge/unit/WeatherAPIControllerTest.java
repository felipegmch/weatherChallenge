package weatherChallenge.unit;

import com.weather.controller.CityController;
import com.weather.model.DTO.Weather.*;
import com.weather.model.DTO.Weather.System;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static junit.framework.TestCase.assertSame;


@SpringBootTest(classes = CityController.class)
@RunWith(SpringRunner.class)
public class WeatherAPIControllerTest {

    @MockBean
    private CityController cityController;

    @Autowired
    private MockMvc mvc;

    private WeatherConditions weatherConditions;

    @Before
    public void setup() {
        weatherConditions = new WeatherConditions();
        weatherConditions.setCoord(new Coordinates(10.0, 53.55));
        weatherConditions.setWeather(new Weather[]{new Weather(803L, "Clouds", "broken clouds", "04n")});
        weatherConditions.setBase("stations");
        weatherConditions.setMain(new Main(14D, 1015D, 100D, 14D, 14D, 0D, 0D));
        weatherConditions.setWind(new Wind(0.5, null));
        weatherConditions.setClouds(new Clouds(75D));
        weatherConditions.setRain(new Rain());
        weatherConditions.setSnow(new Snow());
        weatherConditions.setDt(1528075200L);
        weatherConditions.setSys(new System(1L, 4883L, 0.0096, "DE", 1528080903L, 1528141335L));
        weatherConditions.setId(2911298);
        weatherConditions.setName("Hamburg");
        weatherConditions.setCode(200);
    }

    @Test
    public void demo() {
        assertSame(weatherConditions.getName(), "Hamburg");
    }


    @Test
    public void weather() throws Exception {

        BDDMockito.given(this.cityController.getWeatherbyCityNameAndCountryCode("Hamburg", "de", "metric")).willReturn(weatherConditions);

        this.mvc.perform(MockMvcRequestBuilders.get("/api/cities/2911298"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is("Hamburg")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country", CoreMatchers.is("DE")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lon", CoreMatchers.is(10D)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lat", CoreMatchers.is(53.55)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.temp", CoreMatchers.is(14D)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.wind", CoreMatchers.is(0.5)));

        Mockito.verify(this.cityController).getWeatherbyCityNameAndCountryCode("Hamburg", "de", "metric");
    }
}
