package uk.co.kleversom.screenmatch.model;

public enum Category {
    ACTION("Action"),
    ROMANCE("Romance"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    ADVENTURE("Adventure"),
    CRIME("Crime");

    private String categoryOmdb;

    Category(String categoryOmdb){
        this.categoryOmdb = categoryOmdb;
    }
    public static Category fromString(String text) {
        for (Category category : Category.values()) {
            if (category.categoryOmdb.equalsIgnoreCase(text)) {
                return category;
            }
        }
        throw new IllegalArgumentException("No categorys found to the String provided: " + text);
    }
}
