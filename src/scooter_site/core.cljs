(ns scooter-site.core
    (:require
      [reagent.core :as r]))

(defn header []
  [:div {:class "Header-container"}
        [:span {:class "Header-title"} "E-scooter Emporium"]
        [:img {:src "/assets/logo.png" :class "Header-logo" :alt "logo"}]
        0 [:i {:class "material-icons"} "shopping_cart"]])

(defn home-page []
  [:div [header]])

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
