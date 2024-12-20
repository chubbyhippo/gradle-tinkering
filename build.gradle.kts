tasks.register("curl") {

    exec {
        commandLine("curl", "https://gradle.org/")
        standardOutput = System.out
    }
}