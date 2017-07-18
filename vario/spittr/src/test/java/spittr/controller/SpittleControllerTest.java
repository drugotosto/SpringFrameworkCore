//package spittr.controller;
//
//
//import org.junit.Test;
//import spittr.model.Spittle;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.servlet.view.InternalResourceView;
//import spittr.service.SpittleService;
//
//import static org.hamcrest.core.IsCollectionContaining.hasItems;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
//
//import static org.mockito.Mockito.*;
///**
// * Created by drugo on 18/05/2017.
// */
//
//public class SpittleControllerTest {
//
//    @Test
//    public void shouldShowRecentSpittles() throws Exception {
//        List<Spittle> expectedSpittles = createSpittleList(10);
//        SpittleService mockService = mock(SpittleService.class);
//        when(mockService.getRecentSpittles()).thenReturn(expectedSpittles);
//
//        SpittleController controller = new SpittleController(mockService);
//        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
//        mockMvc.perform(get("/spittles"))
//                .andExpect(view().name( "spittles"))
//                .andExpect(model().attributeExists("spittleList"));
////                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
//    }
//
//    @Test
//    public void shouldShowPagedSpittles() throws Exception {
//        List<Spittle> expectedSpittles = createSpittleList(50);
//        SpittleService mockService = mock(SpittleService.class);
//        when(mockService.trovaSpittles(238900, 50)).thenReturn(expectedSpittles);
//
//        SpittleController controller = new SpittleController(mockService);
//        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
//        mockMvc.perform(get("/spittles?max=238900&count=50"))
//                .andExpect(view().name("spittles"))
//                .andExpect(model().attributeExists("spittleList"))
//                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
//    }
//
//    @Test
//    public void testSpittle() throws Exception {
//        Spittle expectedSpittle = new Spittle("Hello", new Date());
//        SpittleService mockService= mock(SpittleService.class);
//        when(mockService.trovaSpittle(12345)).thenReturn(expectedSpittle);
//
//        SpittleController controller = new SpittleController(mockService);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//        mockMvc.perform(get("/spittles/12345"))
//                .andExpect(view().name("spittle"))
//                .andExpect(model().attributeExists("spittle"))
//                .andExpect(model().attribute("spittle", expectedSpittle));
//    }
//
//    private List<Spittle> createSpittleList(int count) {
//        List<Spittle> spittles = new ArrayList<Spittle>();
//        for (int i = 0; i < count; i++) {
//            spittles.add(new Spittle("Spittle " + i, new Date()));
//        }
//        return spittles;
//    }
//}