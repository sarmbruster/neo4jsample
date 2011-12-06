//grails.plugin.location."neo4j" = "../neo4j"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //flatDir name:'myRepo', dirs:'/abc/def'
        mavenLocal()
        mavenCentral()
        mavenRepo 'http://m2.neo4j.org/releases'
        mavenRepo 'http://tinkerpop.com/maven2'
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {

        compile(group:"org.neo4j.app", name:"neo4j-server", version:"1.5") {
            excludes "slf4j-jdk14"
            excludes "log4j-over-slf4j"
            excludes "stax-api"
        }
        /*runtime(group:"org.neo4j.app", name:"neo4j-server", version:"1.5", branch:"static-web") {
            excludes "slf4j-jdk14"
            excludes "log4j-over-slf4j"
            excludes "stax-api"
        } */
        runtime('com.sun.jersey:jersey-bundle:1.9') {
            excludes "xml-apis"
        }

        /* uncomment the following block to use neo4j via rest */
        /*def neo4jRestExcludes = {
            excludes  "lucene-core"
            excludes  "neo4j-lucene-index"
            excludes  "neo4j-kernel"
		}
        compile("org.neo4j:neo4j-rest-graphdb:0.1-SNAPSHOT", neo4jRestExcludes) // excluded as of now since snapshot is not available via a m2 repo*/

        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
}
