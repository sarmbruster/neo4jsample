dataSource {
    pooled = true
    driverClassName = "org.neo4j.jdbc.Driver"

    // use impermanent graph db, this requires an additional dependency in BuildConfig.groovy:
    // runtime(group:"org.neo4j", name:"neo4j-kernel", version:neo4jVerison, classifier:"tests")
    // url = "jdbc:neo4j:mem"

    // uncomment for embedded usage
    url = "jdbc:neo4j:instance:test"

    // use remote database
    //url = "jdbc:neo4j://localhost:7474/"

    // disabling autoCommit is crucial!
    properties = [
            defaultAutoCommit: false
    ]

//    username = "sa"
//    password = ""
}

// environment specific settings
/*environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=false
               validationQuery="SELECT 1"
               jdbcInterceptors="ConnectionState"
            }
        }
    }
} */
