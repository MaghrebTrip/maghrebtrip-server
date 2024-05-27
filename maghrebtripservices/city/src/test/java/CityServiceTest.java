//import com.maghrebtrip.city.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.mock.web.MockMultipartFile;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class CityServiceTest {
//
//    @Mock
//    private CityRepository cityRepository;
//
//    @InjectMocks
//    private CityService cityService;
//
//    private City city;
//
//    @BeforeEach
//    public void setUp() {
//        city = City.builder()
//                .name("Marrakech")
//                .about("A beautiful city")
//                .image(new byte[0])
//                .rating(4.5f)
//                .build();
//    }
//
//    @Test
//    public void testGetAllCities() {
//        when(cityRepository.findAll()).thenReturn(Arrays.asList(city));
//
//        List<City> cities = cityService.getAllCities();
//
//        assertNotNull(cities);
//        assertEquals(1, cities.size());
//        verify(cityRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testGetCity() {
//        when(cityRepository.findById(anyInt())).thenReturn(Optional.of(city));
//
//        City foundCity = cityService.getCity(1);
//
//        assertNotNull(foundCity);
//        assertEquals("Marrakech", foundCity.getName());
//        verify(cityRepository, times(1)).findById(anyInt());
//    }
//
//    @Test
//    public void testRegisterCity() throws IOException {
//        MockMultipartFile imageFile = new MockMultipartFile("image", "image.jpg", "image/jpeg", "image content".getBytes());
//
//        RegisterCityRequest request = new RegisterCityRequest("Marrakech", imageFile, "A beautiful city", 4.5f);
//        when(cityRepository.saveAndFlush(any(City.class))).thenReturn(city);
//
//        City registeredCity = cityService.registerCity(request);
//
//        assertNotNull(registeredCity);
//        assertEquals("Marrakech", registeredCity.getName());
//        verify(cityRepository, times(1)).saveAndFlush(any(City.class));
//    }
//
//    @Test
//    public void testGetImage() throws IOException {
//        byte[] imageBytes = new byte[]{1, 2, 3, 4};
//        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/13/Ensias2.jpg";
//
//        byte[] result = cityService.getImage(imageUrl);
//
//        assertNotNull(result);
//    }
//
//    @Test
//    public void testUpdateCity() throws IOException {
//        MockMultipartFile imageFile = new MockMultipartFile("image", "newImage.jpg", "image/jpeg", "new image content".getBytes());
//
//        UpdateCityRequest request = new UpdateCityRequest("New Marrakech", imageFile, "A modern city", 4.8f);
//        when(cityRepository.findById(anyInt())).thenReturn(Optional.of(city));
//        when(cityRepository.save(any(City.class))).thenReturn(city);
//
//        City updatedCity = cityService.updateCity(1, request);
//
//        assertNotNull(updatedCity);
//        assertEquals("New Marrakech", updatedCity.getName());
//        assertEquals(4.8f, updatedCity.getRating());
//        verify(cityRepository, times(1)).findById(anyInt());
//        verify(cityRepository, times(1)).save(any(City.class));
//    }
//
//    @Test
//    public void testDeleteCity() {
//        doNothing().when(cityRepository).deleteById(anyInt());
//
//        cityService.deleteCity(1);
//
//        verify(cityRepository, times(1)).deleteById(anyInt());
//    }
//}
