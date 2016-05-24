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
      [:div.mod-principal
        [:div.item.hero-unit
          [:div.header
            [:span.logo]
            [:h1 "Baoqu"]
          ]
          [:h2 "Let's find out the ideas we share, no matter how many we are"]
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
        [:p "Baoqu is an online tool for horizontal deliberation in massive groups in a whole new way. Yeah, new, belive us."]
        [:ul.benefits
          [:li "Mapping the conversation"]
          [:li "Trolling resilient"]
          [:li "Open Source"]
        ]
        [:div#mail-form]]

        [:div.footer
          [:span "infobaoqu [at] gmail.com. "]
          [:span "Born on a "
            [:a {:href "http://piweek.tumblr.com"} "Piweek"]
            ", made with &#9829; and Open Source."
          ]
        ]
     [:script {:type "text/javascript" :src "/assets/js/app.js"}]]]))
