grails.plugin.location."neo4j" = "../grails-data-mapping/grails-plugins/neo4j"
grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM

    // TODO: workaround, for Neo4j plugin forked mode is currently not working. Reason: Neo4jSpringConfigurer is using
    //    "as Classs" which causes ClassLoader issues
    run: false, //[maxMemory: 768, minMemory: 64, debug: true, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" 
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        excludes 'xml-apis', 'netty', 'stax-api', 'slf4j-jdk14','log4j-over-slf4j', 'logback-classic'
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //flatDir name:'myRepo', dirs:'/abc/def'
        mavenRepo 'http://m2.neo4j.org/content/repositories/releases/'
    }

    neo4jVerison="2.0.3"
    dependencies {
	//If using Groovy 2.4 uncomment the following line.
	//compile 'org.codehaus.groovy:groovy-backports-compat23:2.3.5'
        compile("org.neo4j:neo4j-community:$neo4jVerison")

        // this is required if DataSource.groovy uses url = "jdbc:neo4j:mem"
        //runtime(group:"org.neo4j", name:"neo4j-kernel", version:neo4jVerison, classifier:"tests")

        // next four lines are required if you're using embedded/ha *and* you want the webadmin available
        //compile(group:"org.neo4j.app", name:"neo4j-server", version:neo4jVerison)

        // grails dependencies do not properly support maven classifiers, therefor we'll copy that
        // dependency to lib directory
        //runtime(group:"org.neo4j.app", name:"neo4j-server", version:neo4jVerison, classifier:"static-web")

        //runtime('com.sun.jersey:jersey-server:1.9')
        //runtime('com.sun.jersey:jersey-core:1.9')

        // add graphviz capabilities
        compile(group:"org.neo4j", name:"neo4j-graphviz", version: neo4jVerison)
        runtime (group:"org.neo4j", name:"neo4j-shell", version: neo4jVerison)

        // uncomment following line if type=rest is used in DataSource.groovy
        //runtime "org.neo4j:neo4j-rest-graphdb:1.9"

        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

	 plugins {
//         compile ":neo4j:2.0.0-M02"
         compile ":scaffolding:2.0.1"
         runtime ":jquery:1.10.2.2"
         runtime ":resources:1.2.1"
         test(":spock:0.7") {
             exclude "spock-grails-support"
         }
         // compile ":geb:0.9.0-RC-1"

         // Uncomment these (or add new ones) to enable additional resources capabilities
         //runtime ":zipped-resources:1.0"
         //runtime ":cached-resources:1.0"
         //runtime ":yui-minify-resources:0.1.4"
//         runtime ":hibernate:3.6.10.7"
         // runtime ":hibernate4:4.1.11.6"

         build ":tomcat:7.0.50"
//         compile ':cloud-support:1.0.8'
//         compile ':webxml:1.4.1'
     }
}
