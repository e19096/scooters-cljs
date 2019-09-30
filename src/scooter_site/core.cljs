(ns scooter-site.core
    (:require
      [reagent.core :as r]
      [scooter-site.data :refer [products]]))
      ; [scooter-site.data :as data]))

(def cart-count (r/atom 0))

(defn header []
  [:div {:class "Header-container"}
        [:span {:class "Header-title"} "E-scooter Emporium"]
        [:img {:src "/assets/logo.png" :class "Header-logo" :alt "logo"}]
        @cart-count [:i {:class "material-icons"} "shopping_cart"]])

(defn product-item [scooter]
  (let [{:keys [name price image] :as thing} scooter]
    [:div {:class "prod-item"}
      [:img {:src image}]
      [:div.details
        [:div name]
        [:div (get-in thing [:price :currency-symbol])
              (-> scooter :price :value)]
              [:button {:on-click #(swap! cart-count inc)}
              "Add"]]]))

(defn product-index []
  [:div {:class "prod-idx"} (map product-item products)])

(defn home-page []
  [:div [header]
        [product-index]])

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
