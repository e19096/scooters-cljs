(ns scooter-site.components.header)

(defn header []
  [:div {:class "Header-container"}
        [:span {:class "Header-title"} "E-scooter Emporium"]
        [:img {:src "/assets/logo.png" :class "Header-logo" :alt "logo"}]
        "0" [:i {:class "material-icons"} "shopping_cart"]])
