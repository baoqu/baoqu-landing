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
      [:h2 "Let's find out the ideas we share, no matter how many we are"]
      [:p "Baoqu is an Open Source for horizontal deliberation in massive groups in a whole new way. Yeah, new, belive us."]
      [:div "Mapping the conversation"]
      [:div "Trolling resilient"]
      [:div "Core gamificated"]
      [:div#mail-form]]
     [:script {:type "text/javascript" :src "/assets/js/app.js"}]]]))
