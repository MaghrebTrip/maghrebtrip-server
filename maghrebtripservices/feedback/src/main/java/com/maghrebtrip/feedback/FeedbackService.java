package com.maghrebtrip.feedback;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public void registerFeedback(FeedbackRequest request) {
        Feedback feedback = Feedback.builder()
                .touristId(request.touristId())
                .rating(request.rating())
                .comment(request.comment())
                .date(LocalDateTime.now())
                .build();
        feedbackRepository.save(feedback);
    }

    public void updateFeedback(Integer id, FeedbackRequest request) {
        Feedback feedback = feedbackRepository.findById(id).get();
        feedback.setTouristId(request.touristId());
        feedback.setRating(request.rating());
        feedback.setComment(request.comment());
        feedback.setDate(LocalDateTime.now());
        feedback.setEdited(true);
        feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Integer id) {
        feedbackRepository.deleteById(id);
    }

}
