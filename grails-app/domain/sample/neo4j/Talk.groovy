package sample.neo4j

class Talk {

    String title
    Date date

    Speaker speaker

    static hasMany = [ attendees: Attendee ]

    static constraints = {
    }
}
