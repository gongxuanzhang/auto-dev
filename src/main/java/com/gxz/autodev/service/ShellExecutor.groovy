class ShellExecutor {

    String sayHello(String shell) {
        return shell.execute().text
    }

}

