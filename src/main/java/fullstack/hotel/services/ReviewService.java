package fullstack.hotel.services;

import fullstack.hotel.model.entity.Review;
import fullstack.hotel.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }


}
