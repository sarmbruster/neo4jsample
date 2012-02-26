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
//        mavenRepo 'http://tinkerpop.com/maven2'
    }

    dependencies {

        // uncomment next three lines if you're using embedded/ha *and* you want the webadmin available
//        compile(group:"org.neo4j.app", name:"neo4j-server", version:"1.6.1")
//        runtime(group:"org.neo4j.app", name:"neo4j-server", version:"1.6.1", branch:"static-web")
//        runtime('com.sun.jersey:jersey-bundle:1.9')


        // uncomment following line if type=rest is used in DataSource.groovy
        compile("org.neo4j:neo4j-rest-graphdb:1.6")
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
