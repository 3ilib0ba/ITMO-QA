package org.example.task3;

public class AirHamster implements Flying, Alive {
    private Status status;
    private String name;

    public AirHamster() {
        name = "Default AirHamster";
        status = Status.NORMAL;
    }

    public AirHamster(String name) {
        this();
        setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) return;
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        if (status == null) return;
        if (this.status == Status.DEAD) {
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
            case SICK:
                System.out.println("Now " + getName() + " is sick");
                break;
            case HARD_SICK:
                System.out.println("Now " + getName() + " is hard sick");
                break;
            case NORMAL:
                System.out.println("Now " + getName() + " is normal");
                break;
        }
        this.status = status;
    }

    public void doHypnosis(Alive goal) {
        if (goal == null) return;
        if (goal.getStatus() == Status.DEAD) {
            System.out.println(getName() + " can't hypnosis a dead creature");
            return;
        }
        goal.setStatus(Status.CONFUSED);
        System.out.println(getName() + " change status of " + goal.getName() + " now it's confused");
    }

    @Override
    public String toString(){
        return "AirHamster - name: " + this.getName() + ", status: " + this.getStatus().toString() + ".";
    }

}
