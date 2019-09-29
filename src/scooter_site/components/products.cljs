(ns scooter-site.components.products
    (:require [scooter-site.data :as data]))


(defn product-item [product]
  (let [{:keys [name price image]} product]
    [:ul [:li name]
         [:li price]
         [:li [:img {:src image}]]]))

; (defn product-item [product]
;   [:ul [:li (:name product)]
;        [:li (:price product)]
;        [:li [:img {:src (:image product)}]]])

(defn product-index []
  [:div {:class "product-index"} "hi hi hi"
        (map product-item data/products)])
        ; (map #(-> % :name) data/products)])
        ; (map :name data/products)])
        ; (map #(:name %) data/products)])
        ; (map #(get % :name) data/products)])
        ; (map #(str %) data/products)])
        ; (map (fn [product] (str product)) data/products)])
        ; (map str data/products)])
