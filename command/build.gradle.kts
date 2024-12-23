import java.io.BufferedReader
import java.io.InputStreamReader

val commands = project.providers.gradleProperty("commands").get()

tasks.register("sh") {
    description = "Executes a shell command"
    group = "Custom"

    doLast {
        try {
            val process = ProcessBuilder("sh", "-c", "\"$commands\"")
                .redirectErrorStream(true)
                .start()

            val reader = BufferedReader(InputStreamReader(process.inputStream))
            reader.useLines { lines -> lines.forEach { println(it) } }

            val exitCode = process.waitFor()
            println("Exit code: $exitCode")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}