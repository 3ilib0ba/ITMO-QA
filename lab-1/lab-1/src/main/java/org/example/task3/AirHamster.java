package org.example.task3;

public class AirHamster implements Flying, Alive {
    private Status status;
    private String name;

    public AirHamster() {
        status = Status.NORMAL;
    }

    public AirHamster(String name) {
        this.name = name;
        status = Status.NORMAL;
    }

    public void hypnosis(Alive goal) {
        if (goal.getStatus() == Status.DEAD) {
            System.out.println(getName() + " can't hypnosis a dead creature");
            return;
        }
        goal.setStatus(Status.CONFUSED);
        System.out.println(getName() + " change status of " + goal.getName() + " now it's confused");
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        if (this.status != null && this.status == Status.DEAD) {
            System.out.println(getName() + "can't change status because it's dead");
            return;
        }
        switch (status) {
            case SLEEP:
                System.out.println("Now " + getName() + " is sleeping");
                break;
            case CONFUSED:
                System.out.println("Now " + getName() + " is confused");
                break;
            case DEAD:
                System.out.println(getName() + " is dead. press F");
                break;
        }
        this.status = status;
    }

    @Override
    public String getName() {
        if (name == null) {
            return "just an air hamster";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
