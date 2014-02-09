# Neo4j for Grails sample application #

This repository contains a ready-to-go application for using Neo4j as a GORM backend for a Grails application.
Visit the [grails-data-mapping](http://springsource.github.com/grails-data-mapping/neo4j/manual/index.html) for details.

## hint for graphenedb ##

[GrapheneDB](http://www.graphenedb.com/) provides cloud hosted Neo4j databases. To use the Neo4j grails plugin you need to:

* set in `grails-app/conf/DataSource.groovy`: `type = "rest"`
* set up environment variables, e.g. on Linux:


    export NEO4J_HOST="<hostname provided by graphene>" # e.g. neo4jsample.sb01.stations.graphenedb.com"
    export NEO4J_LOGIN="<username provided by graphene>"
    export NEO4J_PASSWORD="<password provided by graphene>"
    export NEO4J_PORT="<portnumber provided by graphene>"

**WARNING: the 1.x series of the Neo4j Grails plugin do not rely on Cypher and therefore the performance with remote
databases is known as been rather poor. This will be fixed in the 2.0 releases of the plugin.**