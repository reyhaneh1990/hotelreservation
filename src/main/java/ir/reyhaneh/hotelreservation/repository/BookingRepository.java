package ir.reyhaneh.hotelreservation.repository;

import ir.reyhaneh.hotelreservation.model.Bookings;
import ir.reyhaneh.hotelreservation.model.Customers;
import ir.reyhaneh.hotelreservation.model.Payments;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

    private static final EntityManagerFactory INSTANCE = Persistence.createEntityManagerFactory("DotinPortalPU");

    public static EntityManagerFactory getInstance() {
        return INSTANCE;
    }

    @Transactional
    public void save(Customers customers, Bookings bookings, Payments payments) {
        EntityManager em = null;

        try {
            em = getInstance().createEntityManager();
            em.getTransaction().begin();

            if (customers.getId() == null) {
                em.persist(customers);
            }

            bookings.setCustomers(customers);
            em.persist(bookings);

            payments.setBookings(bookings);
            em.persist(payments);


            em.getTransaction().commit();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
