grails.plugin.location."neo4j" = "../grails-data-mapping/grails-plugins/neo4j"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        excludes 'xml-apis', 'netty', 'stax-api', 'slf4j-jdk14','log4j-over-slf4j', 'logback-classic'
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve true // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true
        //grailsPlugins()
        //grailsHome()
        //grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //flatDir name:'myRepo', dirs:'/abc/def'
        //mavenLocal()
        //mavenCentral()
        //mavenRepo 'http://m2.neo4j.org/releases'
        //mavenRepo "https://repo.springsource.org/repo"
//        mavenRepo 'http://tinkerpop.com/maven2'
    }

    neo4jVerison="1.8.2"
    dependencies {

        //compile("org.neo4j:neo4j-community:$neo4jVerison")

        // next four lines are required if you're using embedded/ha *and* you want the webadmin available
        compile(group:"org.neo4j.app", name:"neo4j-server", version:neo4jVerison)
        runtime(group:"org.neo4j.app", name:"neo4j-server", version:neo4jVerison, branch:"static-web")
        runtime('com.sun.jersey:jersey-server:1.9')
        runtime('com.sun.jersey:jersey-core:1.9')

        // add graphviz capabilities
        compile(group:"org.neo4j", name:"neo4j-graphviz", version: neo4jVerison)
			//runtime (group:"org.neo4j", name:"neo4j-shell", version:""1.8.M07")

        // uncomment following line if type=rest is used in DataSource.groovy
        //compile "org.neo4j:neo4j-rest-graphdb:1.8.M07"

        //test 'org.databene:contiperf:2.0.0'
    }

	 plugins {
         runtime ":jquery:1.7.1"
         runtime ":resources:1.1.6"
         runtime ":spock:0.6"
         // compile ":geb:0.9.0-RC-1"

         // Uncomment these (or add new ones) to enable additional resources capabilities
         //runtime ":zipped-resources:1.0"
         //runtime ":cached-resources:1.0"
         //runtime ":yui-minify-resources:0.1.4"

         //build ":svn:1.0.2"
         build ":tomcat:$grailsVersion"
//         compile ':heroku:1.0.1'
//         compile ':cloud-support:1.0.8'
//         compile ':webxml:1.4.1'
     }
}
