tasks.register("sh") {
    description = "Executes a shell command"
    group = "Custom"
    val commands = project.findProperty("commands") as String?
    exec {
        commandLine("sh", "-c", "\"$commands\"")
        standardOutput = System.out
    }
}