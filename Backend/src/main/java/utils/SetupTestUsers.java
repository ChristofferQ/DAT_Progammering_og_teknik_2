package utils;


import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords


    User user = new User("user", "1234");
    User admin = new User("admin", "12345");
    User both = new User("user_admin", "1234");

    Race race1 = new Race(1, "RaceName1", "RaceDate1", "RaceTime1","RaceLocation1");
    Race race2 = new Race(1, "RaceName2", "RaceDate2", "RaceTime2","RaceLocation2");

    Car car1 = new Car(1,"CarName1","CarBrand1","CarMake1","CarYear1");
    Car car2 = new Car(2,"CarName2","CarBrand2","CarMake2","CarYear2");

    Driver driver1 = new Driver (1,"DriverName1","DriverBirthYear1","DriverGender1");
    Driver driver2 = new Driver (2,"DriverName2","DriverBirthYear2","DriverGender2");





    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");


    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.persist(race1);
    em.persist(race2);
    em.persist(car1);
    em.persist(car2);
    em.persist(driver1);
    em.persist(driver2);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    System.out.println("Created 4 movies in database for test");


  }

}
