(ns baoqu-landing.configuration)

(defn env-or
  [env default]
  (or (System/getenv env) default))

(def config
  {:db-path (env-or "BL_DB_PATH" (str (System/getProperty "user.dir") "/baoqu-landing-db.sqlite"))
   :server-url (env-or "BL_SERVER_URL" "http://localhost:3030")})
