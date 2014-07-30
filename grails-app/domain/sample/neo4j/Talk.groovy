package sample.neo4j

import groovy.transform.ToString

@ToString(includes='title')
class Talk {

    static belongsTo = Attendee

    String title
    Date date

    Speaker speaker

    static hasMany = [ attendees: Attendee ]

    static constraints = {
    }

    static mapWith = "neo4j"

}
