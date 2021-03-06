package com.ban.todo.cli;

import java.io.File;

import picocli.CommandLine;

public class Bootstrap {
    public static void main(final String[] args) {
        final File todoRepository = new File(todoHome(), "repository.json");
        ObjectFactory factory = new ObjectFactory();
        final CommandLine commandLine = factory.createCommandLine(todoRepository);
        commandLine.execute(args);
    }

    private static File todoHome() {
        final File homeDirectory = new File(System.getProperty("user.home"));
        final File todoHome = new File(homeDirectory, ".todo");
        if (!todoHome.exists()) {
            todoHome.mkdirs();
        }
        return todoHome;
    }
}