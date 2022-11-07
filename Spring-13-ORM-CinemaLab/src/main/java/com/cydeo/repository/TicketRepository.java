package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);
    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id = ?1 ")
    List<Ticket> retrieveAllByUser(@Param("userId") Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchAllBetweenDateTimeRange(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT COUNT(*) FROM t ticket JOIN ua user_account ON " +
            "t.user_account_id = ua.id WHERE ua.id = ?1", nativeQuery = true)
    Integer countByUserId(@Param("userId") Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(*) FROM t ticket JOIN ua user_account ON " +
            "t.user_account_id = ua.id WHERE ua.id = ?1 AND date_time BETWEEN ?1 AND ?2", nativeQuery = true)
    Integer countByUserIdInDateRange
    (@Param("userId") Long userId, @Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT * FROM t ticket JOIN mc moviecinema ON" +
            "t.movie_cinema_id = mc.id JOIN m movie ON mc.movie_id = m.id WHERE " +
            "m.name = :name", nativeQuery = true)
    List<Ticket> fetchByMovieName(@Param("name") String name);
    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM t ticket JOIN ua user_account ON" +
            "t.user_account_id = ua.id WHERE ua.email = ?1", nativeQuery = true)
    List<Ticket> findAllByUserEmail(@Param("email") String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> retrieveAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT * FROM t ticket JOIN ua user_account ON " +
            "t.user_account_id = ua.id JOIN ad account_details ON " +
            "ua.account_details_id = ad.id JOIN mc movie_cinema ON " +
            "t.movie_cinema_id = mc.id JOIN m movie ON " +
            "mc.movie_id = m.id WHERE ua.username ILIKE concat ('%', :username, '%')" +
            "AND ad.name ILIKE concat ('%', :name, '%')" +
            "AND m.name ILIKE concat ('%', :movieName, '%')", nativeQuery = true)
    List<Ticket> fetchAllByGiven(@Param("username") String username,
                                 @Param("name") String name,
                                 @Param("movieName") String movieName);

}
