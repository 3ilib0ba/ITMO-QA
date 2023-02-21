package org.example.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextModelTest {

    @Test
    public void toStringCheck() {
        final AirHamster airHamster = new AirHamster();
        final Person cargoPerson = new Person("Marta", 38, Status.NORMAL);
        final Person person = new Person("Billy", 80, Status.NORMAL);
        person.setAction("Default Action");
        person.setCargo(cargoPerson);

        final String expectedAirHamsterString = "AirHamster - name: Default AirHamster, status: Normal.";
        final String expectedCargoPersonString = "Person - name: Marta, weight: 38.0, status: Normal.";
        final String expectedPersonString = "Person - name: Billy, weight: 80.0, status: Normal, cargo: "
                + expectedCargoPersonString + ", action: Default Action.";

        Assertions.assertEquals(airHamster.toString(), expectedAirHamsterString);
        Assertions.assertEquals(person.toString(), expectedPersonString);
        Assertions.assertEquals(cargoPerson.toString(), expectedCargoPersonString);
    }

    @Test
    public void checkSetIncorrectNullValues() {
        final AirHamster airHamster = new AirHamster();
        final Person person = new Person("Billy", 80, Status.NORMAL);

        airHamster.setName(null);
        airHamster.setStatus(null);
        person.setName(null);

        Assertions.assertNotNull(airHamster.getName());
        Assertions.assertNotNull(airHamster.getStatus());
        Assertions.assertNotNull(person.getName());
    }

    @Test
    public void checkDeadObjectSetStatus() {
        final Person person = new Person("Marta", 50, Status.DEAD);
        final AirHamster airHamster = new AirHamster();
        airHamster.setStatus(Status.DEAD);

        person.setStatus(Status.NORMAL);
        airHamster.setStatus(Status.NORMAL);

        Assertions.assertEquals(person.getStatus(), Status.DEAD);
        Assertions.assertEquals(airHamster.getStatus(), Status.DEAD);
    }

    @Test
    public void checkCannotSetPersonAction() {
        final Person personDead = new Person("Marta", 50, Status.DEAD);
        final Person personConfused = new Person("Billy", 80, Status.CONFUSED);
        final Person personHardSick = new Person("Naruto", 74, Status.HARD_SICK);
        final Person personSleep = new Person("Shin", 45, Status.SLEEP);

        personDead.setAction("Do something");
        personConfused.setAction("Do something");
        personHardSick.setAction("Do something");
        personSleep.setAction("Do something");

        final String expectedActionDead = "Marta is dead";
        final String expectedActionConfused = "Billy is confused";
        final String expectedActionSleep = "Shin is sleeping";

        Assertions.assertEquals(personDead.getAction(), expectedActionDead);
        Assertions.assertEquals(personConfused.getAction(), expectedActionConfused);
        Assertions.assertNull(personHardSick.getAction());
        Assertions.assertEquals(personSleep.getAction(), expectedActionSleep);
    }

    @Test
    public void checkSetTooHeavyPersonCargo() {
        final Person person = new Person("Marta", 50, Status.NORMAL);
        final Person cargoPerson = new Person("Billy", 80, Status.NORMAL);

        person.setCargo(cargoPerson);

        Assertions.assertNull(person.getCargo());
    }

    @Test
    public void checkSetIncorrectPersonWeight() {
        final Person person1 = new Person("Marta", 50, Status.NORMAL);
        final Person person2 = new Person("Billy", 80, Status.NORMAL);

        person1.setWeight(-5);
        person2.setWeight(0);

        Assertions.assertEquals(person1.getWeight(), 50);
        Assertions.assertEquals(person2.getWeight(), 80);
    }

    @Test
    public void checkDoAirHamsterHypnosisToDeadPerson() {
        final AirHamster airHamster = new AirHamster();
        final Person personDead = new Person("Marta", 50, Status.DEAD);

        airHamster.doHypnosis(personDead);

        Assertions.assertEquals(personDead.getStatus(), Status.DEAD);
    }

    @Test
    public void checkDoAirHamsterHypnosis() {
        final AirHamster airHamster = new AirHamster();
        final Person personDead = new Person("Marta", 50, Status.NORMAL);

        airHamster.doHypnosis(personDead);

        Assertions.assertEquals(personDead.getStatus(), Status.CONFUSED);
    }

    @Test
    public void checkSetAirHamsterStatus() {
        final AirHamster airHamsterToSleep = new AirHamster("Billy");
        final AirHamster airHamsterToBeConfused = new AirHamster("Jhon");
        final AirHamster airHamsterToBeDead = new AirHamster("Mike");
        final AirHamster airHamsterToBeSick = new AirHamster("Marta");
        final AirHamster airHamsterToBeHardSick = new AirHamster("Liza");
        final AirHamster airHamsterToBeNormal = new AirHamster("Lola");

        airHamsterToSleep.setStatus(Status.SLEEP);
        airHamsterToBeConfused.setStatus(Status.CONFUSED);
        airHamsterToBeDead.setStatus(Status.DEAD);
        airHamsterToBeSick.setStatus(Status.SICK);
        airHamsterToBeHardSick.setStatus(Status.HARD_SICK);
        airHamsterToBeNormal.setStatus(Status.NORMAL);

        Assertions.assertEquals(airHamsterToSleep.getStatus(), Status.SLEEP);
        Assertions.assertEquals(airHamsterToBeConfused.getStatus(), Status.CONFUSED);
        Assertions.assertEquals(airHamsterToBeDead.getStatus(), Status.DEAD);
        Assertions.assertEquals(airHamsterToBeSick.getStatus(), Status.SICK);
        Assertions.assertEquals(airHamsterToBeHardSick.getStatus(), Status.HARD_SICK);
        Assertions.assertEquals(airHamsterToBeNormal.getStatus(), Status.NORMAL);
    }

}
