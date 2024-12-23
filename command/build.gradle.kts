import kotlin.system.exitProcess

val commands = project.providers.gradleProperty("commands").get()

tasks.register("sh") {
    description = "Executes a shell command"
    group = "Custom"

    doLast {
        try {
            val process = ProcessBuilder("sh", "-c", commands)
                .redirectErrorStream(true)
                .start()

            process.inputStream.bufferedReader().useLines { lines ->
                lines.forEach { println(it) }
            }

            val exitCode = process.waitFor()
            println("Exit code: $exitCode")
        } catch (e: Exception) {
            println("Error executing command: ${e.localizedMessage}")
            exitProcess(1)
        }
    }
}