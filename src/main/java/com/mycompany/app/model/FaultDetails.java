package com.mycompany.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * FaultDetails class.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class FaultDetails {

    /**
     * Type.
     */
    private String type;

    /**
     * Difficulty.
     */
    private String difficulty;

    /**
     * Category.
     */
    private String category;

    /**
     * Question.
     */
    private String question;


    /**
     * Correct answer.
     */
    @JsonProperty("correct_answer")
    private String correctAnswer;

    /**
     * Incorrect answers.
     */
    @JsonProperty("incorrect_answers")
    private String[] incorrectAnswers;

    /**
     * Hint.
     */
    private String hint;

    /**
     * Get correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Set correct answer.
     * @param correctAnswerParam correct answer
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Get type.
     */
    public String getType() {
        return type;
    }

    /**
     * Set type.
     * @param typeParam type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get difficulty.
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Set difficulty.
     * @param difficultyParam difficulty
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Get category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set category.
     * @param categoryParam category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set question.
     * @param questionParam question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Get incorrect answers.
     */
    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    /**
     * Set incorrect answers.
     * @param incorrectAnswersParam incorrect answers
     */
    public void setIncorrectAnswers(String[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    /**
     * Get hint.
     */
    public String getHint() {
        return hint;
    }

    /**
     * Set hint.
     * @param hintParam hint
     */
    public void setHint(String hint) {
        this.hint = hint;
    }
}
