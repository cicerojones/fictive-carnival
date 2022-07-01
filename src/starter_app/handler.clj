(ns starter-app.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cheshire.core :as json]))

(defroutes app-routes
  (GET "/" [] "Fuck off world")
  (GET "/rude-json" []
       {:status 200
        :headers {"Content-Type" "application/json; charset=utf-8"}
        :body (json/generate-string
               {:name "Fuck Nah Dog"
                :status "Straight Fucking"})})
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
