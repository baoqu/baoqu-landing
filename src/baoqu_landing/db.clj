(ns baoqu-landing.db
  (require [baoqu-landing.configuration :refer [config]]
           [hugsql.core :as hugsql]
           [clojure.java.jdbc :as sql]
           [clojure.java.io :refer [as-file]])
  (import java.sql.Date))

(def db
  {:classname "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname (:db-path config)})

(hugsql/def-db-fns "sql/users.sql")

(defn get-sql-now-date
  []
  (->> (new java.util.Date)
       (.getTime)
       (new java.sql.Date)))

(defn create-db
  []
  (sql/db-do-commands db
                      (sql/create-table-ddl :users
                                            [:id "serial primary key"]
                                            [:created "date"]
                                            [:mail "varchar unique"])))

(defn safely-create-db
  []
  (let [db-file (:subname db)
        db-exists? (.exists (as-file db-file))]
    (if-not db-exists?
      (create-db))))

(defn create-user
  [mail]
  (let [exists? (get-user-by-mail db {:mail mail})]
    (if-not exists?
      (insert-user db {:mail mail :created (get-sql-now-date)}))))
