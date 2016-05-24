(ns baoqu-landing.templates
  (require [hiccup.core :refer [html]]))

(defn landing
  []
  (html
   [:html
    [:head
     [:title "Baoqu"]
     [:meta {:name "viewport" :content "width=device-width, user-scalable=no"}]
     [:link {:rel "stylesheet" :href "/assets/css/main.css"}]
     [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css?family=Open+Sans"}]]
    [:body
      [:div.mod-principal
        [:div.item.hero-unit
          [:div.header
            [:span.logo]
            [:h1 "Baoqu"]
          ]
          [:h2 "Online deliberation no matter how many we are"]
          [:div#form]
          [:div.hint "We are willing to enrole anyone who want to participate in the first test (coming soon), but also people who want to join us developing this."]
          [:div.links
            [:a.twitter {:href "https://twitter.com/_BaoQu_"} "Twitter"]
            [:a.github {:href "https://github.com/baoqu"} "Github"]
          ]]
        [:div.item.device
          [:ul.mobile
            [:li.screen.ideas]
            [:li.screen.map]
            [:li.screen.comments]
          ]]]
      [:div.mod-secondary
        [:p "Baoqu is an online tool for horizontal deliberation in massive groups in a whole new way. Deliberation trully bottom-up, without moderators or pre-setted agendas in a tool that allows discussion -rather than forms of voting- but still able to produce some output in form of agreement."]
        [:ul.benefits
          [:li.mapping
            [:h3 "Mapping the conversation"]
            [:p "We map visually the deliberation in a fractal way"]]
          [:li.trolling
            [:h3 "Trolling resilient"]
            [:p "System rules for crosspollination and troll resilience"]]
          [:li.open
            [:h3 "Open Source"]
            [:p "Baoqu is an open initiative being made in an open way"]]
        ]
        [:div#mail-form]]

        [:div.footer
          [:span.copy "Born on a "
            [:a {:href "http://piweek.tumblr.com"} "Piweek"]
            ", made with &#9829; and Open Source. "]
          [:span.email "infobaoqu [at] gmail.com. "]
        ]
     [:script {:type "text/javascript" :src "/assets/js/app.js"}]]]))
