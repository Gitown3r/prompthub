package com.vv.prompthub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prompts")
public class Prompt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 1000)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String promptText;

    private String aiModel;

    private String tags;

    private String imageUrl;

    public Prompt(){} //constructor for Hibernate

    public Prompt(String title, String description, String promptText, String aiModel,
                  String tags, String imageUrl){
        this.title = title;
        this.description = description;
        this.promptText = promptText;
        this.aiModel = aiModel;
        this.tags = tags;
        this.imageUrl = imageUrl;
    }
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPromptText() { return promptText; }
    public void setPromptText(String promptText) { this.promptText = promptText; }

    public String getAiModel() { return aiModel; }
    public void setAiModel(String aiModel) { this.aiModel = aiModel; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
