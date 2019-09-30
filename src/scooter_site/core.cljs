(ns scooter-site.core
    (:require
      [reagent.core :as r]
      [scooter-site.components.header :as h]
      [scooter-site.components.products :refer [product-index]]))
      ; [scooter-site.components.products :as prod]))

;; -------------------------
;; Views


(defn home-page []
  [:div [h/header]
        [product-index]])
        ; [prod/product-index]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
