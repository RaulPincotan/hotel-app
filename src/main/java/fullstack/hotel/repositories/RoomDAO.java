package fullstack.hotel.repositories;

import fullstack.hotel.model.RoomFilters;
import fullstack.hotel.model.entity.Room;
import fullstack.hotel.model.entity.RoomFacilities;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomDAO {

    private final EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public RoomDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public List<Room> getAll(RoomFilters filters) {
        CriteriaQuery<Room> criteria = criteriaBuilder.createQuery(Room.class);
        Root<Room> roomRoot = criteria.from(Room.class);
        Join<Room, RoomFacilities> roomFacilitiesJoin = roomRoot.join("roomFacilities");

        List<Predicate> whereClause = getBuildedClauses(filters, roomRoot, roomFacilitiesJoin);

        CriteriaQuery<Room> query = criteria.select(roomRoot).where(whereClause.toArray(whereClause.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }

    private List<Predicate> getBuildedClauses(RoomFilters filters, Root<Room> roomRoot, Join<Room, RoomFacilities> roomFacilitiesJoin) {
        List<Predicate> clauses = new ArrayList<>();
        Optional.ofNullable(filters.getFloor())
                .ifPresent(floor -> clauses.add(criteriaBuilder.equal(roomRoot.get("floor"), floor)));

        Optional.ofNullable(filters.getHotel())
                .ifPresent(name -> clauses.add(criteriaBuilder.equal(roomRoot.get("hotelName"), name)));

//         Optional.ofNullable(filters.getRating())
//                 .ifPresent(rating->clauses.add(criteriaBuilder.greaterThan(roomReviewJoin.get("rating"),rating)));

        Optional.ofNullable(filters.getDoubleBed())
                .ifPresent(doubleBed->clauses.add(criteriaBuilder.equal(roomFacilitiesJoin.get("doubleBed"),doubleBed)));

        Optional.ofNullable(filters.getTv())
                .ifPresent(tv->clauses.add(criteriaBuilder.equal(roomFacilitiesJoin.get("tv"),tv)));
        return new ArrayList<>(clauses);
    }
}
