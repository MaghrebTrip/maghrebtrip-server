package com.maghrebtrip.feedback;

import com.maghrebtrip.feedback.dto.FeedbackResponse;
import com.maghrebtrip.feedback.dto.RegisterFeedbackRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/feedbacks/")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping("all")
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("attractionType={attractionType}&attractionId={attractionId}")
    public List<FeedbackResponse> getFeedbacksOfAttraction(@PathVariable("attractionId") Integer attractionId, @PathVariable("attractionType") String attractionType) {
        return feedbackService.getFeedbacksOfAttraction(attractionId, attractionType);
    }

    @PostMapping("new")
    public Feedback registerFeedback(@RequestBody RegisterFeedbackRequest registerFeedbackRequest) {
        return feedbackService.registerFeedback(registerFeedbackRequest);
    }

    @PutMapping("update/id={id}")
    public Feedback updateFeedback(@PathVariable("id") Integer id, @RequestBody RegisterFeedbackRequest registerFeedbackRequest) {
        return feedbackService.updateFeedback(id, registerFeedbackRequest);
    }

    @DeleteMapping("delete/id={id}")
    public void deleteFeedback(@PathVariable("id") Integer id) {
        feedbackService.deleteFeedback(id);
    }

}
