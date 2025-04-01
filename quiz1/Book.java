package quiz1;

public class Book {
    private String title;
    private String author;
    private String[] reviewers;
    private int[] ratings;
    private String[] comments;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.reviewers = new String[0];
        this.ratings = new int[0];
        this.comments = new String[0];

    }

    public Book(String title, String author, String[] reviewers, int[] ratings, String[] comments) {
        if (!isValid(reviewers, ratings, comments)) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.author = author;
        this.ratings = ratings;
        this.reviewers = reviewers;
        this.ratings = ratings;
        this.comments = comments;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String[] getReviewers() {
        return this.reviewers;
    }

    public int[] getRating() {
        return this.ratings;
    }

    public String[] getComments() {
        return this.comments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private boolean isValid(String[] reviewers, int[] ratings, String[] comments) {
        return (reviewers.length == ratings.length && reviewers.length == comments.length
                && ratings.length == comments.length);
    }

    public void setNewReview(String[] reviewers, int[] ratings, String[] comments) {
        if (!isValid(reviewers, ratings, comments)) {
            throw new IllegalArgumentException();
        }
        this.reviewers = reviewers;
        this.ratings = ratings;
        this.comments = comments;
    }

    public void addReview(String reviewers, int ratings, String comments) {
        String[] newReviewers = new String[this.reviewers.length + 1];
        int[] newRatings = new int[this.ratings.length + 1];
        String[] newComments = new String[this.comments.length + 1];

        for (int i = 0; i < this.reviewers.length; i++) {
            newReviewers[i] = this.reviewers[i];
            newRatings[i] = this.ratings[i];
            newComments[i] = this.comments[i];
        }
        newReviewers[this.reviewers.length] = reviewers;
        newRatings[this.reviewers.length] = ratings;
        newComments[this.reviewers.length] = comments;

        this.reviewers = newReviewers;
        this.ratings = newRatings;
        this.comments = newComments;
    }

    public void editReview(String reviewers, int ratings,String comments){
        int reviewerIndex = -1;
        for (int i = 0; i < this.reviewers.length;i++){
            if (this.reviewers[i].equals(reviewers)) {
                reviewerIndex = i; 
                break;
        }
        if (reviewerIndex == -1){
            throw new IllegalArgumentException("user not found");
        }
        else{
            this.reviewers[reviewerIndex] = reviewers;
            this.ratings[reviewerIndex] = ratings;
            this.comments[reviewerIndex] = comments;
        }
    }

    public removeReview(String reviewers){
            int reviewerIndex = -1;
            for (int i = 0; i < this.reviewers.length;i++){
                if (this.reviewers[i].equals(reviewers)) {
                    reviewerIndex = i; 
                    break;
            }
            if (reviewerIndex == -1){
                throw new IllegalArgumentException("user not found");
                
            }
            else{
                String[] newReviewers = new String[this.reviewers.length-1];
                int[] newRatings = new int[this.ratings.length-1];
                String[] newComments = new String[this.comments.length-1];

                int fast = 0;
                int slow = 0;

                while (fast < this.ratings.length){
                    if (fast == reviewerIndex){
                        fast ++;
                        continue;
                    }
                    newReviewers[slow] = this.reviewers[fast];
                    newRatings[slow] = this.ratings[fast];
                    newComments[slow] = this.comments[fast];
                    fast ++;
                    slow ++;
                }
            }
            

        }

     
    }
}
