package me.osx11.market;

public class User extends Client {
    private String templateReview = null;

    public User(String username, String name, String surname, String password) {
        super(username, name, surname, password, false);
    }

    /**
     * Template review is the first review the user submitted. If the user wants to submit another review for another
     * (or even the same) product, their review will be compared to the template review using levenstein distance
     * algorithm in order to identify if it is fake or not.
     *
     * @param review review to be used as a template
     */
    public void setTemplateReview(String review) {
        this.templateReview = review;
    }

    /**
     * Returns the template review
     *
     * @return template review
     */
    public String getTemplateReview() {
        return this.templateReview;
    }

    /**
     * Checks if the template review exists
     *
     * @return true if template review exists, otherwise false
     */
    public boolean hasTemplateReview() {
        return this.templateReview != null;
    }
}
