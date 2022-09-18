package com.manning.gia.todo;

import org.apache.commons.lang3.CharUtils;
import com.manning.gia.todo.utils.CommandLineInput;
import com.manning.gia.todo.utils.CommandLineInputHandler;

public class ToDoApp {

    public static final char DEFAULT_INPUT = '\u0000';

    public static char handleInput(String input) {
        return CharUtils.toChar(input, DEFAULT_INPUT);
    }

    public static void main(String args[]) {
        CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler();
        char command = DEFAULT_INPUT;

        while (CommandLineInput.EXIT.getShortCmd() != command) {
            commandLineInputHandler.printOptions();
            command = handleInput(commandLineInputHandler.readInput());
            CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);
            commandLineInputHandler.processInput(commandLineInput);
        }
    }
}