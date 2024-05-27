//import com.maghrebtrip.feedback.Feedback;
//import com.maghrebtrip.feedback.FeedbackRepository;
//import com.maghrebtrip.feedback.requests.FeedbackRequest;
//import com.maghrebtrip.feedback.FeedbackService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class FeedbackServiceTest {
//
//    @Mock
//    private FeedbackRepository feedbackRepository;
//
//    @InjectMocks
//    private FeedbackService feedbackService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetAllFeedbacks() {
//        Feedback feedback1 = new Feedback(1, 1, 5, "1","Great experience!", LocalDateTime.now(), false);
//        Feedback feedback2 = new Feedback(2, 2, 4, "2", "Good tour!", LocalDateTime.now(), false);
//
//        when(feedbackRepository.findAll()).thenReturn(Arrays.asList(feedback1, feedback2));
//
//        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
//
//        assertEquals(2, feedbacks.size());
//        verify(feedbackRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testRegisterFeedback() {
//        FeedbackRequest request = new FeedbackRequest(1, 5, "3.4", "Great experience!");
//        Feedback feedback = Feedback.builder()
//                .touristId(request.touristId())
//                .rating(request.rating())
//                .comment(request.comment())
//                .date(LocalDateTime.now())
//                .build();
//
//        feedbackService.registerFeedback(request);
//
//        verify(feedbackRepository, times(1)).save(any(Feedback.class));
//    }
//
//    @Test
//    public void testUpdateFeedback() {
//        FeedbackRequest request = new FeedbackRequest(1, 5, "4.5", "Test feedback");
//        Feedback existingFeedback = new Feedback(1, 1, 4, "4.5", "Good tour", LocalDateTime.now(), false);
//
//        when(feedbackRepository.findById(1)).thenReturn(Optional.of(existingFeedback));
//
//        feedbackService.updateFeedback(1, request);
//
//        verify(feedbackRepository, times(1)).save(any(Feedback.class));
//        assertEquals("Updated comment", existingFeedback.getComment());
//        assertEquals(5, existingFeedback.getRating());
//        assertEquals(true, existingFeedback.isEdited());
//    }
//
//    @Test
//    public void testDeleteFeedback() {
//        feedbackService.deleteFeedback(1);
//
//        verify(feedbackRepository, times(1)).deleteById(1);
//    }
//}
