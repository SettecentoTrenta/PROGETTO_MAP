package com.mycompany.app.utils.parser;

import com.mycompany.app.utils.answerHandler.AnswerEnum;
import com.mycompany.app.utils.commands.EnumCommands;

/**
 * Parse user input.
 */
public final class Parser {
    
    /**
     * Parse user input.
     * @param userInput
     */
    public String parseInput(final String userInput) {
        EnumCommands commands = EnumCommands.fromString(userInput);
        AnswerEnum ans = AnswerEnum.NOANS;

        if (commands == EnumCommands.INVALID && ans != AnswerEnum.NOANS) {
            return "Comando non valido";
        } else if (userInput.equalsIgnoreCase("true")) {
            ans = AnswerEnum.TRUE;
            return ans.execute();
        } else if (userInput.equalsIgnoreCase("false")) {
            ans = AnswerEnum.FALSE;
            return ans.execute();
        } else {
            return commands.execute();
        }
    }

    /**
     * Get command.
     * @param userInput
     */
    public EnumCommands getCommand(final String userInput) {
        return EnumCommands.fromString(userInput);
    }
}
