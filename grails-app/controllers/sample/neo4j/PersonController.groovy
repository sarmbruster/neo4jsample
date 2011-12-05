package sample.neo4j

import org.neo4j.graphdb.index.IndexManager

class PersonController {

    static scaffold = true

    def graphDatabaseService

    def dummy = {
        IndexManager indexManager = graphDatabaseService.index()
        def index = indexManager.forNodes(Person.class.name)
        log.error "${indexManager.nodeIndexNames()} ${Person.class.name}"

        def hits = index.query('name', "Hans")
        render hits.collect { it}
    }

}
