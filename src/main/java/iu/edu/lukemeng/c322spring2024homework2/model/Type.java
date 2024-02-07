package iu.edu.lukemeng.c322spring2024homework2.model;

public enum Type {

    ACOUSTIC, ELECTRIC;

    public String toString() {
        return switch (this) {
            case ACOUSTIC -> "acoustic";
            case ELECTRIC -> "electric";
            default -> "unspecified";
        };
    }
}
