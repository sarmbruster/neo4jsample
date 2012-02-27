// Place your Spring DSL code here
beans = {

    // workaround for https://github.com/SpringSource/grails-data-mapping/issues/25
    graphDatabaseService(
            org.neo4j.rest.graphdb.RestGraphDatabase,
            "http://${System.env['NEO4J_HOST']}:${System.env['NEO4J_PORT']}/db/data",
            System.env['NEO4J_LOGIN'],
            System.env['NEO4J_PASSWORD']
    ) { bean ->
        bean.destroyMethod = "shutdown"
    }
}