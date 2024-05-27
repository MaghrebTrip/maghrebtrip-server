package com.maghrebtrip.feedback;

import com.maghrebtrip.clients.tourist.TouristClient;
import com.maghrebtrip.clients.tourist.dto.GetTouristResponse;
import com.maghrebtrip.feedback.dto.AttractionInfo;
import com.maghrebtrip.feedback.dto.FeedbackResponse;
import com.maghrebtrip.feedback.dto.FeedbackResponseProjection;
import com.maghrebtrip.feedback.dto.RegisterFeedbackRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final TouristClient touristClient;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public List<FeedbackResponse> getFeedbacksOfAttraction(Integer attractionId, String attractionType) {
        List<Feedback> feedbacks = feedbackRepository.findAllByAttractionIdAndAttractionType(attractionId, attractionType);
        List<FeedbackResponse> feedbackResponses = new ArrayList<>();
        feedbacks.forEach(feedback -> {
            GetTouristResponse touristResponse =  touristClient.getTouristById(feedback.getTouristId());
            FeedbackResponse feedbackResponse;
            feedbackResponse = FeedbackResponse.builder()
                    .id(feedback.getId())
                    .touristFirstName(touristResponse.getFirstName())
                    .touristLastName(touristResponse.getLastName())
                    .rating(feedback.getRating())
                    .comment(feedback.getComment())
                    .date(feedback.getDate())
                    .build();
            feedbackResponses.add(feedbackResponse);
        });
        return feedbackResponses;
    }

    public List<Feedback> getFeedbackOfTourist(Integer touristId) {
        return feedbackRepository.findAllByTouristId(touristId);

    }

    public void registerFeedback(RegisterFeedbackRequest request) {
        Feedback feedback = Feedback.builder()
                .touristId(request.touristId())
                .attractionId(request.attractionId())
                .attractionType(request.attractionType())
                .rating(request.rating())
                .comment(request.comment())
                .date(LocalDateTime.now())
                .build();
        feedbackRepository.save(feedback);
    }

    public void updateFeedback(Integer id, RegisterFeedbackRequest request) {
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
