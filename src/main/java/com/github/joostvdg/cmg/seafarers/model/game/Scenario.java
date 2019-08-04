package com.github.joostvdg.cmg.seafarers.model.game;

public class Scenario {

  private final String name;
  private final String description;
  private final String code;
  private final String author;

  private Scenario(Builder builder) {
    name = builder.name;
    description = builder.description;
    code = builder.code;
    author = builder.author;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getCode() {
    return code;
  }

  public String getAuthor() {
    return author;
  }

  public static final class Builder {
    private String name;
    private String description;
    private String code;
    private String author;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public Builder author(String author) {
      this.author = author;
      return this;
    }

    public Scenario build() {
      return new Scenario(this);
    }
  }
}
