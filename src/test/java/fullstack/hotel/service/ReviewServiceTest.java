package fullstack.hotel.service;

import fullstack.hotel.model.entity.Review;
import fullstack.hotel.repositories.ReviewRepository;
import fullstack.hotel.services.ReviewService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;


    @Test
    void testGetAll() {
        List<Review> reviews = List.of(Review.builder().message("Clean room").touristName("Raul").build(),
                Review.builder().message("Great location ").touristName("Adrian").build());
        Mockito.when(reviewRepository.findAll()).thenReturn(reviews);

        List<Review> actualReviews = reviewService.getAll();

        Mockito.verify(reviewRepository, Mockito.times(1)).findAll();

        Assertions.assertThat(actualReviews).hasSize(2);
        Assertions.assertThat(actualReviews.get(0).getMessage()).isEqualTo("Clean room");
    }
}
