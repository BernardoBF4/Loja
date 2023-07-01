(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logica :as l.logic]))

(println (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Invertido" (reverse (sort-by :preco-total resumo)))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))

; Traz o resumo dos pedidos dos usuários, ordenados pelo id do usuário
(defn resumo-ordenado-por-usuario
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :usuario-id)
       reverse))

(println "Resumo ordenado por usuário" (resumo-ordenado-por-usuario (l.db/todos-os-pedidos)))

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(println (resumo-por-usuario-ordenado (l.logic/resumo-por-usuario (l.db/todos-os-pedidos))))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Primeiro" (first resumo))
  (println "Segundo" (second resumo))
  (println "Resto" (rest resumo))
  (println "Total de itens" (count resumo))
  (println "Classe" (class resumo))
  (println "Enésimo" (nth resumo 0))
  (println "Get" (get resumo 1))
  (println "Take" (take 2 resumo)))




(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "> 500 filter" (filter #(> (:preco-total %) 500) resumo))
  (println "> 500 not empty?" (not (empty? (filter #(> (:preco-total %) 500) resumo))))
  (println "> 500 map" (map :usuario-id (filter #(> (:preco-total %) 500) resumo)))
  (println "> 500 some" (some #(> (:preco-total %) 500) resumo)))


































