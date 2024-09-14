package com.mycompany.app.utils.answerHandler;

import java.util.function.Supplier;

public enum AnswerEnum {

    NOANS(() -> AnswerHandler.noAns()),
    TRUE(() -> AnswerHandler.onTrue()),
    FALSE(() -> AnswerHandler.onFalse());

    /**
     * Azione.
     */
    private Supplier<String> action;

    /**
     * Costruttore.
     * @param action azione da eseguire
     */
    AnswerEnum(final Supplier<String> action) {
        this.action = action;
    }

    /**
     * Esegue il metodo inserito nella enum.
     */
    public String execute() {
        return action.get();
    }
}
