//grails.plugin.location."neo4j" = "../neo4j"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        excludes 'xml-apis', 'netty', 'stax-api', 'slf4j-jdk14','log4j-over-slf4j'
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        inherits true
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

        compile(group:"org.neo4j.app", name:"neo4j-server", version:"1.6") /*{
            excludes "slf4j-jdk14"
            excludes "log4j-over-slf4j"
            excludes "stax-api"
        }*/
        /*runtime(group:"org.neo4j.app", name:"neo4j-server", version:"1.5", branch:"static-web") {
            excludes "slf4j-jdk14"
            excludes "log4j-over-slf4j"
            excludes "stax-api"
        } */
        runtime('com.sun.jersey:jersey-bundle:1.9') /*{
            excludes "xml-apis"
        }*/

        /* uncomment the following block to use neo4j via rest */
        /*def neo4jRestExcludes = {
            excludes  "lucene-core"
            excludes  "neo4j-lucene-index"
            excludes  "neo4j-kernel"
		}
        compile("org.neo4j:neo4j-rest-graphdb:0.1-SNAPSHOT", neo4jRestExcludes) // excluded as of now since snapshot is not available via a m2 repo*/
    }

	 plugins {
		  runtime ":neo4j:1.0.0.M1"
			runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

    }
}
