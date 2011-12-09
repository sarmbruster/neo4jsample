package sample.neo4j

import groovy.transform.ToString

@ToString(includes='name')
class Attendee {

    String name
    boolean earlyBird

    static hasMany = [ attendsTo: Talk ]

    static constraints = {
    }
}
