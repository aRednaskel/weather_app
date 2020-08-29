package com.weather.imgw.weatherApp.api.user.airquality

import com.fasterxml.jackson.databind.ObjectMapper
import com.weather.imgw.weatherApp.api.user.user.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class AirQualityControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private JacksonTester<UserDto> json;


    def "First Method" () {
//        given:


        when:
        UserDto userDto = new UserDto("user", "user", "user@user");


//        mockMvc.perform(get("/v1/users/example"))
//                .andDo(print())
//                .andExpect(jsonPath("\$[0].id").value("530"))
//                .andExpect(jsonPath("\$.password").value("example"))
//                .andExpect(jsonPath("\$.gender").value("MALE"))

        then:
        MockHttpServletResponse result = mockMvc.perform(
                post("/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.write(userDto).getJson()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn().response
//        result.status == HttpStatus.OK.value()
    }

    @Unroll
    def "Finds station with city name #cityName"() {
        when:
//        MockHttpServletResponse result = mockMvc.perform(
//                post("/v1/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(personJsonObject))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andReturn().response
//        mockMvc.perform(get("/v1/airquality/allStations"))
        MockHttpServletResponse result = mockMvc.perform(get("/v1/airquality")
                            .param("cityName", cityName))
                .andDo(print())
                .andExpect(jsonPath("\$[0].id").value("530"))
                .andReturn().response

        then:
        result == HttpStatus.OK.value()

        where:
        cityName << ["Warszawa", "Wrocław", "Gdańsk", "Legionowo"]
    }



}
