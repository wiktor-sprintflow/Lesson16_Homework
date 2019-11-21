class Player {
    private String firstName;
    private String lastName;
    private int score;

    Player(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    String toCsv() {
        return firstName + ";" + lastName + ";" + score;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
