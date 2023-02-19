package org.example.task3;

public class Person implements Alive, Cargo {
    private String name;
    private double weight;
    private Cargo cargo;
    private Status status;
    private String action;

    public Person(String name, double weight, Status status) {
        this.name = name;
        this.weight = weight;
        this.status = status;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        System.out.println("Now " + name + "has a cargo -> " + cargo.getName());
        this.cargo = cargo;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        if (this.status != null && this.status == Status.DEAD) {
            System.out.println(name + "can't change status because it's dead");
            return;
        }
        switch (status) {
            case SLEEP:
                System.out.println("Now " + name + " is sleeping");
                action = name + " is sleeping";
                break;
            case CONFUSED:
                System.out.println("Now " + name + " is confused");
                action = name + " is confused";
                break;
            case DEAD:
                System.out.println(name + " is dead. press F");
                action = name + "is dead";
                break;
        }
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        if (status != null) {
            switch (status) {
                case DEAD:
                case CONFUSED:
                case HARD_SICK:
                case SLEEP:
                    System.out.println(name + " in bad condition for changing action");
                    break;
                default:
                    this.action = action;
            }
        } else {
            System.out.println("status of " + name + " must be not null");
        }
    }
}
