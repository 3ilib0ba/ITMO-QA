package org.example.task3;

public class Person implements Alive, Cargo {
    private String name;
    private double weight;
    private Cargo cargo;
    private Status status;
    private String action;

    public Person() {
        this.name = "Default Name";
        this.weight = 45;
        this.status = Status.NORMAL;
        this.action = null;
        this.cargo = null;
    }

    public Person(final String name, final double weight, final Status status) {
        this();
        setName(name);
        setWeight(weight);
        setStatus(status);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        if (name == null) {
            return;
        }
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(final double weight) {
        if (weight <= 0) {
            return;
        }
        this.weight = weight;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(final Cargo cargo) {
        if (cargo == null) {
            this.cargo = null;
            return;
        }
        if (cargo.getWeight() > this.weight / 2) {
            System.out.println(name + " cannot carry the cargo - " + cargo.getName() + " is to heavy");
            return;
        }
        System.out.println("Now " + name + "has a cargo -> " + cargo.getName());
        this.cargo = cargo;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(final Status status) {
        if (status == null) {
            return;
        }
        if (this.status == Status.DEAD) {
            System.out.println(name + " can't change status because it's dead");
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
                action = name + " is dead";
                break;
            case NORMAL:
                System.out.println(name + " is normal");
                break;
            case HARD_SICK:
                System.out.println(name + " is hard sick");
                break;
            case SICK:
                System.out.println(name + " is sick");
                break;
        }
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
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
    }

    public boolean haveCargo() {
        return this.getCargo() != null;
    }

    public boolean haveAction() {
        return this.getAction() != null;
    }

    @Override
    public String toString(){
        String str = "Person - name: " + this.getName() +
                ", weight: " + this.getWeight() + ", status: " + this.getStatus();
        if (haveCargo()) str += ", cargo: " + this.getCargo().toString();
        if (haveAction()) str += ", action: " + this.getAction();
        return str + ".";
    }
}
