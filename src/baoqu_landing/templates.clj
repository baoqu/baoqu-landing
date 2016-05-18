(ns baoqu-landing.templates
  (require [hiccup.core :refer [html]]))

(defn landing
  []
  (html
   [:html
    [:head
     [:title "Baoqu"]
     [:link {:rel "stylesheet" :href "/assets/css/main.css"}]]
    [:body
     [:div
      [:h1 "Baoqu Landing"]
      [:div#mail-form]]
     [:script {:type "text/javascript" :src "/assets/js/app.js"}]]]))
