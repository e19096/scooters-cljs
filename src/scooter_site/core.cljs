(ns scooter-site.core
    (:require
      [reagent.core :as r]
      [scooter-site.components.header :as h]))

;; -------------------------
;; Views


(defn home-page []
  [:div [h/header]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
