(ns baoqu-landing.templates
  (require [hiccup.core :refer [html]]))

(defn landing
  []
  (html
   [:html
    [:head
     [:title "Baoqu"]
     [:link {:rel "stylesheet" :href "/assets/css/main.css"}]
     [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css?family=Open+Sans"}]]
    [:body
      [:span.logo]
     [:div.mod-principal
      [:h1 "Baoqu"]
      [:h2 "Let's find out the ideas we share, no matter how many we are"]
      [:div.form-box
        [:input {:placeholder "Leave us your email here"} ]
        [:button.btn "Join the conversation"]
      ]
      [:p "Baoqu is an Open Source for horizontal deliberation in massive groups in a whole new way. Yeah, new, belive us."]
      [:div "Mapping the conversation"]
      [:div "Trolling resilient"]
      [:div "Core gamificated"]
      [:div#mail-form]]
     [:script {:type "text/javascript" :src "/assets/js/app.js"}]]]))
