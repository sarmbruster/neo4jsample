package sample.neo4j

import groovy.transform.ToString

@ToString(includes='name')
class Person {

    String name

    static hasMany = [ friends: Person ]

    static constraints = {
        //friends nullable: true
    }

    @Override
    String toString() {
        name
    }

    @Override
    boolean equals(Object o) {
        if (o instanceof Person) {
            return id == o.id
        } else {
            return false
        }
    }


}
