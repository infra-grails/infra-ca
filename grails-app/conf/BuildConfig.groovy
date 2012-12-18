grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.plugin.location.'infra-file-storage' = "../infra-file-storage"
grails.plugin.location.'infra-images' = "../infra-images"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()

        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://artifactory.dev/repo"
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'org.pegdown:pegdown:latest.release'
        runtime "org.jsoup:jsoup:latest.release"
        runtime "org.parboiled:parboiled-java:latest.release"

        // runtime 'mysql:mysql-connector-java:5.1.18'
    }

    plugins {
        build(":tomcat:$grailsVersion",
                ":release:latest.release") {
            export = false
        }

        test ':spock:latest.release'
    }
}
