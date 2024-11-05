package com.excel.project.library_management_system.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;

import com.excel.project.library_management_system.entity.AccountDetails;
import com.excel.project.library_management_system.entity.Analytics;
import com.excel.project.library_management_system.entity.CirculationTransaction;
import com.excel.project.library_management_system.entity.HoldRequests;
import com.excel.project.library_management_system.entity.Materials;
import com.excel.project.library_management_system.entity.Notification;
import com.excel.project.library_management_system.entity.User;

public class MainRunner {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("library");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        
        // user objs
        
        User user1 = new User();
        user1.setUsername("Sachin");
        user1.setEmail("sachin@example.com");
        user1.setPasswordHash("password1");
        user1.setIsPatron(true);
        user1.setIsLibrarian(false);
        user1.setCreatedAt(new java.util.Date());
        
        User user2 = new User();
        user2.setUsername("Akash");
        user2.setEmail("akash@example.com");
        user2.setPasswordHash("password2");
        user2.setIsPatron(true);
        user2.setIsLibrarian(false);
        user2.setCreatedAt(new java.util.Date());
        
        // materials objs
        
        Materials material1 = new Materials();
        material1.setTitle("Psychology of money");
        material1.setAuthor("Morgan Housel");
        material1.setCategory("NON FICTION / SELF HELP");
        material1.setDescription("The psychology of money is the study of our behavior with money");
        material1.setIsbn("ISBN-1");
        material1.setPublicationYear(2020);
        material1.setTotalCopies(5);
        material1.setAvailableCopies(5);

        Materials material2 = new Materials();
        material2.setTitle("ikigai");
        material2.setAuthor("Héctor García and Francesc Miralles");
        material2.setCategory("Self-help book");
        material2.setDescription("Ikigai (ee-key-guy) is a Japanese concept that combines the terms iki, meaning “alive” or “life,” and gai, meaning “benefit” or “worth.” When combined, these terms mean that which gives your life worth, meaning, or purpose.");
        material2.setIsbn("ISBN-2");
        material2.setPublicationYear(2016);
        material2.setTotalCopies(3);
        material2.setAvailableCopies(3);
        
        
        // circulation transaction objs

        CirculationTransaction transaction1 = new CirculationTransaction();
        transaction1.setUser(user1);
        transaction1.setMaterial(material1);
        transaction1.setTransactionType("Checkout");
        transaction1.setTransactionDate(new java.util.Date());
        transaction1.setDueDate(new java.util.Date());
        transaction1.setReturnDate(null);
        transaction1.setReturned(false);
        transaction1.setRenewed(false);

        CirculationTransaction transaction2 = new CirculationTransaction();
        transaction2.setUser(user2);
        transaction2.setMaterial(material2);
        transaction2.setTransactionType("Checkout");
        transaction2.setTransactionDate(new java.util.Date());
        transaction2.setDueDate(new java.util.Date());
        transaction2.setReturnDate(null);
        transaction2.setReturned(false);
        transaction2.setRenewed(false);
        
        // account details objs
        
        AccountDetails account1 = new AccountDetails();
        account1.setUser(user1);
        account1.setAddress("Talakadu");
        account1.setPhone("1234567890");
        account1.setFineAmount(0.0);
        account1.setFinePaidStatus(false);
        
        AccountDetails account2 = new AccountDetails();
        account2.setUser(user2);
        account2.setAddress("Mysore");
        account2.setPhone("9876543210");
        account2.setFineAmount(0.0);
        account2.setFinePaidStatus(false);
        
        // hold request objs

        HoldRequests holdRequest1 = new HoldRequests();
        holdRequest1.setUser(user1);
        holdRequest1.setMaterial(material1);
        holdRequest1.setRequestDate(new Date());
        holdRequest1.setPickupReady(false);

        HoldRequests holdRequest2 = new HoldRequests();
        holdRequest2.setUser(user2);
        holdRequest2.setMaterial(material2);
        holdRequest2.setRequestDate(new Date());
        holdRequest2.setPickupReady(true);
        
        // notification objs
        
        Notification notification1 = new Notification();
        notification1.setUser(user1);
        notification1.setNotificationType("Due Date Reminder");
        notification1.setMessage("Your due date is approaching. Please return the book soon.");
        notification1.setSentDatetime(new Date());
        notification1.setRead(false);

        Notification notification2 = new Notification();
        notification2.setUser(user2);
        notification2.setNotificationType("Hold Pickup Notice");
        notification2.setMessage("Your held book is ready for pickup.");
        notification2.setSentDatetime(new Date());
        notification2.setRead(false);
        
        // analytics objs

        Analytics analytics1 = new Analytics();
        analytics1.setEventType("Checkout");
        analytics1.setUser(user1);
        analytics1.setMaterial(material1);

        Analytics analytics2 = new Analytics();
        analytics2.setEventType("Return");
        analytics2.setUser(user2);
        analytics2.setMaterial(material2);

        
        transaction.begin();
        
        // user transactions
        
        manager.persist(user1);
        manager.persist(user2);
        
        // material transactions
        
        manager.persist(material1);
        manager.persist(material2);
        
        // circulation transaction
        
        manager.persist(transaction1);
        manager.persist(transaction2);
        
        // account details transactions
        
        manager.persist(account1);
        manager.persist(account2);
        
        // hold request transactions
        
        manager.persist(holdRequest1);
        manager.persist(holdRequest2);
        
        // notifications transactions
        
        manager.persist(notification1);
        manager.persist(notification2);
        
        // analytics transactions
        
        manager.persist(analytics1);
        manager.persist(analytics2);
        
        transaction.commit();
        manager.close();
    }
}
