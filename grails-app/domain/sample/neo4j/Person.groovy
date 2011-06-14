package sample.neo4j

import org.springframework.datastore.mapping.annotation.Index

class Person {

    @Index
    String name

    static hasMany = [ friends: Person ]

    static constraints = {
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
