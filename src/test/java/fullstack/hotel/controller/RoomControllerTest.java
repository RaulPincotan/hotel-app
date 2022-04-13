package fullstack.hotel.controller;

import fullstack.hotel.model.entity.Room;
import fullstack.hotel.services.RoomService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RoomService roomService;

    @Test
    public void getSomething() throws Exception {
        Mockito.when(roomService.getById(1L)).thenReturn(Room.builder()
                .id(1L)
                .roomNumber("F01")
                .hotelName("Melody")
                .build());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/rooms/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{id:1,hotelName:Melody,roomNumber:F01}"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomNumber", CoreMatchers.is("F01")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotelName", CoreMatchers.is("Melody")))
                .andReturn();

        Mockito.verify(roomService, Mockito.times(1)).getById(1L);
    }
}
