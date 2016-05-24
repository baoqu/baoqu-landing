(ns baoqu-landing.db
  (require [clojure.java.jdbc :as sql]
           [clojure.java.io :refer [as-file]]
           [baoqu-landing.configuration :refer [config]]))

(def db
  {:classname "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname (:db-path config)})

(defn create-db
  []
  (sql/db-do-commands db
                      (sql/create-table-ddl :users
                                            [:id "serial primary key"]
                                            [:created "date"]
                                            [:mail "varchar"])))

(defn safely-create-db
  []
  (let [db-file (:subname db)
        db-exists? (.exists (as-file db-file))]
    (if-not db-exists?
      (create-db))))
