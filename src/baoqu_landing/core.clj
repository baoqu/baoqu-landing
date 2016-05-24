(ns baoqu-landing.core
  (require [compojure.core :refer :all]
           [compojure.route :as route]
           [baoqu-landing.templates :as t]
           [baoqu-landing.db :as db]
           [baoqu-landing.configuration :refer [config]]
           [ring.middleware.json :refer [wrap-json-body]]
           [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn home
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (t/landing)})

(defn new-mail
  [req]
  (let [mail (get-in req [:body "mail"])]
    (db/create-user mail))
  {:status 201
   :headers {"Content-Type" "application/json"}})

(def app-routes
  (routes
   (route/resources "/")
   (GET "/" [] home)
   (POST "/newmail" [] (wrap-json-body new-mail))))

(def app
  app-routes)

(defn bootstrap
  []
  (if (System/getenv "BL_DEBUG")
    (do
      (println "====================")
      (println "= DEBUG: true")
      (println "= Config:")
      (println config)
      (println "====================")))
  (db/safely-create-db))

(defn -main
  [& args]
  (jetty/run-jetty app {:port 3030}))
