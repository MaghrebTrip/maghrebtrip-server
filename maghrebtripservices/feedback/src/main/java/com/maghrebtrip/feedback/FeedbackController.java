package com.maghrebtrip.feedback;

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

    @PostMapping("new")
    public ResponseEntity<String> registerFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        feedbackService.registerFeedback(feedbackRequest);
        return ResponseEntity.ok("Feedback registred");
    }

    @PutMapping("update/id={id}")
    public void updateFeedback(@PathVariable("id") Integer id, @RequestBody FeedbackRequest feedbackRequest) {
        feedbackService.updateFeedback(id, feedbackRequest);
    }

    @DeleteMapping("delete/id={id}")
    public void deleteFeedback(@PathVariable("id") Integer id) {
        feedbackService.deleteFeedback(id);
    }

}
