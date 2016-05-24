(ns baoqu-landing.core
  (require [compojure.core :refer :all]
           [compojure.route :as route]
           [baoqu-landing.templates :as t]
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
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/encode {:message "Todo OK"})})

(def app-routes
  (routes
   (route/resources "/")
   (GET "/" [] home)
   (POST "/newmail" [] new-mail)))

(def app
  (-> app-routes
      (wrap-params)))

(defn -main
  [& args]
  (jetty/run-jetty app {:port 3030}))

;; (defn new-mail
;;   [ctx]
;;   (let [data (:data ctx)]
;;     (println "Nuevo correo: " data)
;;     (http/ok (json/encode {:text "ALL GOOD"}) {:content-type "application/json"})))

;; (def app
;;   (ct/routes [[:any (misc/autoreloader)]
;;               [:any (parse/body-params)]
;;               [:all "" #'main-handler]
;;               [:post "newmail" #'new-mail]
;;               [:assets "assets" {:dir "public/assets"}]]))

;; (defn -main
;;   [& args]
;;   (ct/run-server app {:port 3030
;;                       :marker-file "basedir-marker"}))
