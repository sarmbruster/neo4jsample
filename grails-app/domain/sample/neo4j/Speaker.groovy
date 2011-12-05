package sample.neo4j

import groovy.transform.ToString

@ToString(includes='name')
class Speaker {

    String name

    static constraints = {
    }
}
