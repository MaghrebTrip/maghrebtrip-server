package com.maghrebtrip.feedback;

import com.maghrebtrip.feedback.dto.AttractionInfo;
import com.maghrebtrip.feedback.dto.FeedbackResponse;
import com.maghrebtrip.feedback.dto.FeedbackResponseProjection;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

//    @Transactional
//    @Query(value = "select " +
//            "tourist.firstName as touristFirstName, " +
//            "tourist.lastName as touristLastName, " +
//            "attraction.name as attractionName, " +
//            "feedback.rating as rating, " +
//            "feedback.comment as comment, " +
//            "feedback.date as date " +
//            "from ((feedback inner join tourist on feedback.touristId = tourist.id ) " +
//            "inner join attraction on feedback.attractionId = attraction.id) " +
//            "where feedback.attractionId = :attractionId "
//            , nativeQuery = true)

    List<Feedback> findAllByAttractionIdAndAttractionType(Integer attractionId, String attractionType);

//    @Transactional
//    @Query(value = "select " +
//            "tourist.firstName as touristFirstName, " +
//            "tourist.lastName as touristLastName, " +
//            "attraction.name as attractionName, " +
//            "feedback.rating as rating, " +
//            "feedback.comment as comment, " +
//            "feedback.date as date " +
//            "from ((feedback inner join tourist on feedback.touristId = tourist.id ) " +
//            "inner join attraction on feedback.attractionId = attraction.id) " +
//            "where feedback.touristId = :touristId "
//            , nativeQuery = true)

//    List<FeedbackResponseProjection> findAllByTouristId(Integer touristId);
    List<Feedback> findAllByTouristId(Integer touristId);
}
