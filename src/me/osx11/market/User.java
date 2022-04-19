package me.osx11.market;

public class User extends Client {
    private String templateReview = null;

    public User(String username, String name, String surname, String password) {
        super(username, name, surname, password, false);
    }

    public void setTemplateReview(String review) {
        this.templateReview = review;
    }

    public String getTemplateReview() {
        return this.templateReview;
    }

    public boolean hasTemplateReview() {
        return this.templateReview != null;
    }
}
