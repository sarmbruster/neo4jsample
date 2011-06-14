grails {
    neo4j {
        // type is either "embedded" or "rest"
        // location: file path for embedded, url for rest

        type = "embedded"
        location = "data/neo4j"

//        type = "rest"
//        location = "http://localhost:7474/db/data/"

    }
}
