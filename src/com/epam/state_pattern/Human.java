package com.epam.state_pattern;

/**
 * Created by Asus on 26.05.2016.
 */
public class Human {

    private static final int MIN_AGE = 10;
    private static final int MAX_AGE = 100;
    public static final String NAME_PATTERN = "^[A-Za-z\\-']{2,30}$"; // Maria

    private String name;
    private Gender gender;
    private int age;
    private Hobby currentHobby;

    public Human(String name, Gender gender, int age, Hobby hobby) {
        checkName(name);
        checkAge(age);

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.currentHobby = hobby;
    }

    public enum Gender {
        MALE, FEMALE
    }

    public enum State {
        STAND_BY_RIVER, STAND_ON_MUSHROOM_GLADE, SEE_BEAST
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);

        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        checkAge(age);

        this.age = age;
    }

    public Hobby getCurrentHobby() {
        return currentHobby;
    }

    public void setCurrentHobby(Hobby hobby) {
        currentHobby = hobby;
    }

    public void doSomething() {
        currentHobby.doSomething();
    }

    public void chooseHobby(State state) {

        switch (state) {
            case STAND_BY_RIVER:
                setCurrentHobby(new Fisher());
                break;

            case STAND_ON_MUSHROOM_GLADE:
                setCurrentHobby(new Mushroomer());
                break;

            case SEE_BEAST:
                setCurrentHobby(new Hunter());
                break;

            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name=" + getName() +
                ", gender=" + getGender() +
                ", age=" + getAge() +
                '}';
    }

    private void checkName(String name) {
        if (!name.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException("Name should contain only letters, spaces, " +
                                                "apostrophes and hyphens.");
        }
    }

    private void checkAge(int age) {
        if ((age > MAX_AGE) || (age < MIN_AGE)) {
            throw new IllegalArgumentException("Age should be between " + MIN_AGE +
                                                " and " + MAX_AGE);
        }
    }
}
