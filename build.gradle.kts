tasks.register("curl") {

    exec {
        commandLine("sh", "-c", "\"curl --help\"")
        standardOutput = System.out
    }
}