# A Demo of Using Embedded Postgresql in Gradle

## When and why do you want to use it?

- You want to run integration tests (or any task) in gradle against postgresql
- But you or your team members don't like the hassle of installing postgresql

## Usage

- Copy the embedpg.groovy and the startPg/stopPg tasks to your gradle project, and then make your task dependsOn startPg and finalizedBy stopPg.
- Two example tasks are included
    - Simulate the scenario that test goes well

        gradle simulateTestSuccess

    - Simulate the scenario that test goes bad 

        gradle simulateTestFailure

## Notes

- The groovy command is assumed to exist in your PATH, since startPg starts an external process using groovy
- I recommend the SDKMAN tool from [sdkman.io](http://sdkman.io) for installing groovy/gradle 
- You can also build an uber jar so that you only need java to start the external process
- Java 7+ is required for the postgresql-embedded library
- '127.0.0.1' is better than 'localhost' for binding the embedded postgresql, if there are multiple IP addresses bound to localhost

## Improvements

- Use gradle's local groovy instead of an external one
- Parameterize port, db name, username, password
- In case you want to parameterize the host, you also need to update the pg_hba.conf to include any host that is not local
