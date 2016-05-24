(ns baoqu-landing.core
  (require [compojure.core :refer :all]
           [compojure.route :as route]
           [baoqu-landing.templates :as t]
           [baoqu-landing.db :as db]
           [baoqu-landing.configuration :refer [config]]
           [cheshire.core :as json]
           [ring.middleware.params :refer [wrap-params]]
           [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn home
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (t/landing)})

(defn new-mail
  [req]
  {:status 201
   :headers {"Content-Type" "application/json"}})

(def app-routes
  (routes
   (route/resources "/")
   (GET "/" [] home)
   (POST "/newmail" [] new-mail)))

(def app
  (-> app-routes
      (wrap-params)))

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
