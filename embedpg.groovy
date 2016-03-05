@Grab('ru.yandex.qatools.embed:postgresql-embedded:1.9')
import ru.yandex.qatools.embed.postgresql.PostgresStarter
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig.Credentials
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig.Net
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig.Storage
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig.Timeout
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig
import ru.yandex.qatools.embed.postgresql.distribution.Version

runtime = PostgresStarter.getDefaultInstance()
config = new PostgresConfig(
        Version.V9_3_6,
        new Net("127.0.0.1", 35791),
        new Storage("testdb"),
        new Timeout(),
        new Credentials("testuser", "password")
)
exec = runtime.prepare(config)
p = exec.start()
println 'DB Dir: ' + config.storage().dbDir()
println 'PG PID: ' + p.processId
println "EMBED-PG-STARTED" // signal that the DB is ready

System.in.read() // wait for stop signal
p.stop()
