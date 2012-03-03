package sample.neo4j

import org.neo4j.graphdb.TraversalPosition
import org.neo4j.graphdb.StopEvaluator
import org.neo4j.graphdb.ReturnableEvaluator

class SpeakerController {

    def scaffold = true

    def search() {
        render Speaker.where { name=='Peter'}.list()
    }

    def cypher() {
        render Speaker.cypherStatic("start n=node({this}) match n-[:INSTANCE]->m return m")
    }

    def traverse() {
        render Speaker.traverseStatic(

                { TraversalPosition tp ->
                    //log.error "${tp.depth()}, ${tp.currentNode().id}"
                    tp.depth() in (1..2)
                } as StopEvaluator,

                ReturnableEvaluator.ALL_BUT_START_NODE
        )
    }
}